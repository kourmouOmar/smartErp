package professeurs

import grails.gorm.services.Service

@Service(RetardProfesseur)
interface RetardProfesseurService {

    RetardProfesseur get(Serializable id)

    List<RetardProfesseur> list(Map args)

    Long count()

    void delete(Serializable id)

    RetardProfesseur save(RetardProfesseur retardProfesseur)

}