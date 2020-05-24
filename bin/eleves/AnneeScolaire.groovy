package eleves

class AnneeScolaire {
    Date dateDebut
    Date dateFin
    static mapping = {
		id generator: "increment"
		version false
	}
    static constraints = {
        dateDebut nullable:true
        dateFin nullable:true
    }
    String toString(){
        return dateDebut+" "+dateFin
    }
}
