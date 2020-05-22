package smarterp

class Vehicule {
    String matriculeV
    Date dateAqui
    Date dateVisite
    Date dateAssu
    String typeV
    Marque marque 
    Modele modele 
    Entretien entretien
    static hasMany = [conducteurs: Conducteur,mvtCarburants:MvtCarburant]
    static belongsTo = [Marque,Modele,Entretien]


    static mapping = {
		id generator: "increment"
		
		version false
	}

    static constraints = {
        matriculeV nullable:true
        dateAqui nullable:true
        dateVisite nullable:true
        typeV nullable:true
        marque nullable:true
        modele nullable:true
        entretien nullable:false

    }

    String toString () {
		return matriculeV +" "+dateAff
	}
}
