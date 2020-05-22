package smarterp

class Reparation {
    Date dateR
    int numeroR
    String natureR
    double montant

    static mapping = {
		id generator: "increment"
		
		version false
	}
    
    static hasMany = [fournisseurs:Fournisseur]

    static constraints = {
        dateR nullable:true
        natureR nullable:true
        natureR nullable:true
        montant nullable:true
    }

    String toString(){
        dateR+" "+numeroR
    }
}
