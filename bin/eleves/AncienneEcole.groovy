package eleves

class AncienneEcole {
    String nomEcoleFr
    String nomEcoleAr
    String typeEcole
    String statutEcole
    Eleve eleve
    static belongsTo =[Eleve]
    static mapping = {
		id generator: "increment"
		version false
	}
    static constraints = {
        nomEcoleAr nullable:true
        nomEcoleFr nullable:true
        typeEcole nullable:true
        statutEcole nullable:true
        eleve nullable:true
    }
    String toString(){
        nomEcoleFr
    }
}
