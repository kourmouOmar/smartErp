package smarterp

import grails.gorm.services.Service

@Service(Marque)
interface MarqueService {

    Marque get(Serializable id)

    List<Marque> list(Map args)

    Long count()

    void delete(Serializable id)

    Marque save(Marque marque)

}