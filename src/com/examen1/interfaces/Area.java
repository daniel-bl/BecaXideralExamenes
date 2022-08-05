package com.examen1.interfaces;

public class Area {
	public static Nomina obtenerArea(int area) {
		switch(area) {
		case 1: return new TrabajadoresOficina();
		case 2: return new TrabajadoresRepartidores();
		default: return new TrabajadoresVendedores();	
		}
	}
}
