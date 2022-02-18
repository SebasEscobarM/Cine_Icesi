package model;

public class Empleado {
	//attributes
	private String idEmployee;

	//relations
	
	//methods
	public Empleado(String idEmployee) {
		this.idEmployee = idEmployee;
	}
	
	public String getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}
}
