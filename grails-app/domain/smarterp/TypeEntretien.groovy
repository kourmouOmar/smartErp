package smarterp

class TypeEntretien {
    String libelle
    String detail
    Entretien entretien
    static belongsTo = [Entretien]
    static mapping = {
		id generator: "increment"
		sort type: "asc"
		version false
	}
    static constraints = {
        libelle nullable:true
        detail nullable:true
        entretien nullable:true
    }

    String toString () {
		libelle
	}
}
