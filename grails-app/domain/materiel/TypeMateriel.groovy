package materiel

class TypeMateriel {
    String numTypeMateriel
    String libelle

    static HasMany = [materiels:Materiel]

      
    static mapping = {
		id generator: "increment"
		version false
	}

    static constraints = {
        numTypeMateriel nullable:true
        libelle nullable:true

    }
    String toString(){
        numTypeMateriel
    }
   
}
