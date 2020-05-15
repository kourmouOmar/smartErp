package smarterp

import grails.gorm.services.Service

@Service(Entretien)
interface EntretienService {

    Entretien get(Serializable id)

    List<Entretien> list(Map args)

    Long count()

    void delete(Serializable id)

    Entretien save(Entretien entretien)

}