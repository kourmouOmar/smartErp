package professeurs

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ProfesseurServiceSpec extends Specification {

    ProfesseurService professeurService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Professeur(...).save(flush: true, failOnError: true)
        //new Professeur(...).save(flush: true, failOnError: true)
        //Professeur professeur = new Professeur(...).save(flush: true, failOnError: true)
        //new Professeur(...).save(flush: true, failOnError: true)
        //new Professeur(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //professeur.id
    }

    void "test get"() {
        setupData()

        expect:
        professeurService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Professeur> professeurList = professeurService.list(max: 2, offset: 2)

        then:
        professeurList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        professeurService.count() == 5
    }

    void "test delete"() {
        Long professeurId = setupData()

        expect:
        professeurService.count() == 5

        when:
        professeurService.delete(professeurId)
        sessionFactory.currentSession.flush()

        then:
        professeurService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Professeur professeur = new Professeur()
        professeurService.save(professeur)

        then:
        professeur.id != null
    }
}
