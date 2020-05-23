package materiel

class Materiel {
    String numSerie
    String num
    String description
    TypeMateriel typeMateriel
    FournisseurMateriel fournisseurMateriel

    static belongsTo = [TypeMateriel,FournisseurMateriel]

    static mapping = {
		id generator: "increment"
		
		version false
	}
    static constraints = {
        numSerie nullable:true
        num nullable:true
        description nullable:true
        fournisseurMateriel nullable:true
    }
    String toString(){
        numSerie
    }
}
