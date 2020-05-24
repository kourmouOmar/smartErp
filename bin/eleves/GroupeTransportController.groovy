package eleves

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class GroupeTransportController {

    GroupeTransportService groupeTransportService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond groupeTransportService.list(params), model:[groupeTransportCount: groupeTransportService.count()]
    }

    def show(Long id) {
        respond groupeTransportService.get(id)
    }

    def create() {
        respond new GroupeTransport(params)
    }

    def save(GroupeTransport groupeTransport) {
        if (groupeTransport == null) {
            notFound()
            return
        }

        try {
            groupeTransportService.save(groupeTransport)
        } catch (ValidationException e) {
            respond groupeTransport.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'groupeTransport.label', default: 'GroupeTransport'), groupeTransport.id])
                redirect groupeTransport
            }
            '*' { respond groupeTransport, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond groupeTransportService.get(id)
    }

    def update(GroupeTransport groupeTransport) {
        if (groupeTransport == null) {
            notFound()
            return
        }

        try {
            groupeTransportService.save(groupeTransport)
        } catch (ValidationException e) {
            respond groupeTransport.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'groupeTransport.label', default: 'GroupeTransport'), groupeTransport.id])
                redirect groupeTransport
            }
            '*'{ respond groupeTransport, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        groupeTransportService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'groupeTransport.label', default: 'GroupeTransport'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'groupeTransport.label', default: 'GroupeTransport'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
