package eleves

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AnneeScolaireController {

    AnneeScolaireService anneeScolaireService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond anneeScolaireService.list(params), model:[anneeScolaireCount: anneeScolaireService.count()]
    }

    def show(Long id) {
        respond anneeScolaireService.get(id)
    }

    def create() {
        respond new AnneeScolaire(params)
    }

    def save(AnneeScolaire anneeScolaire) {
        if (anneeScolaire == null) {
            notFound()
            return
        }

        try {
            anneeScolaireService.save(anneeScolaire)
        } catch (ValidationException e) {
            respond anneeScolaire.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'anneeScolaire.label', default: 'AnneeScolaire'), anneeScolaire.id])
                redirect anneeScolaire
            }
            '*' { respond anneeScolaire, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond anneeScolaireService.get(id)
    }

    def update(AnneeScolaire anneeScolaire) {
        if (anneeScolaire == null) {
            notFound()
            return
        }

        try {
            anneeScolaireService.save(anneeScolaire)
        } catch (ValidationException e) {
            respond anneeScolaire.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'anneeScolaire.label', default: 'AnneeScolaire'), anneeScolaire.id])
                redirect anneeScolaire
            }
            '*'{ respond anneeScolaire, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        anneeScolaireService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'anneeScolaire.label', default: 'AnneeScolaire'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'anneeScolaire.label', default: 'AnneeScolaire'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
