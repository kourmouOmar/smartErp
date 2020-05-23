package materiel

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DepartementController {

    DepartementService departementService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond departementService.list(params), model:[departementCount: departementService.count()]
    }

    def show(Long id) {
        respond departementService.get(id)
    }

    def create() {
        respond new Departement(params)
    }

    def save(Departement departement) {
        if (departement == null) {
            notFound()
            return
        }

        try {
            departementService.save(departement)
        } catch (ValidationException e) {
            respond departement.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'departement.label', default: 'Departement'), departement.id])
                redirect departement
            }
            '*' { respond departement, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond departementService.get(id)
    }

    def update(Departement departement) {
        if (departement == null) {
            notFound()
            return
        }

        try {
            departementService.save(departement)
        } catch (ValidationException e) {
            respond departement.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'departement.label', default: 'Departement'), departement.id])
                redirect departement
            }
            '*'{ respond departement, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        departementService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'departement.label', default: 'Departement'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'departement.label', default: 'Departement'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
