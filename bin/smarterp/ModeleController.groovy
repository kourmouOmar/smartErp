package smarterp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ModeleController {

    ModeleService modeleService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond modeleService.list(params), model:[modeleCount: modeleService.count()]
    }

    def show(Long id) {
        respond modeleService.get(id)
    }

    def create() {
        respond new Modele(params)
    }

    def save(Modele modele) {
        if (modele == null) {
            notFound()
            return
        }

        try {
            modeleService.save(modele)
        } catch (ValidationException e) {
            respond modele.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'modele.label', default: 'Modele'), modele.id])
                redirect modele
            }
            '*' { respond modele, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond modeleService.get(id)
    }

    def update(Modele modele) {
        if (modele == null) {
            notFound()
            return
        }

        try {
            modeleService.save(modele)
        } catch (ValidationException e) {
            respond modele.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'modele.label', default: 'Modele'), modele.id])
                redirect modele
            }
            '*'{ respond modele, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        modeleService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'modele.label', default: 'Modele'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'modele.label', default: 'Modele'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
