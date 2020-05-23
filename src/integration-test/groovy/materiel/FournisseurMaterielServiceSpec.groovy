package materiel

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class FournisseurMaterielServiceSpec extends Specification {

    FournisseurMaterielService fournisseurMaterielService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new FournisseurMateriel(...).save(flush: true, failOnError: true)
        //new FournisseurMateriel(...).save(flush: true, failOnError: true)
        //FournisseurMateriel fournisseurMateriel = new FournisseurMateriel(...).save(flush: true, failOnError: true)
        //new FournisseurMateriel(...).save(flush: true, failOnError: true)
        //new FournisseurMateriel(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //fournisseurMateriel.id
    }

    void "test get"() {
        setupData()

        expect:
        fournisseurMaterielService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<FournisseurMateriel> fournisseurMaterielList = fournisseurMaterielService.list(max: 2, offset: 2)

        then:
        fournisseurMaterielList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        fournisseurMaterielService.count() == 5
    }

    void "test delete"() {
        Long fournisseurMaterielId = setupData()

        expect:
        fournisseurMaterielService.count() == 5

        when:
        fournisseurMaterielService.delete(fournisseurMaterielId)
        sessionFactory.currentSession.flush()

        then:
        fournisseurMaterielService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        FournisseurMateriel fournisseurMateriel = new FournisseurMateriel()
        fournisseurMaterielService.save(fournisseurMateriel)

        then:
        fournisseurMateriel.id != null
    }
}
