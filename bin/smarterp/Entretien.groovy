package smarterp

class Entretien {
    Date dateEntretien
    double montant
    double kilometrage
    Vehicule vehicule
    static hasMany = [typeEntretiens: TypeEntretien]
    static belongsTo = [Vehicule]

    static mapping = {
		id generator: "increment"
		sort type: "asc"
		version false
	}

    static constraints = {
        dateEntretien nullable:true
        montant nullable:true
        kilometrage nullable:true
        vehicule nullable:true
    }
    
    String toString(){
        dateEntretien
    }
}

