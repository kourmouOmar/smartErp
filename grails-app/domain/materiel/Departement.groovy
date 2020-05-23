package materiel

class Departement {
    String numDepartement
    String nomDepartemenr

    static HasMany = [materiels:Materiel]

    static mapping = {
		id generator: "increment"
		version false
	}

    static constraints = {
        numDepartement nullable:true
        nomDepartemenr nullable:true
    }
    String toString(){
        nomDepartemenr
    }
}
