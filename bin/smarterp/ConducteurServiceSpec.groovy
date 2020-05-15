package smarterp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ConducteurServiceSpec extends Specification {

    ConducteurService conducteurService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Conducteur(...).save(flush: true, failOnError: true)
        //new Conducteur(...).save(flush: true, failOnError: true)
        //Conducteur conducteur = new Conducteur(...).save(flush: true, failOnError: true)
        //new Conducteur(...).save(flush: true, failOnError: true)
        //new Conducteur(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //conducteur.id
    }

    void "test get"() {
        setupData()

        expect:
        conducteurService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Conducteur> conducteurList = conducteurService.list(max: 2, offset: 2)

        then:
        conducteurList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        conducteurService.count() == 5
    }

    void "test delete"() {
        Long conducteurId = setupData()

        expect:
        conducteurService.count() == 5

        when:
        conducteurService.delete(conducteurId)
        sessionFactory.currentSession.flush()

        then:
        conducteurService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Conducteur conducteur = new Conducteur()
        conducteurService.save(conducteur)

        then:
        conducteur.id != null
    }
}
