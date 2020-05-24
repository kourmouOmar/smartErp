package eleves

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ClasseController {

    ClasseService classeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond classeService.list(params), model:[classeCount: classeService.count()]
    }

    def show(Long id) {
        respond classeService.get(id)
    }

    def create() {
        respond new Classe(params)
    }

    def save(Classe classe) {
        if (classe == null) {
            notFound()
            return
        }

        try {
            classeService.save(classe)
        } catch (ValidationException e) {
            respond classe.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'classe.label', default: 'Classe'), classe.id])
                redirect classe
            }
            '*' { respond classe, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond classeService.get(id)
    }

    def update(Classe classe) {
        if (classe == null) {
            notFound()
            return
        }

        try {
            classeService.save(classe)
        } catch (ValidationException e) {
            respond classe.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'classe.label', default: 'Classe'), classe.id])
                redirect classe
            }
            '*'{ respond classe, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        classeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'classe.label', default: 'Classe'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'classe.label', default: 'Classe'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
