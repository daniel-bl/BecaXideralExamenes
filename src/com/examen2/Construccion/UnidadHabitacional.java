package com.examen2.Construccion;

public class UnidadHabitacional implements Construccion{
	Construccion casa1, casa2;
	public UnidadHabitacional(Construccion casa1, Construccion casa2) {
		this.casa1 = casa1;
		this.casa2 = casa2;
	}

	
	@Override
	public String construir() {
		if(casa1!=null && casa2!=null)
			return "Se construyo una unidad habitacional";
		else
			return "No se ha terminado de construir la unidad habitacional";
	}

}
