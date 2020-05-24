package eleves

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class GroupeTransportServiceSpec extends Specification {

    GroupeTransportService groupeTransportService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new GroupeTransport(...).save(flush: true, failOnError: true)
        //new GroupeTransport(...).save(flush: true, failOnError: true)
        //GroupeTransport groupeTransport = new GroupeTransport(...).save(flush: true, failOnError: true)
        //new GroupeTransport(...).save(flush: true, failOnError: true)
        //new GroupeTransport(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //groupeTransport.id
    }

    void "test get"() {
        setupData()

        expect:
        groupeTransportService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<GroupeTransport> groupeTransportList = groupeTransportService.list(max: 2, offset: 2)

        then:
        groupeTransportList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        groupeTransportService.count() == 5
    }

    void "test delete"() {
        Long groupeTransportId = setupData()

        expect:
        groupeTransportService.count() == 5

        when:
        groupeTransportService.delete(groupeTransportId)
        sessionFactory.currentSession.flush()

        then:
        groupeTransportService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        GroupeTransport groupeTransport = new GroupeTransport()
        groupeTransportService.save(groupeTransport)

        then:
        groupeTransport.id != null
    }
}
