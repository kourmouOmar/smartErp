package smarterp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EntretienServiceSpec extends Specification {

    EntretienService entretienService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Entretien(...).save(flush: true, failOnError: true)
        //new Entretien(...).save(flush: true, failOnError: true)
        //Entretien entretien = new Entretien(...).save(flush: true, failOnError: true)
        //new Entretien(...).save(flush: true, failOnError: true)
        //new Entretien(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //entretien.id
    }

    void "test get"() {
        setupData()

        expect:
        entretienService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Entretien> entretienList = entretienService.list(max: 2, offset: 2)

        then:
        entretienList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        entretienService.count() == 5
    }

    void "test delete"() {
        Long entretienId = setupData()

        expect:
        entretienService.count() == 5

        when:
        entretienService.delete(entretienId)
        sessionFactory.currentSession.flush()

        then:
        entretienService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Entretien entretien = new Entretien()
        entretienService.save(entretien)

        then:
        entretien.id != null
    }
}
