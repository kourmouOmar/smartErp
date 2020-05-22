package materiel

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MaterielController {

    MaterielService materielService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond materielService.list(params), model:[materielCount: materielService.count()]
    }
    // def index() {
    //     redirect(action: "list", params: params)
    // }

    // def list(Integer max) {
    //     params.max = Math.min(max ?: 10, 100)
    //     [materielInstanceList: Materiel.findAll(), materielInstanceTotal: Materiel.count()]
    // }
    def show(Long id) {
        respond materielService.get(id)
    }

    def create() {
        respond new Materiel(params)
    }

    def save(Materiel materiel) {
        if (materiel == null) {
            notFound()
            return
        }

        try {
            materielService.save(materiel)
        } catch (ValidationException e) {
            respond materiel.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'materiel.label', default: 'Materiel'), materiel.id])
                redirect materiel
            }
            '*' { respond materiel, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond materielService.get(id)
    }

    def update(Materiel materiel) {
        if (materiel == null) {
            notFound()
            return
        }

        try {
            materielService.save(materiel)
        } catch (ValidationException e) {
            respond materiel.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'materiel.label', default: 'Materiel'), materiel.id])
                redirect materiel
            }
            '*'{ respond materiel, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        materielService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'materiel.label', default: 'Materiel'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'materiel.label', default: 'Materiel'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
