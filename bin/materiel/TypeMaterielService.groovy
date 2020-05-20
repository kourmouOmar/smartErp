package materiel

import grails.gorm.services.Service

@Service(TypeMateriel)
interface TypeMaterielService {

    TypeMateriel get(Serializable id)

    List<TypeMateriel> list(Map args)

    Long count()

    void delete(Serializable id)

    TypeMateriel save(TypeMateriel typeMateriel)

}