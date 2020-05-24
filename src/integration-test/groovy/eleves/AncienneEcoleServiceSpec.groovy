package eleves

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AncienneEcoleServiceSpec extends Specification {

    AncienneEcoleService ancienneEcoleService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new AncienneEcole(...).save(flush: true, failOnError: true)
        //new AncienneEcole(...).save(flush: true, failOnError: true)
        //AncienneEcole ancienneEcole = new AncienneEcole(...).save(flush: true, failOnError: true)
        //new AncienneEcole(...).save(flush: true, failOnError: true)
        //new AncienneEcole(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //ancienneEcole.id
    }

    void "test get"() {
        setupData()

        expect:
        ancienneEcoleService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<AncienneEcole> ancienneEcoleList = ancienneEcoleService.list(max: 2, offset: 2)

        then:
        ancienneEcoleList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        ancienneEcoleService.count() == 5
    }

    void "test delete"() {
        Long ancienneEcoleId = setupData()

        expect:
        ancienneEcoleService.count() == 5

        when:
        ancienneEcoleService.delete(ancienneEcoleId)
        sessionFactory.currentSession.flush()

        then:
        ancienneEcoleService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        AncienneEcole ancienneEcole = new AncienneEcole()
        ancienneEcoleService.save(ancienneEcole)

        then:
        ancienneEcole.id != null
    }
}
