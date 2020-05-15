package smarterp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TypeCarburantController {

    TypeCarburantService typeCarburantService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond typeCarburantService.list(params), model:[typeCarburantCount: typeCarburantService.count()]
    }

    def show(Long id) {
        respond typeCarburantService.get(id)
    }

    def create() {
        respond new TypeCarburant(params)
    }

    def save(TypeCarburant typeCarburant) {
        if (typeCarburant == null) {
            notFound()
            return
        }

        try {
            typeCarburantService.save(typeCarburant)
        } catch (ValidationException e) {
            respond typeCarburant.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'typeCarburant.label', default: 'TypeCarburant'), typeCarburant.id])
                redirect typeCarburant
            }
            '*' { respond typeCarburant, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond typeCarburantService.get(id)
    }

    def update(TypeCarburant typeCarburant) {
        if (typeCarburant == null) {
            notFound()
            return
        }

        try {
            typeCarburantService.save(typeCarburant)
        } catch (ValidationException e) {
            respond typeCarburant.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'typeCarburant.label', default: 'TypeCarburant'), typeCarburant.id])
                redirect typeCarburant
            }
            '*'{ respond typeCarburant, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        typeCarburantService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'typeCarburant.label', default: 'TypeCarburant'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'typeCarburant.label', default: 'TypeCarburant'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
