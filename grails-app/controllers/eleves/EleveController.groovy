package eleves

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EleveController {

    EleveService eleveService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond eleveService.list(params), model:[eleveCount: eleveService.count()]
    }

    def show(Long id) {
        respond eleveService.get(id)
    }

    def create() {
        respond new Eleve(params)
    }

    def save(Eleve eleve) {
        if (eleve == null) {
            notFound()
            return
        }

        try {
            eleveService.save(eleve)
        } catch (ValidationException e) {
            respond eleve.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'eleve.label', default: 'Eleve'), eleve.id])
                redirect eleve
            }
            '*' { respond eleve, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond eleveService.get(id)
    }

    def update(Eleve eleve) {
        if (eleve == null) {
            notFound()
            return
        }

        try {
            eleveService.save(eleve)
        } catch (ValidationException e) {
            respond eleve.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'eleve.label', default: 'Eleve'), eleve.id])
                redirect eleve
            }
            '*'{ respond eleve, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        eleveService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'eleve.label', default: 'Eleve'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'eleve.label', default: 'Eleve'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
