package com.darwgom.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.darwgom.model.Bartender;
import com.darwgom.service.BartenderService;

/**
 * <p>
 * Titulo: Bartender API
 * </p>
 * <p>
 * Descripción: Controlador REST para procesos relacionados con el bartender
 * </p>
 * 
 * @author darwgom
 *
 **/

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class BartenderController {
	
	@Autowired
	BartenderService bartenderService;
	
	/**
	 * Método que permite consultar toda la información relacionada los bartenders
	 * 
	 * @return List<Bartender>, lista de objetos Bartender con su respectiva información
	 */
	@GetMapping(value = "/bartenders", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Bartender> listarBartender() {
		return bartenderService.listarBartender();
	}
	
	/**
	 * Método que permite consultar el resultado de la iteracion bartender conforme a los datos ingresados
	 * 
	 * @param numeroIteraciones, parametro que determina la cantidad de veces que se debería iterar
	 * @param idPila, parametro quue identifica a un grupo de datos relacionados con la pila de vasos del bartender
	 * @return Integer[], arreglo de datos Bartender con la información resultante
	 */
	@GetMapping(value = "/bartender/obtenerResultadoIteracion", produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer[] obtenerResultadoIteracion(
			@RequestParam(required = true, value = "numeroiteraciones") Integer numeroIteraciones,
			@RequestParam(required = true, value = "idpila") Integer idPila) throws EntityNotFoundException {
		return bartenderService.obtenerResultadoIteracion(numeroIteraciones, idPila) ;
	}
	
}
