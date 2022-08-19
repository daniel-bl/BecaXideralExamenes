package com.programa;

public class Area {
	private String nombre;
	private int empleados;
	private int sueldo;
	
	public Area(String nombre, int empleados, int sueldo) {
		super();
		this.nombre = nombre;
		this.empleados = empleados;
		this.sueldo = sueldo;
	}
	//Getters&Setters
	//Nombre
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//Cantidad de empleados
	public int getEmpleados() {
		return empleados;
	}
	public void setEmpleados(int empleados) {
		this.empleados = empleados;
	}
	//Sueldo del area
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	@Override
	public String toString() {
		return "Area [nombre=" + nombre + ", empleados=" + empleados + ", sueldo=" + sueldo + "]";
	}
	
}
