package com.programa;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Nomima {
	public static void main(String[] args) {
		
		//Lista de las areas
		List<Area> listaAreas = new ArrayList<>();
		listaAreas.add(new Area("Contabilidad",25,10000));
		listaAreas.add(new Area("RH",30,8000));
		listaAreas.add(new Area("Informatica",16,15000));
		listaAreas.add(new Area("Ventas",12,12000));
		// Lambdas
		IntBinaryOperator aumentar = (x, y) -> x + y;
		IntBinaryOperator reducir = (x, y) -> x - y;
		Predicate abrirArea = (area) -> listaAreas.add((Area) area);
		//No es necesaria, solo cambiar el nombre a la de reducir sueldo para usar solo esa
		//IntBinaryOperator despedirEmpleado = (x, y) -> x - y;
		
		//Areas sin modificar
		for(Area elem:listaAreas) {
			System.out.println("Area: "+elem.getNombre()+" Sueldo: "+elem.getSueldo());
		}
		System.out.println("--Aumentando salarios--");
		for(Area elem:listaAreas) {
			//Al sueldo del area le asigno el lambda enviandole el sueldo y un aumento de 3000
			elem.setSueldo(aumentar.applyAsInt(elem.getSueldo(), 3000));
			System.out.println("Area: "+elem.getNombre()+" Sueldo: "+elem.getSueldo());
		}
		System.out.println("--Reduciendo salarios--");
		for(Area elem:listaAreas) {
			//Al sueldo del area le asigno el lambda enviandole el sueldo y lo reduzco en 1000
			elem.setSueldo(reducir.applyAsInt(elem.getSueldo(), 1000));
			System.out.println("Area: "+elem.getNombre()+" Sueldo: "+elem.getSueldo());
		}
		System.out.println("--Contratando a los de la academia Java B)--");
		//Creo una nueva area
		boolean na = abrirArea.test(new Area("Back End", 13, 20000));
		for(Area elem:listaAreas) {
			//Si el resultado de la creación es exitoso contrato personal
			if(na) {
				elem.setEmpleados(aumentar.applyAsInt(elem.getEmpleados(), 1));
				System.out.println("Area: "+elem.getNombre()+" Empleados: "+elem.getEmpleados());
			}
				
		}
		
	}
}
