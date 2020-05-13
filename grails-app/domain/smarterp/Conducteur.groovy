package smarterp

class Conducteur {
    int matriculeC
    String nom
    String prenom
    String telephone
    
    static hasMany = [vehicules: Vehicule]

    static mapping = {
		id generator: "increment"
		sort type: "asc"
		version false
	}

    static constraints = {
        matriculeC nullable:false
        nom nullable:false
        prenom nullable:false
        telephone nullable:false
    }

    String toString () {
		return nom +" "+prenom
	}

}
