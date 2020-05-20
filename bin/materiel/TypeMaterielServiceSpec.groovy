package materiel

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TypeMaterielServiceSpec extends Specification {

    TypeMaterielService typeMaterielService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TypeMateriel(...).save(flush: true, failOnError: true)
        //new TypeMateriel(...).save(flush: true, failOnError: true)
        //TypeMateriel typeMateriel = new TypeMateriel(...).save(flush: true, failOnError: true)
        //new TypeMateriel(...).save(flush: true, failOnError: true)
        //new TypeMateriel(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //typeMateriel.id
    }

    void "test get"() {
        setupData()

        expect:
        typeMaterielService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TypeMateriel> typeMaterielList = typeMaterielService.list(max: 2, offset: 2)

        then:
        typeMaterielList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        typeMaterielService.count() == 5
    }

    void "test delete"() {
        Long typeMaterielId = setupData()

        expect:
        typeMaterielService.count() == 5

        when:
        typeMaterielService.delete(typeMaterielId)
        sessionFactory.currentSession.flush()

        then:
        typeMaterielService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TypeMateriel typeMateriel = new TypeMateriel()
        typeMaterielService.save(typeMateriel)

        then:
        typeMateriel.id != null
    }
}
