package smarterp

class Role {
    String authority
    String description

    static hasMany = [userRoles : UserRole]
    static mapping = {
		cache true
		sort authority: "asc"
	}
    static constraints = {
        authority blank: false, unique:true
        description nullable: true
    }

    String toString(){
        authority
    }
}
