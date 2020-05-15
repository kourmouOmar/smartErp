package smarterp

import grails.gorm.services.Service

@Service(TypeEntretien)
interface TypeEntretienService {

    TypeEntretien get(Serializable id)

    List<TypeEntretien> list(Map args)

    Long count()

    void delete(Serializable id)

    TypeEntretien save(TypeEntretien typeEntretien)

}