package professeurs

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AbsenceProfesseurServiceSpec extends Specification {

    AbsenceProfesseurService absenceProfesseurService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new AbsenceProfesseur(...).save(flush: true, failOnError: true)
        //new AbsenceProfesseur(...).save(flush: true, failOnError: true)
        //AbsenceProfesseur absenceProfesseur = new AbsenceProfesseur(...).save(flush: true, failOnError: true)
        //new AbsenceProfesseur(...).save(flush: true, failOnError: true)
        //new AbsenceProfesseur(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //absenceProfesseur.id
    }

    void "test get"() {
        setupData()

        expect:
        absenceProfesseurService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<AbsenceProfesseur> absenceProfesseurList = absenceProfesseurService.list(max: 2, offset: 2)

        then:
        absenceProfesseurList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        absenceProfesseurService.count() == 5
    }

    void "test delete"() {
        Long absenceProfesseurId = setupData()

        expect:
        absenceProfesseurService.count() == 5

        when:
        absenceProfesseurService.delete(absenceProfesseurId)
        sessionFactory.currentSession.flush()

        then:
        absenceProfesseurService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        AbsenceProfesseur absenceProfesseur = new AbsenceProfesseur()
        absenceProfesseurService.save(absenceProfesseur)

        then:
        absenceProfesseur.id != null
    }
}
