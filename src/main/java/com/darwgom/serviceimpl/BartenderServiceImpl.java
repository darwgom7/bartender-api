package com.darwgom.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.darwgom.model.Bartender;
import com.darwgom.repository.BartenderRepository;
import com.darwgom.service.BartenderService;

@Service
public class BartenderServiceImpl implements BartenderService {

	@Autowired
	public BartenderRepository bartenderRepository;
	
	@Override
	public List<Bartender> listarBartender() {
		return bartenderRepository.findAll();
	}

	@Override
	public Integer[] obtenerResultadoIteracion(Integer numeroIteraciones, Integer idPila) throws EntityNotFoundException {
		Optional<Bartender> bartenderOptional = bartenderRepository.findById(Long.valueOf(idPila));
		Bartender bartender = null;
		if (bartenderOptional.isPresent()) {
			bartender = bartenderOptional.get();
		} else {
			throw new EntityNotFoundException("No se encuentra la pila de datos seleccionada");
		}
		
		String pilaVasos = bartender.getPilaVasos();
        String[] splitArreglo = pilaVasos.split(",");
        int[] arregloVasos = Arrays.stream(splitArreglo).mapToInt(Integer::parseInt).toArray();
        Integer[] vasosNumerados = new Integer[arregloVasos.length];
        Arrays.setAll(vasosNumerados, i -> arregloVasos[i]);
        Integer[] numerosPrimos = {2, 3, 5, 7, 11, 13};
        Integer[] numerosDivisibles = null;
        Integer[] auxiliarVasosNumerados = null;
        Integer[] respuesta = null;
        Integer[] auxiliarNumerosDivisibles = new Integer[10]; 

        Integer auxiliarVaso = 0;
        Integer auxiliarDivisible = 0;
        Integer auxiliarVasoIndivisible = 0;
        Integer longitudDivisibles = 0;
        
        for (int q = 0; q < numeroIteraciones; q++) {
            
            for (int i = vasosNumerados.length - 1; i >= 0; i--) {
                if (Boolean.TRUE.equals(esDivisible(vasosNumerados[i], numerosPrimos[i]))) {
                	longitudDivisibles++;
                	numerosDivisibles = new Integer[longitudDivisibles];
                	auxiliarNumerosDivisibles[auxiliarDivisible] = vasosNumerados[i];
                	numerosDivisibles = Arrays.copyOf(auxiliarNumerosDivisibles, numerosDivisibles.length);
                    vasosNumerados = removerElementos(vasosNumerados, i);
                    auxiliarDivisible++;
                } 
            }
            
            auxiliarVasosNumerados = new Integer[vasosNumerados.length]; 
            auxiliarVaso = 0;
            for (int j = vasosNumerados.length - 1; j >= 0; j--) {
                auxiliarVasosNumerados[auxiliarVaso] = vasosNumerados[j];
                vasosNumerados = removerElementos(vasosNumerados, j);
                auxiliarVaso++;
            }
            
            vasosNumerados = new Integer[auxiliarVasosNumerados.length];
            auxiliarVasoIndivisible = 0;
            for (int j = 0; j < auxiliarVasosNumerados.length; j++) {
                vasosNumerados[auxiliarVasoIndivisible] = auxiliarVasosNumerados[j];
                auxiliarVasoIndivisible++;
            }
        }
        
        respuesta = unificarElementos(numerosDivisibles, vasosNumerados);
		return respuesta;
	}
	
    public static Boolean esDivisible(Integer numeroVaso, Integer numeroPrimo) {
        return (numeroVaso % numeroPrimo == 0);
    }
    
    public static Integer[] removerElementos(Integer[] arreglo, int indice ) {
        List<Integer> lista = new ArrayList<>(Arrays.asList(arreglo));
        lista.remove(indice);
        return lista.toArray(new Integer[0]);
    }
    
    public static Integer[] unificarElementos(Integer[] arregloBase, Integer[] arreglo) {
        Integer[] elementosUnificados = null;
        
        if (!ObjectUtils.isEmpty(arregloBase) && !ObjectUtils.isEmpty(arreglo)) {
        	Integer longitud = arregloBase.length + arreglo.length;
        	elementosUnificados = new Integer[longitud];
        	
            Integer posicion = 0;
            for (int objecto : arregloBase) {
            	elementosUnificados[posicion] = objecto;
            	posicion++;
            }
            
            for (int objecto : arreglo) {
            	elementosUnificados[posicion] = objecto;
            	posicion++;
            }
            
        } else {
        	throw new EntityNotFoundException("No se encuentra alguno o los arreglos a unificar");
        }
        
        return elementosUnificados;
    }

}
