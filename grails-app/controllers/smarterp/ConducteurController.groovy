package smarterp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ConducteurController {

    ConducteurService conducteurService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond conducteurService.list(params), model:[conducteurCount: conducteurService.count()]
    }

    def show(Long id) {
        respond conducteurService.get(id)
    }

    def create() {
        respond new Conducteur(params)
    }

    def save(Conducteur conducteur) {
        if (conducteur == null) {
            notFound()
            return
        }

        try {
            conducteurService.save(conducteur)
        } catch (ValidationException e) {
            respond conducteur.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'conducteur.label', default: 'Conducteur'), conducteur.id])
                redirect conducteur
            }
            '*' { respond conducteur, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond conducteurService.get(id)
    }

    def update(Conducteur conducteur) {
        if (conducteur == null) {
            notFound()
            return
        }

        try {
            conducteurService.save(conducteur)
        } catch (ValidationException e) {
            respond conducteur.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'conducteur.label', default: 'Conducteur'), conducteur.id])
                redirect conducteur
            }
            '*'{ respond conducteur, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        conducteurService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'conducteur.label', default: 'Conducteur'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'conducteur.label', default: 'Conducteur'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
