package professeurs

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DiplomeController {

    DiplomeService diplomeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond diplomeService.list(params), model:[diplomeCount: diplomeService.count()]
    }

    def show(Long id) {
        respond diplomeService.get(id)
    }

    def create() {
        respond new Diplome(params)
    }

    def save(Diplome diplome) {
        if (diplome == null) {
            notFound()
            return
        }

        try {
            diplomeService.save(diplome)
        } catch (ValidationException e) {
            respond diplome.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'diplome.label', default: 'Diplome'), diplome.id])
                redirect diplome
            }
            '*' { respond diplome, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond diplomeService.get(id)
    }

    def update(Diplome diplome) {
        if (diplome == null) {
            notFound()
            return
        }

        try {
            diplomeService.save(diplome)
        } catch (ValidationException e) {
            respond diplome.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'diplome.label', default: 'Diplome'), diplome.id])
                redirect diplome
            }
            '*'{ respond diplome, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        diplomeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'diplome.label', default: 'Diplome'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'diplome.label', default: 'Diplome'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
