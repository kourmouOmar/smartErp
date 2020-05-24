package eleves

import grails.gorm.services.Service

@Service(Classe)
interface ClasseService {

    Classe get(Serializable id)

    List<Classe> list(Map args)

    Long count()

    void delete(Serializable id)

    Classe save(Classe classe)

}