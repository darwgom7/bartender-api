package com.darwgom.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.darwgom.service.BartenderService;

@SpringBootTest
class BartenderApiApplicationTests {
	
	@Autowired
	private BartenderService bartenderService;
	
	@Test
	void testValidarCantidadBartender() {
		assertEquals(5, bartenderService.listarBartender().size());
	}
	
	@Test
	void testExisteRegistroDiferenteDeNulo() throws Exception {
		assertThat(bartenderService.obtenerResultadoIteracion(3, 1)).isNotNull();
	}

}
