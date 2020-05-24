package eleves

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AbsenceEleveServiceSpec extends Specification {

    AbsenceEleveService absenceEleveService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new AbsenceEleve(...).save(flush: true, failOnError: true)
        //new AbsenceEleve(...).save(flush: true, failOnError: true)
        //AbsenceEleve absenceEleve = new AbsenceEleve(...).save(flush: true, failOnError: true)
        //new AbsenceEleve(...).save(flush: true, failOnError: true)
        //new AbsenceEleve(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //absenceEleve.id
    }

    void "test get"() {
        setupData()

        expect:
        absenceEleveService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<AbsenceEleve> absenceEleveList = absenceEleveService.list(max: 2, offset: 2)

        then:
        absenceEleveList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        absenceEleveService.count() == 5
    }

    void "test delete"() {
        Long absenceEleveId = setupData()

        expect:
        absenceEleveService.count() == 5

        when:
        absenceEleveService.delete(absenceEleveId)
        sessionFactory.currentSession.flush()

        then:
        absenceEleveService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        AbsenceEleve absenceEleve = new AbsenceEleve()
        absenceEleveService.save(absenceEleve)

        then:
        absenceEleve.id != null
    }
}
