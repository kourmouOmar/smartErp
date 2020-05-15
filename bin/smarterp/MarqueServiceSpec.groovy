package smarterp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MarqueServiceSpec extends Specification {

    MarqueService marqueService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Marque(...).save(flush: true, failOnError: true)
        //new Marque(...).save(flush: true, failOnError: true)
        //Marque marque = new Marque(...).save(flush: true, failOnError: true)
        //new Marque(...).save(flush: true, failOnError: true)
        //new Marque(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //marque.id
    }

    void "test get"() {
        setupData()

        expect:
        marqueService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Marque> marqueList = marqueService.list(max: 2, offset: 2)

        then:
        marqueList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        marqueService.count() == 5
    }

    void "test delete"() {
        Long marqueId = setupData()

        expect:
        marqueService.count() == 5

        when:
        marqueService.delete(marqueId)
        sessionFactory.currentSession.flush()

        then:
        marqueService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Marque marque = new Marque()
        marqueService.save(marque)

        then:
        marque.id != null
    }
}
