package professeurs

import grails.gorm.services.Service

@Service(Professeur)
interface ProfesseurService {

    Professeur get(Serializable id)

    List<Professeur> list(Map args)

    Long count()

    void delete(Serializable id)

    Professeur save(Professeur professeur)

}