package smarterp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ReparationController {

    ReparationService reparationService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond reparationService.list(params), model:[reparationCount: reparationService.count()]
    }

    def show(Long id) {
        respond reparationService.get(id)
    }

    def create() {
        respond new Reparation(params)
    }

    def save(Reparation reparation) {
        if (reparation == null) {
            notFound()
            return
        }

        try {
            reparationService.save(reparation)
        } catch (ValidationException e) {
            respond reparation.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'reparation.label', default: 'Reparation'), reparation.id])
                redirect reparation
            }
            '*' { respond reparation, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond reparationService.get(id)
    }

    def update(Reparation reparation) {
        if (reparation == null) {
            notFound()
            return
        }

        try {
            reparationService.save(reparation)
        } catch (ValidationException e) {
            respond reparation.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'reparation.label', default: 'Reparation'), reparation.id])
                redirect reparation
            }
            '*'{ respond reparation, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        reparationService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'reparation.label', default: 'Reparation'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'reparation.label', default: 'Reparation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
