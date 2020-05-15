package smarterp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TypeEntretienServiceSpec extends Specification {

    TypeEntretienService typeEntretienService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TypeEntretien(...).save(flush: true, failOnError: true)
        //new TypeEntretien(...).save(flush: true, failOnError: true)
        //TypeEntretien typeEntretien = new TypeEntretien(...).save(flush: true, failOnError: true)
        //new TypeEntretien(...).save(flush: true, failOnError: true)
        //new TypeEntretien(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //typeEntretien.id
    }

    void "test get"() {
        setupData()

        expect:
        typeEntretienService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TypeEntretien> typeEntretienList = typeEntretienService.list(max: 2, offset: 2)

        then:
        typeEntretienList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        typeEntretienService.count() == 5
    }

    void "test delete"() {
        Long typeEntretienId = setupData()

        expect:
        typeEntretienService.count() == 5

        when:
        typeEntretienService.delete(typeEntretienId)
        sessionFactory.currentSession.flush()

        then:
        typeEntretienService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TypeEntretien typeEntretien = new TypeEntretien()
        typeEntretienService.save(typeEntretien)

        then:
        typeEntretien.id != null
    }
}
