package smarterp

class Fournisseur {
    String raisonSocial
    String adresse
    String tel
    String email
    Entretien entretien
    Reparation reparation

    static belongsTo = [Entretien]
    static mapping = {
		id generator: "increment"
		
		version false
	}
    static constraints = {
        raisonSocial nullable:true
        adresse nullable:true
        tel nullable:true
        email nullable:true
        entretien nullable:true
        reparation nullable:true
    }
    String toString(){
        raisonSocial
    }
}
