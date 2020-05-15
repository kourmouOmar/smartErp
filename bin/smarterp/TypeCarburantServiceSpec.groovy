package smarterp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TypeCarburantServiceSpec extends Specification {

    TypeCarburantService typeCarburantService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TypeCarburant(...).save(flush: true, failOnError: true)
        //new TypeCarburant(...).save(flush: true, failOnError: true)
        //TypeCarburant typeCarburant = new TypeCarburant(...).save(flush: true, failOnError: true)
        //new TypeCarburant(...).save(flush: true, failOnError: true)
        //new TypeCarburant(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //typeCarburant.id
    }

    void "test get"() {
        setupData()

        expect:
        typeCarburantService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TypeCarburant> typeCarburantList = typeCarburantService.list(max: 2, offset: 2)

        then:
        typeCarburantList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        typeCarburantService.count() == 5
    }

    void "test delete"() {
        Long typeCarburantId = setupData()

        expect:
        typeCarburantService.count() == 5

        when:
        typeCarburantService.delete(typeCarburantId)
        sessionFactory.currentSession.flush()

        then:
        typeCarburantService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TypeCarburant typeCarburant = new TypeCarburant()
        typeCarburantService.save(typeCarburant)

        then:
        typeCarburant.id != null
    }
}
