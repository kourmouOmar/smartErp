package eleves

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EmploiTempsController {

    EmploiTempsService emploiTempsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond emploiTempsService.list(params), model:[emploiTempsCount: emploiTempsService.count()]
    }

    def show(Long id) {
        respond emploiTempsService.get(id)
    }

    def create() {
        respond new EmploiTemps(params)
    }

    def save(EmploiTemps emploiTemps) {
        if (emploiTemps == null) {
            notFound()
            return
        }

        try {
            emploiTempsService.save(emploiTemps)
        } catch (ValidationException e) {
            respond emploiTemps.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'emploiTemps.label', default: 'EmploiTemps'), emploiTemps.id])
                redirect emploiTemps
            }
            '*' { respond emploiTemps, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond emploiTempsService.get(id)
    }

    def update(EmploiTemps emploiTemps) {
        if (emploiTemps == null) {
            notFound()
            return
        }

        try {
            emploiTempsService.save(emploiTemps)
        } catch (ValidationException e) {
            respond emploiTemps.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'emploiTemps.label', default: 'EmploiTemps'), emploiTemps.id])
                redirect emploiTemps
            }
            '*'{ respond emploiTemps, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        emploiTempsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'emploiTemps.label', default: 'EmploiTemps'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'emploiTemps.label', default: 'EmploiTemps'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
