package model;

public class Employee {
	//attributes
	private String idEmployee;

	//relations
	
	//methods
	public Employee(String idEmployee) {
		this.idEmployee = idEmployee;
	}
	
	public String getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}
}
