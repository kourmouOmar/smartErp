package smarterp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ReparationServiceSpec extends Specification {

    ReparationService reparationService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Reparation(...).save(flush: true, failOnError: true)
        //new Reparation(...).save(flush: true, failOnError: true)
        //Reparation reparation = new Reparation(...).save(flush: true, failOnError: true)
        //new Reparation(...).save(flush: true, failOnError: true)
        //new Reparation(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //reparation.id
    }

    void "test get"() {
        setupData()

        expect:
        reparationService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Reparation> reparationList = reparationService.list(max: 2, offset: 2)

        then:
        reparationList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        reparationService.count() == 5
    }

    void "test delete"() {
        Long reparationId = setupData()

        expect:
        reparationService.count() == 5

        when:
        reparationService.delete(reparationId)
        sessionFactory.currentSession.flush()

        then:
        reparationService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Reparation reparation = new Reparation()
        reparationService.save(reparation)

        then:
        reparation.id != null
    }
}
