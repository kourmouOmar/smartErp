package eleves

class Classe {
    String surnom
    Niveau niveau
    static hasMany = [emploiTemps: EmploiTemps]
    static belongsTo = [Niveau]
    static mapping = {
		id generator: "increment"
		version false
	}
    static constraints = {
        surnom nullable:true
        niveau nullable:true
    }
    String toString(){ surnom }
}
