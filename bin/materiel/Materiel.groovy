package materiel

class Materiel {
    String numSerie
    String num
    String description
    TypeMateriel typeMateriel

    static belongsTo = [TypeMateriel]

    static mapping = {
		id generator: "increment"
		
		version false
	}
    static constraints = {
        numSerie nullable:true
        num nullable:true
        description nullable:true
    }
    String toString(){
        numSerie
    }
}
