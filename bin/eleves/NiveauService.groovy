package eleves

import grails.gorm.services.Service

@Service(Niveau)
interface NiveauService {

    Niveau get(Serializable id)

    List<Niveau> list(Map args)

    Long count()

    void delete(Serializable id)

    Niveau save(Niveau niveau)

}