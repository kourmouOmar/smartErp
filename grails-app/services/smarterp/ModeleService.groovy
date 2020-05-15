package smarterp

import grails.gorm.services.Service

@Service(Modele)
interface ModeleService {

    Modele get(Serializable id)

    List<Modele> list(Map args)

    Long count()

    void delete(Serializable id)

    Modele save(Modele modele)

}