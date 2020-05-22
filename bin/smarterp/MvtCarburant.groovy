package smarterp

class MvtCarburant {

    Date dateM
    int numBon
    int indexK
    String observation 
    Vehicule vehicule
    TypeCarburant typeCarburant 
	static belongsTo = [Vehicule]

    static mapping = {
		id generator: "increment"
		
		version false
    }

    static constraints = {
        dateM nullable:true
        numBon nullable:true
        observation nullable:true
        vehicule nullable:true
        typeCarburant nullable:true
    }
    
    String toString () {
		return dateM +" "+numBon
	}
}
