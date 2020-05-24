package eleves

class Niveau {
    String libelle
    String option
    int capaciteClasse
    static hasMany = [classes:Classe]
    static mapping = {
		id generator: "increment"
		version false
	}
    static constraints = {
        libelle nullable:true
        option nullable:true
        capaciteClasse nullable:true
    }
    String toString(){
        libelle
    }
}
