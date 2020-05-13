package smarterp

class MvtCarburant {

    Date dateM
    int numBon
    int indexK
    String observation 
    Vehicule vehicule
	static belongsTo = [Vehicule]

    static mapping = {
		id generator: "increment"
		sort type: "asc"
		version false
    }

    static constraints = {
        dateM nullable:true
        numBon nullable:true
        observation nullable:true
        vehicule nullable:true
    }
    
    String toString () {
		return dateM +" "+numBon
	}
}
