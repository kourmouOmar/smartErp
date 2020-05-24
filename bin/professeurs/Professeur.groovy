package professeurs

class Professeur {
    String nom
    String prenom
    String sexe
    Date dateNaissance
    String lieuNaissance
    String tele
    String fixe
    String adresse
    String photo

    static hasMany = [diplomes:Diplome,absenceProfesseurs:AbsenceProfesseur,retardProfesseurs:RetardProfesseur]
    static mapping = {
		id generator: "increment"
		version false
	}

    static constraints = {
        nom nullable:true
        prenom nullable:true
        sexe nullable:true
        dateNaissance:true
        lieuNaissance:true
        tele nullable:true
        fixe nullable:true
        adresse nullable:true
        photo nullable:true      
    }
    String toString(){
        return nom+" "+prenom
    }
}
