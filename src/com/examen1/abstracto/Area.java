package com.pregunta7.abstracto;

public class Area {
	public static Nomina obtenerArea(int area) {
		switch(area) {
		case 1: return new TrabajadoresOficina();
		case 2: return new TrabajadoresRepartidores();
		case 3: return new TrabajadoresVendedores();
		default:
		}
		return null;
	}
}
