package eleves

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SalleServiceSpec extends Specification {

    SalleService salleService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Salle(...).save(flush: true, failOnError: true)
        //new Salle(...).save(flush: true, failOnError: true)
        //Salle salle = new Salle(...).save(flush: true, failOnError: true)
        //new Salle(...).save(flush: true, failOnError: true)
        //new Salle(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //salle.id
    }

    void "test get"() {
        setupData()

        expect:
        salleService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Salle> salleList = salleService.list(max: 2, offset: 2)

        then:
        salleList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        salleService.count() == 5
    }

    void "test delete"() {
        Long salleId = setupData()

        expect:
        salleService.count() == 5

        when:
        salleService.delete(salleId)
        sessionFactory.currentSession.flush()

        then:
        salleService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Salle salle = new Salle()
        salleService.save(salle)

        then:
        salle.id != null
    }
}
