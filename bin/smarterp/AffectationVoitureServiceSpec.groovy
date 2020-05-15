package smarterp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AffectationVoitureServiceSpec extends Specification {

    AffectationVoitureService affectationVoitureService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new AffectationVoiture(...).save(flush: true, failOnError: true)
        //new AffectationVoiture(...).save(flush: true, failOnError: true)
        //AffectationVoiture affectationVoiture = new AffectationVoiture(...).save(flush: true, failOnError: true)
        //new AffectationVoiture(...).save(flush: true, failOnError: true)
        //new AffectationVoiture(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //affectationVoiture.id
    }

    void "test get"() {
        setupData()

        expect:
        affectationVoitureService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<AffectationVoiture> affectationVoitureList = affectationVoitureService.list(max: 2, offset: 2)

        then:
        affectationVoitureList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        affectationVoitureService.count() == 5
    }

    void "test delete"() {
        Long affectationVoitureId = setupData()

        expect:
        affectationVoitureService.count() == 5

        when:
        affectationVoitureService.delete(affectationVoitureId)
        sessionFactory.currentSession.flush()

        then:
        affectationVoitureService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        AffectationVoiture affectationVoiture = new AffectationVoiture()
        affectationVoitureService.save(affectationVoiture)

        then:
        affectationVoiture.id != null
    }
}
