package eleves

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ControleController {

    ControleService controleService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond controleService.list(params), model:[controleCount: controleService.count()]
    }

    def show(Long id) {
        respond controleService.get(id)
    }

    def create() {
        respond new Controle(params)
    }

    def save(Controle controle) {
        if (controle == null) {
            notFound()
            return
        }

        try {
            controleService.save(controle)
        } catch (ValidationException e) {
            respond controle.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'controle.label', default: 'Controle'), controle.id])
                redirect controle
            }
            '*' { respond controle, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond controleService.get(id)
    }

    def update(Controle controle) {
        if (controle == null) {
            notFound()
            return
        }

        try {
            controleService.save(controle)
        } catch (ValidationException e) {
            respond controle.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'controle.label', default: 'Controle'), controle.id])
                redirect controle
            }
            '*'{ respond controle, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        controleService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'controle.label', default: 'Controle'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'controle.label', default: 'Controle'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
