/*	Becerril Becerril Daniel
 * 	Proyecto Spring Batch
 * 	23/08/2022
 * 	clase que implementa la interfaz de proceso
 * */
package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.Empleado;
import org.springframework.batch.item.ItemProcessor;

public class EmpleadoProcessor implements ItemProcessor<Empleado,Empleado> {
	//Ejecuta proceso en empleados
    @Override
    public Empleado process(Empleado empleado) throws Exception {
        //Si el empleado cumple con la condición es registrado en la base de datos
    	if(empleado.getCountry().equals("China")) {
            return empleado;
        }
        return null;
        
    }
}
