/*	Becerril Becerril Daniel
 * 	Proyecto Sistema de empleados
 * 	19/08/2022
 * 	Controlador de la aplicación
 * */
package com.client.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.client.rest.model.Empleado;
import com.client.rest.service.EmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {

	//Inyecta el servicio de empledo
	@Autowired
	private EmpleadoService empleadoService;
	
	//Directorio de la lista de empleados
	@GetMapping("/list")
	public String listEmpleados(Model theModel) {
		//Obtener los empleados del servicio
		List<Empleado> empleados = empleadoService.getEmpleados();		
		//Añadir los empleados al modelo
		theModel.addAttribute("empleados", empleados);
		return "list-empleados";
	}
	
	//Formulario de añadir
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		//Obtener el modelo para los datos
		Empleado empleado = new Empleado();
		theModel.addAttribute("empleado", empleado);
		return "empleado-form";
	}
	
	//Proceso para guardar el empleado de la jsp
	@PostMapping("/saveEmpleado")
	public String saveEmpleado(@ModelAttribute("empleado") Empleado empleado) {
		//Guardar el empleado utilizando el servicio
		empleadoService.saveEmpleado(empleado);	
		return "redirect:/empleado/list";
	}
	
	//Proceso para actualizar el empleado
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("empleadoId") int idRecibido,
									Model theModel) {
		//Obtener el empleado del servicio
		Empleado empleado = empleadoService.getEmpleado(idRecibido);	
		//Enviar el empleado al modelo
		theModel.addAttribute("empleado", empleado);
		//Retornar		
		return "empleado-form";
	}
	
	//Proceso para eliminar un empleado
	@GetMapping("/delete")
	public String deleteEmpleado(@RequestParam("empleadoId") int idRecibido) {
		//Ejecuta eliminación
		empleadoService.deleteEmpleado(idRecibido);
		//Regresa a la lista de empleados
		return "redirect:/empleado/list";
	}
}