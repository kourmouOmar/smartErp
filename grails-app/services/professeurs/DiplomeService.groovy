package professeurs

import grails.gorm.services.Service

@Service(Diplome)
interface DiplomeService {

    Diplome get(Serializable id)

    List<Diplome> list(Map args)

    Long count()

    void delete(Serializable id)

    Diplome save(Diplome diplome)

}