package smarterp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MvtCarburantController {

    MvtCarburantService mvtCarburantService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond mvtCarburantService.list(params), model:[mvtCarburantCount: mvtCarburantService.count()]
    }

    def show(Long id) {
        respond mvtCarburantService.get(id)
    }

    def create() {
        respond new MvtCarburant(params)
    }

    def save(MvtCarburant mvtCarburant) {
        if (mvtCarburant == null) {
            notFound()
            return
        }

        try {
            mvtCarburantService.save(mvtCarburant)
        } catch (ValidationException e) {
            respond mvtCarburant.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mvtCarburant.label', default: 'MvtCarburant'), mvtCarburant.id])
                redirect mvtCarburant
            }
            '*' { respond mvtCarburant, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond mvtCarburantService.get(id)
    }

    def update(MvtCarburant mvtCarburant) {
        if (mvtCarburant == null) {
            notFound()
            return
        }

        try {
            mvtCarburantService.save(mvtCarburant)
        } catch (ValidationException e) {
            respond mvtCarburant.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'mvtCarburant.label', default: 'MvtCarburant'), mvtCarburant.id])
                redirect mvtCarburant
            }
            '*'{ respond mvtCarburant, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        mvtCarburantService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'mvtCarburant.label', default: 'MvtCarburant'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mvtCarburant.label', default: 'MvtCarburant'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
