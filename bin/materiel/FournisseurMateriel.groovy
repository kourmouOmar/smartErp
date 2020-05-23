package materiel

class FournisseurMateriel {
    String raisonSocial
    String adresse
    String tel
    String email
    Materiel materiel

    static belongsTo = [Materiel]
    static mapping = {
		id generator: "increment"
		version false
	}
    static constraints = {
        raisonSocial nullable:true
        adresse nullable:true
        tel nullable:true
        email nullable:true
        materiel nullable:true
    }
    String toString(){
        raisonSocial
    }
}
