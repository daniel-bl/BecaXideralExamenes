package com.examen1.abstracto;

public class PrincipalNomina {

	public static void main(String[] args) {
		Nomina nomina = Area.obtenerArea(2);
		accion(nomina);
	}

	private static void accion(Nomina nomina) {
		String respuesta = nomina.pagar();
		System.out.println(respuesta);
	}
}
