package eleves

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AbsenceEleveController {

    AbsenceEleveService absenceEleveService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond absenceEleveService.list(params), model:[absenceEleveCount: absenceEleveService.count()]
    }

    def show(Long id) {
        respond absenceEleveService.get(id)
    }

    def create() {
        respond new AbsenceEleve(params)
    }

    def save(AbsenceEleve absenceEleve) {
        if (absenceEleve == null) {
            notFound()
            return
        }

        try {
            absenceEleveService.save(absenceEleve)
        } catch (ValidationException e) {
            respond absenceEleve.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'absenceEleve.label', default: 'AbsenceEleve'), absenceEleve.id])
                redirect absenceEleve
            }
            '*' { respond absenceEleve, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond absenceEleveService.get(id)
    }

    def update(AbsenceEleve absenceEleve) {
        if (absenceEleve == null) {
            notFound()
            return
        }

        try {
            absenceEleveService.save(absenceEleve)
        } catch (ValidationException e) {
            respond absenceEleve.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'absenceEleve.label', default: 'AbsenceEleve'), absenceEleve.id])
                redirect absenceEleve
            }
            '*'{ respond absenceEleve, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        absenceEleveService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'absenceEleve.label', default: 'AbsenceEleve'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'absenceEleve.label', default: 'AbsenceEleve'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
