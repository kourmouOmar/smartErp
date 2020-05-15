package smarterp

import grails.gorm.services.Service

@Service(Reparation)
interface ReparationService {

    Reparation get(Serializable id)

    List<Reparation> list(Map args)

    Long count()

    void delete(Serializable id)

    Reparation save(Reparation reparation)

}