package smarterp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MarqueController {

    MarqueService marqueService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond marqueService.list(params), model:[marqueCount: marqueService.count()]
    }

    def show(Long id) {
        respond marqueService.get(id)
    }

    def create() {
        respond new Marque(params)
    }

    def save(Marque marque) {
        if (marque == null) {
            notFound()
            return
        }

        try {
            marqueService.save(marque)
        } catch (ValidationException e) {
            respond marque.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'marque.label', default: 'Marque'), marque.id])
                redirect marque
            }
            '*' { respond marque, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond marqueService.get(id)
    }

    def update(Marque marque) {
        if (marque == null) {
            notFound()
            return
        }

        try {
            marqueService.save(marque)
        } catch (ValidationException e) {
            respond marque.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'marque.label', default: 'Marque'), marque.id])
                redirect marque
            }
            '*'{ respond marque, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        marqueService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'marque.label', default: 'Marque'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'marque.label', default: 'Marque'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
