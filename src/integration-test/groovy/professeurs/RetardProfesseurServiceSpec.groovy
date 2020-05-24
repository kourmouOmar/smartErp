package professeurs

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RetardProfesseurServiceSpec extends Specification {

    RetardProfesseurService retardProfesseurService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new RetardProfesseur(...).save(flush: true, failOnError: true)
        //new RetardProfesseur(...).save(flush: true, failOnError: true)
        //RetardProfesseur retardProfesseur = new RetardProfesseur(...).save(flush: true, failOnError: true)
        //new RetardProfesseur(...).save(flush: true, failOnError: true)
        //new RetardProfesseur(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //retardProfesseur.id
    }

    void "test get"() {
        setupData()

        expect:
        retardProfesseurService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<RetardProfesseur> retardProfesseurList = retardProfesseurService.list(max: 2, offset: 2)

        then:
        retardProfesseurList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        retardProfesseurService.count() == 5
    }

    void "test delete"() {
        Long retardProfesseurId = setupData()

        expect:
        retardProfesseurService.count() == 5

        when:
        retardProfesseurService.delete(retardProfesseurId)
        sessionFactory.currentSession.flush()

        then:
        retardProfesseurService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        RetardProfesseur retardProfesseur = new RetardProfesseur()
        retardProfesseurService.save(retardProfesseur)

        then:
        retardProfesseur.id != null
    }
}
