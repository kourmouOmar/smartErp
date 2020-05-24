package eleves

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SalleController {

    SalleService salleService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond salleService.list(params), model:[salleCount: salleService.count()]
    }

    def show(Long id) {
        respond salleService.get(id)
    }

    def create() {
        respond new Salle(params)
    }

    def save(Salle salle) {
        if (salle == null) {
            notFound()
            return
        }

        try {
            salleService.save(salle)
        } catch (ValidationException e) {
            respond salle.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'salle.label', default: 'Salle'), salle.id])
                redirect salle
            }
            '*' { respond salle, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond salleService.get(id)
    }

    def update(Salle salle) {
        if (salle == null) {
            notFound()
            return
        }

        try {
            salleService.save(salle)
        } catch (ValidationException e) {
            respond salle.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'salle.label', default: 'Salle'), salle.id])
                redirect salle
            }
            '*'{ respond salle, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        salleService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'salle.label', default: 'Salle'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'salle.label', default: 'Salle'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
