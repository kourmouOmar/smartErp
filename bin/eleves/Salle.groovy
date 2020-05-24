package eleves

class Salle {
    String numero
    int capacite
    EmploiTemps emploiTemps
    static belongsTo = [EmploiTemps]
     static mapping = {
		id generator: "increment"
		version false
	}
    static constraints = {
        numero nullable:true
        capacite nullable:true
        emploiTemps nullable:true
    }

    String toString(){
        numero
    }
}
