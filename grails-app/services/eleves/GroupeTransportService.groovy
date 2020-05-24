package eleves

import grails.gorm.services.Service

@Service(GroupeTransport)
interface GroupeTransportService {

    GroupeTransport get(Serializable id)

    List<GroupeTransport> list(Map args)

    Long count()

    void delete(Serializable id)

    GroupeTransport save(GroupeTransport groupeTransport)

}