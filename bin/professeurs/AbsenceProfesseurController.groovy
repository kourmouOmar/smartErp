package professeurs

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AbsenceProfesseurController {

    AbsenceProfesseurService absenceProfesseurService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond absenceProfesseurService.list(params), model:[absenceProfesseurCount: absenceProfesseurService.count()]
    }

    def show(Long id) {
        respond absenceProfesseurService.get(id)
    }

    def create() {
        respond new AbsenceProfesseur(params)
    }

    def save(AbsenceProfesseur absenceProfesseur) {
        if (absenceProfesseur == null) {
            notFound()
            return
        }

        try {
            absenceProfesseurService.save(absenceProfesseur)
        } catch (ValidationException e) {
            respond absenceProfesseur.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'absenceProfesseur.label', default: 'AbsenceProfesseur'), absenceProfesseur.id])
                redirect absenceProfesseur
            }
            '*' { respond absenceProfesseur, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond absenceProfesseurService.get(id)
    }

    def update(AbsenceProfesseur absenceProfesseur) {
        if (absenceProfesseur == null) {
            notFound()
            return
        }

        try {
            absenceProfesseurService.save(absenceProfesseur)
        } catch (ValidationException e) {
            respond absenceProfesseur.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'absenceProfesseur.label', default: 'AbsenceProfesseur'), absenceProfesseur.id])
                redirect absenceProfesseur
            }
            '*'{ respond absenceProfesseur, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        absenceProfesseurService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'absenceProfesseur.label', default: 'AbsenceProfesseur'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'absenceProfesseur.label', default: 'AbsenceProfesseur'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
