package materiel

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FournisseurMaterielController {

    FournisseurMaterielService fournisseurMaterielService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond fournisseurMaterielService.list(params), model:[fournisseurMaterielCount: fournisseurMaterielService.count()]
    }

    def show(Long id) {
        respond fournisseurMaterielService.get(id)
    }

    def create() {
        respond new FournisseurMateriel(params)
    }

    def save(FournisseurMateriel fournisseurMateriel) {
        if (fournisseurMateriel == null) {
            notFound()
            return
        }

        try {
            fournisseurMaterielService.save(fournisseurMateriel)
        } catch (ValidationException e) {
            respond fournisseurMateriel.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'fournisseurMateriel.label', default: 'FournisseurMateriel'), fournisseurMateriel.id])
                redirect fournisseurMateriel
            }
            '*' { respond fournisseurMateriel, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond fournisseurMaterielService.get(id)
    }

    def update(FournisseurMateriel fournisseurMateriel) {
        if (fournisseurMateriel == null) {
            notFound()
            return
        }

        try {
            fournisseurMaterielService.save(fournisseurMateriel)
        } catch (ValidationException e) {
            respond fournisseurMateriel.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'fournisseurMateriel.label', default: 'FournisseurMateriel'), fournisseurMateriel.id])
                redirect fournisseurMateriel
            }
            '*'{ respond fournisseurMateriel, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        fournisseurMaterielService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'fournisseurMateriel.label', default: 'FournisseurMateriel'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'fournisseurMateriel.label', default: 'FournisseurMateriel'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
