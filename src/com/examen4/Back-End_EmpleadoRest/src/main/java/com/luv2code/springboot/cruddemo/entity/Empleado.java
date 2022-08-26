/*	Becerril Becerril Daniel
 * 	Proyecto Api Rest Empleados
 * 	19/08/2022
 * 	Modelo de datos usado por la api
 * */
package com.luv2code.springboot.cruddemo.entity;

import javax.persistence.*; 
import lombok.*;

@Data 
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="empleado")
public class Empleado {

	//Campos de tablas para Hibernate	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
}











