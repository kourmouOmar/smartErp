package eleves

class Parent {
    String nom 
    String prenom
    Date dateNaissance
    String lieuNaissance
    String cin 
    String typeParite
    String tele
    String fixe
    String adresse

    static hasMany = [eleves : Eleve]
    static mapping = {
		id generator: "increment"
		version false
	}
    static constraints = {
        nom nullable:true
        prenom nullable:true
        dateNaissance nullable:true
        lieuNaissance nullable:true
        cin nullable:true
        typeParite nullable:true
        tele nullable:true
        fixe nullable:true
        adresse nullable:true
    }
    String toString(){
        return nom+"-"+prenom
    }
}
