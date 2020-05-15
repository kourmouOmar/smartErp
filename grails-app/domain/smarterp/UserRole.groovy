package smarterp

class UserRole  {

    User user
    Role role

    static belongsTo = [User]


    static mapping = {
		id generator: "increment"
		version false
	}
	static constraints = {
       
    }
	String toString() {
		""+user+"->"+role
	}
}
