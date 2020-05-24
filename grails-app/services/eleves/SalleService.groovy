package eleves

import grails.gorm.services.Service

@Service(Salle)
interface SalleService {

    Salle get(Serializable id)

    List<Salle> list(Map args)

    Long count()

    void delete(Serializable id)

    Salle save(Salle salle)

}