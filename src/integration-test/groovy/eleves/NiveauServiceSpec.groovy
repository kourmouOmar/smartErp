package eleves

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class NiveauServiceSpec extends Specification {

    NiveauService niveauService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Niveau(...).save(flush: true, failOnError: true)
        //new Niveau(...).save(flush: true, failOnError: true)
        //Niveau niveau = new Niveau(...).save(flush: true, failOnError: true)
        //new Niveau(...).save(flush: true, failOnError: true)
        //new Niveau(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //niveau.id
    }

    void "test get"() {
        setupData()

        expect:
        niveauService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Niveau> niveauList = niveauService.list(max: 2, offset: 2)

        then:
        niveauList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        niveauService.count() == 5
    }

    void "test delete"() {
        Long niveauId = setupData()

        expect:
        niveauService.count() == 5

        when:
        niveauService.delete(niveauId)
        sessionFactory.currentSession.flush()

        then:
        niveauService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Niveau niveau = new Niveau()
        niveauService.save(niveau)

        then:
        niveau.id != null
    }
}
