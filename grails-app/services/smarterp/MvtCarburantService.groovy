package smarterp

import grails.gorm.services.Service

@Service(MvtCarburant)
interface MvtCarburantService {

    MvtCarburant get(Serializable id)

    List<MvtCarburant> list(Map args)

    Long count()

    void delete(Serializable id)

    MvtCarburant save(MvtCarburant mvtCarburant)

}