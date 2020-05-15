package smarterp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ModeleServiceSpec extends Specification {

    ModeleService modeleService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Modele(...).save(flush: true, failOnError: true)
        //new Modele(...).save(flush: true, failOnError: true)
        //Modele modele = new Modele(...).save(flush: true, failOnError: true)
        //new Modele(...).save(flush: true, failOnError: true)
        //new Modele(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //modele.id
    }

    void "test get"() {
        setupData()

        expect:
        modeleService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Modele> modeleList = modeleService.list(max: 2, offset: 2)

        then:
        modeleList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        modeleService.count() == 5
    }

    void "test delete"() {
        Long modeleId = setupData()

        expect:
        modeleService.count() == 5

        when:
        modeleService.delete(modeleId)
        sessionFactory.currentSession.flush()

        then:
        modeleService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Modele modele = new Modele()
        modeleService.save(modele)

        then:
        modele.id != null
    }
}
