package com.examen1.interfaces;

public class PrincipalNomina {

	public static void main(String[] args) {
		Nomina nomina = Area.obtenerArea(3);
		accion(nomina);
	}

	private static void accion(Nomina nomina) {
		String respuesta = nomina.pagar();
		System.out.println(respuesta);
	}
}
