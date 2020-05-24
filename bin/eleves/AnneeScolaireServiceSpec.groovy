package eleves

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AnneeScolaireServiceSpec extends Specification {

    AnneeScolaireService anneeScolaireService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new AnneeScolaire(...).save(flush: true, failOnError: true)
        //new AnneeScolaire(...).save(flush: true, failOnError: true)
        //AnneeScolaire anneeScolaire = new AnneeScolaire(...).save(flush: true, failOnError: true)
        //new AnneeScolaire(...).save(flush: true, failOnError: true)
        //new AnneeScolaire(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //anneeScolaire.id
    }

    void "test get"() {
        setupData()

        expect:
        anneeScolaireService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<AnneeScolaire> anneeScolaireList = anneeScolaireService.list(max: 2, offset: 2)

        then:
        anneeScolaireList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        anneeScolaireService.count() == 5
    }

    void "test delete"() {
        Long anneeScolaireId = setupData()

        expect:
        anneeScolaireService.count() == 5

        when:
        anneeScolaireService.delete(anneeScolaireId)
        sessionFactory.currentSession.flush()

        then:
        anneeScolaireService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        AnneeScolaire anneeScolaire = new AnneeScolaire()
        anneeScolaireService.save(anneeScolaire)

        then:
        anneeScolaire.id != null
    }
}
