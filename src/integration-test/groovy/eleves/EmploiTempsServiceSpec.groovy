package eleves

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EmploiTempsServiceSpec extends Specification {

    EmploiTempsService emploiTempsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new EmploiTemps(...).save(flush: true, failOnError: true)
        //new EmploiTemps(...).save(flush: true, failOnError: true)
        //EmploiTemps emploiTemps = new EmploiTemps(...).save(flush: true, failOnError: true)
        //new EmploiTemps(...).save(flush: true, failOnError: true)
        //new EmploiTemps(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //emploiTemps.id
    }

    void "test get"() {
        setupData()

        expect:
        emploiTempsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<EmploiTemps> emploiTempsList = emploiTempsService.list(max: 2, offset: 2)

        then:
        emploiTempsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        emploiTempsService.count() == 5
    }

    void "test delete"() {
        Long emploiTempsId = setupData()

        expect:
        emploiTempsService.count() == 5

        when:
        emploiTempsService.delete(emploiTempsId)
        sessionFactory.currentSession.flush()

        then:
        emploiTempsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        EmploiTemps emploiTemps = new EmploiTemps()
        emploiTempsService.save(emploiTemps)

        then:
        emploiTemps.id != null
    }
}
