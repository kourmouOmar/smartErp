package smarterp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VehiculeServiceSpec extends Specification {

    VehiculeService vehiculeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Vehicule(...).save(flush: true, failOnError: true)
        //new Vehicule(...).save(flush: true, failOnError: true)
        //Vehicule vehicule = new Vehicule(...).save(flush: true, failOnError: true)
        //new Vehicule(...).save(flush: true, failOnError: true)
        //new Vehicule(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vehicule.id
    }

    void "test get"() {
        setupData()

        expect:
        vehiculeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Vehicule> vehiculeList = vehiculeService.list(max: 2, offset: 2)

        then:
        vehiculeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vehiculeService.count() == 5
    }

    void "test delete"() {
        Long vehiculeId = setupData()

        expect:
        vehiculeService.count() == 5

        when:
        vehiculeService.delete(vehiculeId)
        sessionFactory.currentSession.flush()

        then:
        vehiculeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Vehicule vehicule = new Vehicule()
        vehiculeService.save(vehicule)

        then:
        vehicule.id != null
    }
}
