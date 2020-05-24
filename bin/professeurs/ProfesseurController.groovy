package professeurs

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ProfesseurController {

    ProfesseurService professeurService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond professeurService.list(params), model:[professeurCount: professeurService.count()]
    }

    def show(Long id) {
        respond professeurService.get(id)
    }

    def create() {
        respond new Professeur(params)
    }

    def save(Professeur professeur) {
        if (professeur == null) {
            notFound()
            return
        }

        try {
            professeurService.save(professeur)
        } catch (ValidationException e) {
            respond professeur.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'professeur.label', default: 'Professeur'), professeur.id])
                redirect professeur
            }
            '*' { respond professeur, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond professeurService.get(id)
    }

    def update(Professeur professeur) {
        if (professeur == null) {
            notFound()
            return
        }

        try {
            professeurService.save(professeur)
        } catch (ValidationException e) {
            respond professeur.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'professeur.label', default: 'Professeur'), professeur.id])
                redirect professeur
            }
            '*'{ respond professeur, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        professeurService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'professeur.label', default: 'Professeur'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'professeur.label', default: 'Professeur'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
