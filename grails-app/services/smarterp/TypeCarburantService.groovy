package smarterp

import grails.gorm.services.Service

@Service(TypeCarburant)
interface TypeCarburantService {

    TypeCarburant get(Serializable id)

    List<TypeCarburant> list(Map args)

    Long count()

    void delete(Serializable id)

    TypeCarburant save(TypeCarburant typeCarburant)

}