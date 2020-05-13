package smarterp

class TypeCarburant {
    String libelleCarburant
    int prix
    int qteBon
    
    static hasMany = [mvtCarburants: MvtCarburant]

    static mapping = {
		id generator: "increment"
		sort type: "asc"
		version false
    }

    static constraints = {
        libelleCarburant nullable:true
        prix nullable:true
        qteBon nullable:true
    }
}
