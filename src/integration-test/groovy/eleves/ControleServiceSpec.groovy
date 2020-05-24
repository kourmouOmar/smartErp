package eleves

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ControleServiceSpec extends Specification {

    ControleService controleService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Controle(...).save(flush: true, failOnError: true)
        //new Controle(...).save(flush: true, failOnError: true)
        //Controle controle = new Controle(...).save(flush: true, failOnError: true)
        //new Controle(...).save(flush: true, failOnError: true)
        //new Controle(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //controle.id
    }

    void "test get"() {
        setupData()

        expect:
        controleService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Controle> controleList = controleService.list(max: 2, offset: 2)

        then:
        controleList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        controleService.count() == 5
    }

    void "test delete"() {
        Long controleId = setupData()

        expect:
        controleService.count() == 5

        when:
        controleService.delete(controleId)
        sessionFactory.currentSession.flush()

        then:
        controleService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Controle controle = new Controle()
        controleService.save(controle)

        then:
        controle.id != null
    }
}
