package smarterp

class AffectationVoiture {
    String matriculeV
    Date dateAff

    static mapping = {
		id generator: "increment"
		
		version false
	}
    static constraints = {
        matriculeV nullable:false
        dateAff nullable:false
    }

    String toString () {
		return matriculeV +" "+dateAff
	}
}
