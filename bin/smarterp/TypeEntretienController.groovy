package smarterp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TypeEntretienController {

    TypeEntretienService typeEntretienService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond typeEntretienService.list(params), model:[typeEntretienCount: typeEntretienService.count()]
    }

    def show(Long id) {
        respond typeEntretienService.get(id)
    }

    def create() {
        respond new TypeEntretien(params)
    }

    def save(TypeEntretien typeEntretien) {
        if (typeEntretien == null) {
            notFound()
            return
        }

        try {
            typeEntretienService.save(typeEntretien)
        } catch (ValidationException e) {
            respond typeEntretien.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'typeEntretien.label', default: 'TypeEntretien'), typeEntretien.id])
                redirect typeEntretien
            }
            '*' { respond typeEntretien, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond typeEntretienService.get(id)
    }

    def update(TypeEntretien typeEntretien) {
        if (typeEntretien == null) {
            notFound()
            return
        }

        try {
            typeEntretienService.save(typeEntretien)
        } catch (ValidationException e) {
            respond typeEntretien.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'typeEntretien.label', default: 'TypeEntretien'), typeEntretien.id])
                redirect typeEntretien
            }
            '*'{ respond typeEntretien, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        typeEntretienService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'typeEntretien.label', default: 'TypeEntretien'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'typeEntretien.label', default: 'TypeEntretien'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
