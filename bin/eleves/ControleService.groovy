package eleves

import grails.gorm.services.Service

@Service(Controle)
interface ControleService {

    Controle get(Serializable id)

    List<Controle> list(Map args)

    Long count()

    void delete(Serializable id)

    Controle save(Controle controle)

}