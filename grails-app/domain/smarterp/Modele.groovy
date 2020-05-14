package smarterp

class Modele {
    String libelleModel
    
    static hasMany = [marques:Marque]

    static mapping = {
		id generator: "increment"
		sort type: "asc"
		version false
	}

    static constraints = {
        libelleModel nullable:true
    }
    String toString(){ libelleModel }
}
