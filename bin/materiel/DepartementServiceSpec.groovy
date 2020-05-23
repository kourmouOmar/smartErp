package materiel

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DepartementServiceSpec extends Specification {

    DepartementService departementService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Departement(...).save(flush: true, failOnError: true)
        //new Departement(...).save(flush: true, failOnError: true)
        //Departement departement = new Departement(...).save(flush: true, failOnError: true)
        //new Departement(...).save(flush: true, failOnError: true)
        //new Departement(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //departement.id
    }

    void "test get"() {
        setupData()

        expect:
        departementService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Departement> departementList = departementService.list(max: 2, offset: 2)

        then:
        departementList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        departementService.count() == 5
    }

    void "test delete"() {
        Long departementId = setupData()

        expect:
        departementService.count() == 5

        when:
        departementService.delete(departementId)
        sessionFactory.currentSession.flush()

        then:
        departementService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Departement departement = new Departement()
        departementService.save(departement)

        then:
        departement.id != null
    }
}
