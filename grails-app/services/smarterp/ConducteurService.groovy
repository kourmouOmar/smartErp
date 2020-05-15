package smarterp

import grails.gorm.services.Service

@Service(Conducteur)
interface ConducteurService {

    Conducteur get(Serializable id)

    List<Conducteur> list(Map args)

    Long count()

    void delete(Serializable id)

    Conducteur save(Conducteur conducteur)

}