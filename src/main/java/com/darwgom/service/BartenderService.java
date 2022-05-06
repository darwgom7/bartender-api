package com.darwgom.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.darwgom.model.Bartender;

public interface BartenderService {
	List<Bartender> listarBartender();
	Integer[] obtenerResultadoIteracion(Integer numeroIteraciones, Integer idPila) throws EntityNotFoundException;
}
