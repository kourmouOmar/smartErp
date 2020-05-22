package materiel

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MaterielServiceSpec extends Specification {

    MaterielService materielService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Materiel(...).save(flush: true, failOnError: true)
        //new Materiel(...).save(flush: true, failOnError: true)
        //Materiel materiel = new Materiel(...).save(flush: true, failOnError: true)
        //new Materiel(...).save(flush: true, failOnError: true)
        //new Materiel(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //materiel.id
    }

    void "test get"() {
        setupData()

        expect:
        materielService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Materiel> materielList = materielService.list(max: 2, offset: 2)

        then:
        materielList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        materielService.count() == 5
    }

    void "test delete"() {
        Long materielId = setupData()

        expect:
        materielService.count() == 5

        when:
        materielService.delete(materielId)
        sessionFactory.currentSession.flush()

        then:
        materielService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Materiel materiel = new Materiel()
        materielService.save(materiel)

        then:
        materiel.id != null
    }
}
