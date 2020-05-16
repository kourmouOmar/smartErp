package smarterp

class User {
    String username
    String password
    String nom
    String prenom
    String matricule
    String email
    String tel
    String photo
    boolean compteDesactive
    boolean compteExpired
    
    
    static hasMany = [roles: UserRole]
    static mapping = {
		sort nom: "asc"
	}

    static constraints = {
        nom nullable:true
        prenom nullable:true
        username nullable:true
        password nullable:true
        matricule nullable:true
        email nullable:true
        tel nullable:true
        photo nullable:true
        compteDesactive nullable:false
        compteExpired nullable:false
    }

    String toString(){
        return nom+" "+prenom
    }

}
