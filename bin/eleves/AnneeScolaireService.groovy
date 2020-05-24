package eleves

import grails.gorm.services.Service

@Service(AnneeScolaire)
interface AnneeScolaireService {

    AnneeScolaire get(Serializable id)

    List<AnneeScolaire> list(Map args)

    Long count()

    void delete(Serializable id)

    AnneeScolaire save(AnneeScolaire anneeScolaire)

}