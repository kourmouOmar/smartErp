package smarterp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class VehiculeController {

    VehiculeService vehiculeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vehiculeService.list(params), model:[vehiculeCount: vehiculeService.count()]
    }

    def show(Long id) {
        respond vehiculeService.get(id)
    }

    def create() {
        respond new Vehicule(params)
    }

    def save(Vehicule vehicule) {
        if (vehicule == null) {
            notFound()
            return
        }

        try {
            vehiculeService.save(vehicule)
        } catch (ValidationException e) {
            respond vehicule.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vehicule.label', default: 'Vehicule'), vehicule.id])
                redirect vehicule
            }
            '*' { respond vehicule, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vehiculeService.get(id)
    }

    def update(Vehicule vehicule) {
        if (vehicule == null) {
            notFound()
            return
        }

        try {
            vehiculeService.save(vehicule)
        } catch (ValidationException e) {
            respond vehicule.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vehicule.label', default: 'Vehicule'), vehicule.id])
                redirect vehicule
            }
            '*'{ respond vehicule, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vehiculeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vehicule.label', default: 'Vehicule'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vehicule.label', default: 'Vehicule'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
