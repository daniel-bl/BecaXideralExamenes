package com.examen1.interfaces;

public class PrincipalNomina {
	//Método main
	public static void main(String[] args) {
		int area = Menu.menuPrincipal();
		Nomina nomina = Area.obtenerArea(area);
		int accionElegida = Menu.menuSecundario();
		accion(nomina, accionElegida);
	}

	private static void accion(Nomina nomina, int accionElegida) {
		//Cantidad a ingresar en opciones 2 y 3
		int cantidad;
		String respuesta;
		switch(accionElegida) {
			case 1: //Paga la nomina del área recibida
				respuesta = nomina.pagar();
				System.out.println(respuesta);
				break;
			case 2: //Aumneta el salario del área recibida
				cantidad = Menu.menuCantidad();
				respuesta = nomina.aumentarSalario(cantidad);
				System.out.println(respuesta);
				break;
			case 3: //Reduce el salario
				cantidad = Menu.menuCantidad();
				respuesta = nomina.reducirSalario(cantidad);
				System.out.println(respuesta);
		}	
		//respuesta = nomina.pagar();
		//System.out.println(respuesta);
	}
}
