package smarterp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EntretienController {

    EntretienService entretienService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond entretienService.list(params), model:[entretienCount: entretienService.count()]
    }

    def show(Long id) {
        respond entretienService.get(id)
    }

    def create() {
        respond new Entretien(params)
    }

    def save(Entretien entretien) {
        if (entretien == null) {
            notFound()
            return
        }

        try {
            entretienService.save(entretien)
        } catch (ValidationException e) {
            respond entretien.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'entretien.label', default: 'Entretien'), entretien.id])
                redirect entretien
            }
            '*' { respond entretien, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond entretienService.get(id)
    }

    def update(Entretien entretien) {
        if (entretien == null) {
            notFound()
            return
        }

        try {
            entretienService.save(entretien)
        } catch (ValidationException e) {
            respond entretien.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'entretien.label', default: 'Entretien'), entretien.id])
                redirect entretien
            }
            '*'{ respond entretien, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        entretienService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'entretien.label', default: 'Entretien'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'entretien.label', default: 'Entretien'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
