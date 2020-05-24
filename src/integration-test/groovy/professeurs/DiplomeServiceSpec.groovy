package professeurs

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DiplomeServiceSpec extends Specification {

    DiplomeService diplomeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Diplome(...).save(flush: true, failOnError: true)
        //new Diplome(...).save(flush: true, failOnError: true)
        //Diplome diplome = new Diplome(...).save(flush: true, failOnError: true)
        //new Diplome(...).save(flush: true, failOnError: true)
        //new Diplome(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //diplome.id
    }

    void "test get"() {
        setupData()

        expect:
        diplomeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Diplome> diplomeList = diplomeService.list(max: 2, offset: 2)

        then:
        diplomeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        diplomeService.count() == 5
    }

    void "test delete"() {
        Long diplomeId = setupData()

        expect:
        diplomeService.count() == 5

        when:
        diplomeService.delete(diplomeId)
        sessionFactory.currentSession.flush()

        then:
        diplomeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Diplome diplome = new Diplome()
        diplomeService.save(diplome)

        then:
        diplome.id != null
    }
}
