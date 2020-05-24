package eleves

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RetardEleveServiceSpec extends Specification {

    RetardEleveService retardEleveService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new RetardEleve(...).save(flush: true, failOnError: true)
        //new RetardEleve(...).save(flush: true, failOnError: true)
        //RetardEleve retardEleve = new RetardEleve(...).save(flush: true, failOnError: true)
        //new RetardEleve(...).save(flush: true, failOnError: true)
        //new RetardEleve(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //retardEleve.id
    }

    void "test get"() {
        setupData()

        expect:
        retardEleveService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<RetardEleve> retardEleveList = retardEleveService.list(max: 2, offset: 2)

        then:
        retardEleveList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        retardEleveService.count() == 5
    }

    void "test delete"() {
        Long retardEleveId = setupData()

        expect:
        retardEleveService.count() == 5

        when:
        retardEleveService.delete(retardEleveId)
        sessionFactory.currentSession.flush()

        then:
        retardEleveService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        RetardEleve retardEleve = new RetardEleve()
        retardEleveService.save(retardEleve)

        then:
        retardEleve.id != null
    }
}
