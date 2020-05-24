package eleves

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ClasseServiceSpec extends Specification {

    ClasseService classeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Classe(...).save(flush: true, failOnError: true)
        //new Classe(...).save(flush: true, failOnError: true)
        //Classe classe = new Classe(...).save(flush: true, failOnError: true)
        //new Classe(...).save(flush: true, failOnError: true)
        //new Classe(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //classe.id
    }

    void "test get"() {
        setupData()

        expect:
        classeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Classe> classeList = classeService.list(max: 2, offset: 2)

        then:
        classeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        classeService.count() == 5
    }

    void "test delete"() {
        Long classeId = setupData()

        expect:
        classeService.count() == 5

        when:
        classeService.delete(classeId)
        sessionFactory.currentSession.flush()

        then:
        classeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Classe classe = new Classe()
        classeService.save(classe)

        then:
        classe.id != null
    }
}
