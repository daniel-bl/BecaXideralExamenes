/*	Becerril Becerril Daniel
 * 	Proyecto Sistema de Empleados
 * 	12/08/2022
 * 	Modelo Empleado
 * */
package com.luv2code.web.jdbc;

public class Empleado {
	//Atributos
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	//Constructor
	public Empleado(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	//Constuctor sobrecargado con el id
	public Empleado(int id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	//---Setters & Getters---
	//id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//Nombre
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	//Apellido
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	//Email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//Sobreescritura del método toString
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}	
}
