package smarterp

class Marque {
    String libelleMarque
    Modele modele
    static hasMany = [vehicules: Vehicule]
    static belongsTo = [Modele]
    static mapping = {
		id generator: "increment"
		
		version false
	}

    static constraints = {
        libelleMarque nullable:true
        modele nullable:true
    }
    
    String toString(){ libelleMarque }
}
