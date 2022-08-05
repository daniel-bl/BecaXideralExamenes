package com.examen1.abstracto;

import java.util.Scanner;

public class Menu {
	//Menu principal
	public static int menuPrincipal() {
		 Scanner sc = new Scanner(System.in);
		 int eleccion;
		 do {
			 System.out.println("**Sistema de nomina**");
			 System.out.println("**Escoja un Area**");
			 System.out.println("1. Oficinas");
			 System.out.println("2. Repartidores");
			 System.out.println("2. Vendedores");
			 System.out.println("Ingrese una opcion: ");
			 eleccion = sc.nextInt();
		 }while(eleccion<=0 || eleccion>2);
		return eleccion;
	}
	//Menu secundario
	public static int menuSecundario() {
		Scanner sc = new Scanner(System.in);
		 int eleccion;
		 do {
			 System.out.println("**Sistema de nomina**");
			 System.out.println("**Elija una accion**");
			 System.out.println("1. Pagar nomina");
			 System.out.println("2. Aumentar salario");
			 System.out.println("2. Reducir salario");
			 System.out.println("Ingrese una opcion: ");
			 eleccion = sc.nextInt();
		 }while(eleccion<=0 || eleccion>2);
		return eleccion;	
	}
	//Menu para ingresar cantidad
	public static int menuCantidad() {
		Scanner sc = new Scanner(System.in);
		 int eleccion;
		 System.out.println("**Ingrese un monto**");
		 eleccion = sc.nextInt();
		return eleccion;	
	}

}
