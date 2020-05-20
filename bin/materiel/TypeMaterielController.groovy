package materiel

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TypeMaterielController {

    TypeMaterielService typeMaterielService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond typeMaterielService.list(params), model:[typeMaterielCount: typeMaterielService.count()]
    }

    def show(Long id) {
        respond typeMaterielService.get(id)
    }

    def create() {
        respond new TypeMateriel(params)
    }

    def save(TypeMateriel typeMateriel) {
        if (typeMateriel == null) {
            notFound()
            return
        }

        try {
            typeMaterielService.save(typeMateriel)
        } catch (ValidationException e) {
            respond typeMateriel.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'typeMateriel.label', default: 'TypeMateriel'), typeMateriel.id])
                redirect typeMateriel
            }
            '*' { respond typeMateriel, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond typeMaterielService.get(id)
    }

    def update(TypeMateriel typeMateriel) {
        if (typeMateriel == null) {
            notFound()
            return
        }

        try {
            typeMaterielService.save(typeMateriel)
        } catch (ValidationException e) {
            respond typeMateriel.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'typeMateriel.label', default: 'TypeMateriel'), typeMateriel.id])
                redirect typeMateriel
            }
            '*'{ respond typeMateriel, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        typeMaterielService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'typeMateriel.label', default: 'TypeMateriel'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'typeMateriel.label', default: 'TypeMateriel'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
