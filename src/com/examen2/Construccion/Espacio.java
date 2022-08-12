package com.examen2.Construccion;

public class Espacio implements Construccion{
	//Espacio minimo, nodo hoja
	String cuarto;
	
	public Espacio(String cuarto) {
		this.cuarto = cuarto;
	}

	@Override
	public String construir() {
		return cuarto;
	}

}
