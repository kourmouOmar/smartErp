package smarterp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AffectationVoitureController {

    AffectationVoitureService affectationVoitureService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond affectationVoitureService.list(params), model:[affectationVoitureCount: affectationVoitureService.count()]
    }

    def show(Long id) {
        respond affectationVoitureService.get(id)
    }

    def create() {
        respond new AffectationVoiture(params)
    }

    def save(AffectationVoiture affectationVoiture) {
        if (affectationVoiture == null) {
            notFound()
            return
        }

        try {
            affectationVoitureService.save(affectationVoiture)
        } catch (ValidationException e) {
            respond affectationVoiture.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'affectationVoiture.label', default: 'AffectationVoiture'), affectationVoiture.id])
                redirect affectationVoiture
            }
            '*' { respond affectationVoiture, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond affectationVoitureService.get(id)
    }

    def update(AffectationVoiture affectationVoiture) {
        if (affectationVoiture == null) {
            notFound()
            return
        }

        try {
            affectationVoitureService.save(affectationVoiture)
        } catch (ValidationException e) {
            respond affectationVoiture.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'affectationVoiture.label', default: 'AffectationVoiture'), affectationVoiture.id])
                redirect affectationVoiture
            }
            '*'{ respond affectationVoiture, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        affectationVoitureService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'affectationVoiture.label', default: 'AffectationVoiture'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'affectationVoiture.label', default: 'AffectationVoiture'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
