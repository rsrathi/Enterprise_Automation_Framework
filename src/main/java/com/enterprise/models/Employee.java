package com.enterprise.models;

public class Employee {

	private String firstName;
	private String middleName;
	private String lastName;
	private String employeeID;
	
	public Employee(String firstName,String middleName,String lastName,String employeeID) {
		this.firstName=firstName;
		this.middleName=middleName;
		this.lastName=lastName;
		this.employeeID=employeeID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFullName() {
		return firstName+" "+middleName+" "+lastName;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}
}
