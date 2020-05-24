package eleves

class Eleve {
    String nomFr
    String nomAr
    String prenomFr
    String prenomAr
    Date dateNaissanceFr
    Date lieuNaissanceFr
    Date dateNaissanceAr
    Date lieuNaissanceAr
    String sexe
    String photo
    String cne 
    String cin 
    AncienneEcole ancienneEcole

    static hasMany = [retards:RetardEleve,absences:AbsenceEleve,controles:Controle,groupeTransports:GroupeTransport]
    static belongsTo = [AncienneEcole]
    static mapping = {
		id generator: "increment"
		version false
	}
    static constraints = {
        nomFr nullable:true
        nomAr nullable:true
        prenomFr nullable:true
        prenomAr nullable:true
        dateNaissanceAr nullable:true
        dateNaissanceFr nullable:true
        lieuNaissanceFr nullable:true
        lieuNaissanceAr nullable:true
        sexe nullable:true
        photo nullable:true
        cne nullable:true
        cin nullable:true
        ancienneEcole nullable:true
    }

    String toString(){
        return nomFr+" "+prenomFr+" "+cne
    }
}
