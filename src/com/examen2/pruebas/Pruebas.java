package com.examen2.pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.examen2.Construccion.*;

public class Pruebas {
	
	@Test
	void testEspacio() {
		String testEsp1 = "Sala";
		Construccion con = new Espacio("Sala");
		assertEquals(testEsp1,con.construir());
	}
	
	@Test
	void testCasa() {
		String test = "Se construyo una casa";
		Construccion testEsp1 = new Espacio("Sala");
		Construccion testEsp2 = new Espacio("Comedor");
		Construccion con = new Casa(testEsp1, testEsp2);
		assertEquals(test,con.construir());
	}
	
	@Test
	void testEdificio() {
		String test = "Se construyo una edificio";
		//Construyo 2 casas, la primera
		Construccion testEsp1 = new Espacio("Sala");
		Construccion testEsp2 = new Espacio("Comedor");
		Construccion casa = new Casa(testEsp1, testEsp2);
		//Segunda
		Construccion testEsp3 = new Espacio("Sala");
		Construccion testEsp4 = new Espacio("Comedor");
		Construccion casa2 = new Casa(testEsp3, testEsp4);
		//Edificio
		Construccion edificio = new Edificio(casa, casa2);
		assertEquals(test,edificio.construir());
	}
	
	@Test
	void testUnidadHabitacional() {
		String test = "Se construyo una unidad habitacional";
		//Construyo 4 casas, la primera
		Construccion testEsp1 = new Espacio("Sala");
		Construccion testEsp2 = new Espacio("Comedor");
		Construccion casa1 = new Casa(testEsp1, testEsp2);
		//Segunda
		Construccion testEsp3 = new Espacio("Sala");
		Construccion testEsp4 = new Espacio("Comedor");
		Construccion casa2 = new Casa(testEsp3, testEsp4);
		//Tercera
		Construccion testEsp5 = new Espacio("Balcon");
		Construccion testEsp6 = new Espacio("Baño");
		Construccion casa3 = new Casa(testEsp5, testEsp6);
		//Cuarta
		Construccion testEsp7 = new Espacio("Jardin");
		Construccion testEsp8 = new Espacio("Cochera");
		Construccion casa4 = new Casa(testEsp7, testEsp8);
		//Construyo 2 Edificios, el primero
		Construccion edificio1 = new Edificio(casa1, casa2);
		//segundo
		Construccion edificio2 = new Edificio(casa3, casa4);
		//Construyo la unidad
		Construccion uh = new UnidadHabitacional(edificio1, edificio2);
		assertEquals(test,uh.construir());
	}
	
	//Utilizando la forma compleja
	@Test
	void testUnidadHabitacional2() {
		String test = "Se construyo una unidad habitacional";
		//Construyo la unidad
		Construccion uh = new UnidadHabitacional(
				//Construyo 2 Edificios
				new Edificio(
						//Construyo casas en los edificios
						new Casa(
								//Construyo espacios en las casas
								new Espacio("Recamara"), 
								new Espacio("Baño")), 
						new Casa(
								new Espacio("Cocina"), 
								new Espacio("Sala"))
						), 
				new Edificio(
						new Casa(
								new Espacio("Comedor"),
								new Espacio("Cochera")), 
						new Casa(
								new Espacio("Cochera"), 
								new Espacio("Cochera")
								)
						)
				);
		assertEquals(test,uh.construir());
	}
}
