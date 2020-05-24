package eleves

import grails.gorm.services.Service

@Service(AbsenceEleve)
interface AbsenceEleveService {

    AbsenceEleve get(Serializable id)

    List<AbsenceEleve> list(Map args)

    Long count()

    void delete(Serializable id)

    AbsenceEleve save(AbsenceEleve absenceEleve)

}