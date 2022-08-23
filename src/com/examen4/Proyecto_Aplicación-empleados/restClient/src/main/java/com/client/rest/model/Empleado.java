/*	Becerril Becerril Daniel
 * 	Proyecto Sistema de empleados
 * 	19/08/2022
 * 	Modelo del empleado
 * */
package com.client.rest.model;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@Data
public class Empleado {

	private int id;
	private String firstName;
	private String lastName;	
	private String email;
	
}