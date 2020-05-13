package smarterp

class Vehicule {
    String matriculeV
    Date dateAqui
    Date dateVisite
    Date dateAssu
    String typeV


    static hasMany = [conducteurs: Conducteur,mvtCarburants:MvtCarburant]


    static mapping = {
		id generator: "increment"
		sort type: "asc"
		version false
	}

    static constraints = {
        matriculeV nullable:true
        dateAqui nullable:true
        dateVisite nullable:true
        typeV nullable:true
    }

    String toString () {
		return matriculeV +" "+dateAff
	}
}
