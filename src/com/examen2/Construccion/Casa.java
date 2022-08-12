package com.examen2.Construccion;

public class Casa implements Construccion {
	
	Construccion cocina, sala;

	public Casa(Construccion jardin, Construccion sala) {
		this.cocina = jardin;
		this.sala = sala;
	}

	@Override
	public String construir() {
		if(cocina != null && sala!=null)
			return "Se construyo una casa";
		else
			return "No se ha terminado de construir la casa";
	}
	
}
