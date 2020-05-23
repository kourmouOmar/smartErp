package materiel

import grails.gorm.services.Service

@Service(FournisseurMateriel)
interface FournisseurMaterielService {

    FournisseurMateriel get(Serializable id)

    List<FournisseurMateriel> list(Map args)

    Long count()

    void delete(Serializable id)

    FournisseurMateriel save(FournisseurMateriel fournisseurMateriel)

}