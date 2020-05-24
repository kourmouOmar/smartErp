package eleves

import grails.gorm.services.Service

@Service(EmploiTemps)
interface EmploiTempsService {

    EmploiTemps get(Serializable id)

    List<EmploiTemps> list(Map args)

    Long count()

    void delete(Serializable id)

    EmploiTemps save(EmploiTemps emploiTemps)

}