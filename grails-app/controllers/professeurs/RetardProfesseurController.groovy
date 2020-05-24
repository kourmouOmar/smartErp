package professeurs

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RetardProfesseurController {

    RetardProfesseurService retardProfesseurService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond retardProfesseurService.list(params), model:[retardProfesseurCount: retardProfesseurService.count()]
    }

    def show(Long id) {
        respond retardProfesseurService.get(id)
    }

    def create() {
        respond new RetardProfesseur(params)
    }

    def save(RetardProfesseur retardProfesseur) {
        if (retardProfesseur == null) {
            notFound()
            return
        }

        try {
            retardProfesseurService.save(retardProfesseur)
        } catch (ValidationException e) {
            respond retardProfesseur.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'retardProfesseur.label', default: 'RetardProfesseur'), retardProfesseur.id])
                redirect retardProfesseur
            }
            '*' { respond retardProfesseur, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond retardProfesseurService.get(id)
    }

    def update(RetardProfesseur retardProfesseur) {
        if (retardProfesseur == null) {
            notFound()
            return
        }

        try {
            retardProfesseurService.save(retardProfesseur)
        } catch (ValidationException e) {
            respond retardProfesseur.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'retardProfesseur.label', default: 'RetardProfesseur'), retardProfesseur.id])
                redirect retardProfesseur
            }
            '*'{ respond retardProfesseur, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        retardProfesseurService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'retardProfesseur.label', default: 'RetardProfesseur'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'retardProfesseur.label', default: 'RetardProfesseur'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
