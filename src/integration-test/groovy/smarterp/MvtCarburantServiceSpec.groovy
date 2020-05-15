package smarterp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MvtCarburantServiceSpec extends Specification {

    MvtCarburantService mvtCarburantService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new MvtCarburant(...).save(flush: true, failOnError: true)
        //new MvtCarburant(...).save(flush: true, failOnError: true)
        //MvtCarburant mvtCarburant = new MvtCarburant(...).save(flush: true, failOnError: true)
        //new MvtCarburant(...).save(flush: true, failOnError: true)
        //new MvtCarburant(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //mvtCarburant.id
    }

    void "test get"() {
        setupData()

        expect:
        mvtCarburantService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<MvtCarburant> mvtCarburantList = mvtCarburantService.list(max: 2, offset: 2)

        then:
        mvtCarburantList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        mvtCarburantService.count() == 5
    }

    void "test delete"() {
        Long mvtCarburantId = setupData()

        expect:
        mvtCarburantService.count() == 5

        when:
        mvtCarburantService.delete(mvtCarburantId)
        sessionFactory.currentSession.flush()

        then:
        mvtCarburantService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        MvtCarburant mvtCarburant = new MvtCarburant()
        mvtCarburantService.save(mvtCarburant)

        then:
        mvtCarburant.id != null
    }
}
