package smarterp

import grails.gorm.services.Service

@Service(Vehicule)
interface VehiculeService {

    Vehicule get(Serializable id)

    List<Vehicule> list(Map args)

    Long count()

    void delete(Serializable id)

    Vehicule save(Vehicule vehicule)

}