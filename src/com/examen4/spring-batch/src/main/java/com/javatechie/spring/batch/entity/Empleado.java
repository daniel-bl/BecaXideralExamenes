/*	Becerril Becerril Daniel
 * 	Proyecto Spring Batch
 * 	23/08/2022
 * 	Modelo de empleado
 * */
package com.javatechie.spring.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLEADOS_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
	//Atributos
    @Id
    @Column(name = "EMPLEADO_ID")
    private int id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "CONTACT")
    private String contactNo;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "DOB")
    private String dob;
    
}
