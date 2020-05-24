package professeurs

class Diplome {
    String intitule
    String ecole
    String specialite
    String niveau
    Date dateObtention
    Professeur professeur 
    static belongsTo = [Professeur]
    static mapping = {
		id generator: "increment"
		version false
	}
    static constraints = {
        intitule nullable:true
        ecole nullable:true
        specialite nullable:true
        niveau nullable:true
        dateObtention nullable:true
        professeur nullable:true
    }
    String toString(){
        return intitule+" "+ecole
    }
}
