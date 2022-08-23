/*	Becerril Becerril Daniel
 * 	Proyecto Sistema de empleados
 * 	19/08/2022
 * 	Servicio que consume la API
 * */
package com.client.rest.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.client.rest.model.Empleado;

@Service
public class EmpleadoServiceRestClientImpl implements EmpleadoService {
	//Template
	private RestTemplate restTemplate;
	//Variable para guardar la dirección del API
	private String crmRestUrl;
	//Obtener logger para mensajes	
	private Logger logger = Logger.getLogger(getClass().getName());
	//Obtener recurso
	@Autowired
	public EmpleadoServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;		
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	//Método para obtener la lista de todos lo empleados
	@Override
	public List<Empleado> getEmpleados() {
		logger.info("***OBTENER LISTA DE EMPLEADOS DESDE EL SERVICE REST CLIENTE***");
		logger.info("in getCustomers(): Calling REST API " + crmRestUrl);
		//Hace la llamada REST
		ResponseEntity<List<Empleado>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
													 new ParameterizedTypeReference<List<Empleado>>() {});

		//Obtener todos los empleados de la llamada
		List<Empleado> empleados = responseEntity.getBody();
		logger.info("in getEmpleados(): empleados" + empleados);
		//Regresar la lista
		return empleados;
	}
	
	//Método para obtener un empleado especifico
	@Override
	public Empleado getEmpleado(int idRecibido) {
		logger.info("***OBTENER UN EMPLEADO DESDE EL SERVICE REST CLIENTE***");
		logger.info("in getEmpleado(): Calling REST API " + crmRestUrl);
		//Llamada Rest
		Empleado empleadoBuscado = 
				restTemplate.getForObject(crmRestUrl + "/" + idRecibido, 
						Empleado.class);
		logger.info("in saveEmpleado(): theEmpleado=" + empleadoBuscado);
		
		return empleadoBuscado;
	}

	//Método para guardar un empleado
	@Override
	public void saveEmpleado(Empleado empleadoRecibido) {
		logger.info("in saveEmpleado(): Calling REST API " + crmRestUrl);
		//Obtener id del empleado
		int employeeId = empleadoRecibido.getId();
		//Llamada Rest
		if (employeeId == 0) {
			//Si el empleado recibido tiene un id de 0 se guarda como nuevo empleado
			logger.info("***GUARDAR UN CLIENTE DESDE EL SERVICE REST CLIENTE***");
			restTemplate.postForEntity(crmRestUrl, empleadoRecibido, String.class);			
		} else {
			//Si ya tiene un id entonces se actualiza
			logger.info("***ACTUALIZAR UN EMPLEADO DESDE EL SERVICE REST CLIENTE***");
			restTemplate.put(crmRestUrl, empleadoRecibido);
		}
		logger.info("in saveEmpleado(): success");	
	}

	//Método para eliminar un empleado usando su id
	@Override
	public void deleteEmpleado(int idRecibido) {
		logger.info("***BORRAR UN EMPLEADO DESDE EL SERVICE REST CLIENTE***");
		logger.info("in deleteEmpleado(): Calling REST API " + crmRestUrl);
		//Llamada Rest
		restTemplate.delete(crmRestUrl + "/" + idRecibido);
		logger.info("in deleteEmpleado(): deleted customer theId=" + idRecibido);
	}

}
