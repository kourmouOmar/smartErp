package eleves

import grails.gorm.services.Service

@Service(RetardEleve)
interface RetardEleveService {

    RetardEleve get(Serializable id)

    List<RetardEleve> list(Map args)

    Long count()

    void delete(Serializable id)

    RetardEleve save(RetardEleve retardEleve)

}