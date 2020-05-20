package materiel

class TypeMateriel {
    String numTypeMateriel
    String libelle

    static hasMany = [materiels:Materiel]
      
    static mapping = {
		id generator: "increment"
		sort type: "asc"
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
