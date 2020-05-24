package eleves

import grails.gorm.services.Service

@Service(Eleve)
interface EleveService {

    Eleve get(Serializable id)

    List<Eleve> list(Map args)

    Long count()

    void delete(Serializable id)

    Eleve save(Eleve eleve)

}