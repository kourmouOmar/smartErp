package eleves

class EmploiTemps {
    Date heureDebut
    Date heureFin
    static hasMany = [salles:Salle,classes:Classe]
    static mapping = {
		id generator: "increment"
		version false
	}
    static constraints = {
        heureDebut  nullable:true
        heureFin nullable:true
    }
    String toString(){
        return heureDebut+"-"+heureFin
    }
}
