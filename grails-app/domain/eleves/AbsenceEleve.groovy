package eleves

class AbsenceEleve {

    Date heureDebut
    Date heureFin
    String motif
    Eleve eleve
    static belongsTo = [Eleve]
    static mapping = {
		id generator: "increment"
		version false
	}
    static constraints = {
        heureDebut nullable:true
        heureDebut nullable:true
        motif nullable:true
        eleve nullable:true
    }

    String toString(){
        return heureDebut+" "+heureFin
    }
}
