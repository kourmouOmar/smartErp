package smarterp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class FournisseurController {

    FournisseurService fournisseurService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond fournisseurService.list(params), model:[fournisseurCount: fournisseurService.count()]
    }

    def show(Long id) {
        respond fournisseurService.get(id)
    }

    def create() {
        respond new Fournisseur(params)
    }

    def save(Fournisseur fournisseur) {
        if (fournisseur == null) {
            notFound()
            return
        }

        try {
            fournisseurService.save(fournisseur)
        } catch (ValidationException e) {
            respond fournisseur.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'fournisseur.label', default: 'Fournisseur'), fournisseur.id])
                redirect fournisseur
            }
            '*' { respond fournisseur, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond fournisseurService.get(id)
    }

    def update(Fournisseur fournisseur) {
        if (fournisseur == null) {
            notFound()
            return
        }

        try {
            fournisseurService.save(fournisseur)
        } catch (ValidationException e) {
            respond fournisseur.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'fournisseur.label', default: 'Fournisseur'), fournisseur.id])
                redirect fournisseur
            }
            '*'{ respond fournisseur, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        fournisseurService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'fournisseur.label', default: 'Fournisseur'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'fournisseur.label', default: 'Fournisseur'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
