package professeurs

import grails.gorm.services.Service

@Service(AbsenceProfesseur)
interface AbsenceProfesseurService {

    AbsenceProfesseur get(Serializable id)

    List<AbsenceProfesseur> list(Map args)

    Long count()

    void delete(Serializable id)

    AbsenceProfesseur save(AbsenceProfesseur absenceProfesseur)

}