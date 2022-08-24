/*	Becerril Becerril Daniel
 * 	Proyecto Spring Batch
 * 	23/08/2022
 * 	Métodos para la ejecución de los trabajos
 * */
package com.javatechie.spring.batch.repository;

import com.javatechie.spring.batch.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
//Interface para los empleados
public interface EmpleadoRepository  extends JpaRepository<Empleado,Integer> {
}
