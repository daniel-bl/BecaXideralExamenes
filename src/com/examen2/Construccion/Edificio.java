package com.examen2.Construccion;

public class Edificio implements Construccion{
	
	Construccion piso1, piso2;
	public Edificio(Construccion piso1, Construccion piso2) {
		this.piso1 = piso1;
		this.piso2 = piso2;
	}

	
	@Override
	public String construir() {
		if(piso1 != null && piso2!=null)
			return "Se construyo una edificio";
		else
			return "No se ha terminado de construir el edificio";
	}

}
