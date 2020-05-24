package eleves

class Controle {
    String libelle
    Date dateControle
    Date duree
    String periode

    static hasMany = [eleves:Eleve]
    static mapping = {
		id generator: "increment"
		version false
	}

    static constraints = {
        libelle nullable:true
        dateControle nullable:true
        duree nullable:true
        periode nullable:true
    }
    String toString(){
        return libelle+" "+dateControle
    }
}
