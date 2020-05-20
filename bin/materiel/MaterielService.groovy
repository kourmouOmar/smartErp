package materiel

import grails.gorm.services.Service

@Service(Materiel)
interface MaterielService {

    Materiel get(Serializable id)

    List<Materiel> list(Map args)

    Long count()

    void delete(Serializable id)

    Materiel save(Materiel materiel)

}