package com.examen1.abstracto;

public class PrincipalNomina {

	public static void main(String[] args) {
		Nomina nomina = Area.obtenerArea(2);
		accion(nomina);
	}

	private static void accion(Nomina nomina) {
		String respuesta = nomina.pagar();
		System.out.println(respuesta);
		//Aumneta el salario del área recibida
		respuesta = nomina.aumentarSalario(3000);
		System.out.println(respuesta);
		respuesta = nomina.aumentarSalario(1000);
		System.out.println(respuesta);
		//Reduce el salario
		respuesta = nomina.reducirSalario(500);
		System.out.println(respuesta);
	}
}
