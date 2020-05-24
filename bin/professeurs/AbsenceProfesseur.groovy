package professeurs

class AbsenceProfesseur {
    Date heureDebut
    Date heureFin
    String motif
    Professeur professeur
    static belongsTo = [Professeur]
    static mapping = {
		id generator: "increment"
		version false
	}
    static constraints = {
        heureDebut nullable:true
        heureDebut nullable:true
        motif nullable:true
        professeur nullable:true
    }

    String toString(){
        return heureDebut+" "+heureFin
    }
}
