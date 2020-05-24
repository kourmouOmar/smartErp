package eleves

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RetardEleveController {

    RetardEleveService retardEleveService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond retardEleveService.list(params), model:[retardEleveCount: retardEleveService.count()]
    }

    def show(Long id) {
        respond retardEleveService.get(id)
    }

    def create() {
        respond new RetardEleve(params)
    }

    def save(RetardEleve retardEleve) {
        if (retardEleve == null) {
            notFound()
            return
        }

        try {
            retardEleveService.save(retardEleve)
        } catch (ValidationException e) {
            respond retardEleve.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'retardEleve.label', default: 'RetardEleve'), retardEleve.id])
                redirect retardEleve
            }
            '*' { respond retardEleve, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond retardEleveService.get(id)
    }

    def update(RetardEleve retardEleve) {
        if (retardEleve == null) {
            notFound()
            return
        }

        try {
            retardEleveService.save(retardEleve)
        } catch (ValidationException e) {
            respond retardEleve.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'retardEleve.label', default: 'RetardEleve'), retardEleve.id])
                redirect retardEleve
            }
            '*'{ respond retardEleve, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        retardEleveService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'retardEleve.label', default: 'RetardEleve'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'retardEleve.label', default: 'RetardEleve'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
