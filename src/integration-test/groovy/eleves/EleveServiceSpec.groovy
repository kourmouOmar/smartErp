package eleves

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EleveServiceSpec extends Specification {

    EleveService eleveService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Eleve(...).save(flush: true, failOnError: true)
        //new Eleve(...).save(flush: true, failOnError: true)
        //Eleve eleve = new Eleve(...).save(flush: true, failOnError: true)
        //new Eleve(...).save(flush: true, failOnError: true)
        //new Eleve(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //eleve.id
    }

    void "test get"() {
        setupData()

        expect:
        eleveService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Eleve> eleveList = eleveService.list(max: 2, offset: 2)

        then:
        eleveList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        eleveService.count() == 5
    }

    void "test delete"() {
        Long eleveId = setupData()

        expect:
        eleveService.count() == 5

        when:
        eleveService.delete(eleveId)
        sessionFactory.currentSession.flush()

        then:
        eleveService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Eleve eleve = new Eleve()
        eleveService.save(eleve)

        then:
        eleve.id != null
    }
}
