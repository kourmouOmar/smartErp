package eleves

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class NiveauController {

    NiveauService niveauService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond niveauService.list(params), model:[niveauCount: niveauService.count()]
    }

    def show(Long id) {
        respond niveauService.get(id)
    }

    def create() {
        respond new Niveau(params)
    }

    def save(Niveau niveau) {
        if (niveau == null) {
            notFound()
            return
        }

        try {
            niveauService.save(niveau)
        } catch (ValidationException e) {
            respond niveau.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'niveau.label', default: 'Niveau'), niveau.id])
                redirect niveau
            }
            '*' { respond niveau, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond niveauService.get(id)
    }

    def update(Niveau niveau) {
        if (niveau == null) {
            notFound()
            return
        }

        try {
            niveauService.save(niveau)
        } catch (ValidationException e) {
            respond niveau.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'niveau.label', default: 'Niveau'), niveau.id])
                redirect niveau
            }
            '*'{ respond niveau, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        niveauService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'niveau.label', default: 'Niveau'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'niveau.label', default: 'Niveau'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
