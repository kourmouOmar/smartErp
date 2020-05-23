package materiel

import grails.gorm.services.Service

@Service(Departement)
interface DepartementService {

    Departement get(Serializable id)

    List<Departement> list(Map args)

    Long count()

    void delete(Serializable id)

    Departement save(Departement departement)

}