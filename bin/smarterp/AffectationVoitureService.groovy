package smarterp

import grails.gorm.services.Service

@Service(AffectationVoiture)
interface AffectationVoitureService {

    AffectationVoiture get(Serializable id)

    List<AffectationVoiture> list(Map args)

    Long count()

    void delete(Serializable id)

    AffectationVoiture save(AffectationVoiture affectationVoiture)

}