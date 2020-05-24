package eleves

import grails.gorm.services.Service

@Service(AncienneEcole)
interface AncienneEcoleService {

    AncienneEcole get(Serializable id)

    List<AncienneEcole> list(Map args)

    Long count()

    void delete(Serializable id)

    AncienneEcole save(AncienneEcole ancienneEcole)

}