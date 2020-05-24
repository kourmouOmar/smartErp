package eleves

class GroupeTransport {
    String surnom
    static hasMany = [eleves:Eleve]
    static mapping = {
		id generator: "increment"
		version false
	}
    static constraints = {
        surnom nullable:true
    }
    String toString(){
        surnom
    }
}
