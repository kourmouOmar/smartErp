package eleves

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AncienneEcoleController {

    AncienneEcoleService ancienneEcoleService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ancienneEcoleService.list(params), model:[ancienneEcoleCount: ancienneEcoleService.count()]
    }

    def show(Long id) {
        respond ancienneEcoleService.get(id)
    }

    def create() {
        respond new AncienneEcole(params)
    }

    def save(AncienneEcole ancienneEcole) {
        if (ancienneEcole == null) {
            notFound()
            return
        }

        try {
            ancienneEcoleService.save(ancienneEcole)
        } catch (ValidationException e) {
            respond ancienneEcole.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ancienneEcole.label', default: 'AncienneEcole'), ancienneEcole.id])
                redirect ancienneEcole
            }
            '*' { respond ancienneEcole, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond ancienneEcoleService.get(id)
    }

    def update(AncienneEcole ancienneEcole) {
        if (ancienneEcole == null) {
            notFound()
            return
        }

        try {
            ancienneEcoleService.save(ancienneEcole)
        } catch (ValidationException e) {
            respond ancienneEcole.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ancienneEcole.label', default: 'AncienneEcole'), ancienneEcole.id])
                redirect ancienneEcole
            }
            '*'{ respond ancienneEcole, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        ancienneEcoleService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ancienneEcole.label', default: 'AncienneEcole'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ancienneEcole.label', default: 'AncienneEcole'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
