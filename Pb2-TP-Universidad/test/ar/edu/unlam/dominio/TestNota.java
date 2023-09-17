package ar.edu.unlam.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNota {

	@Test
	public void queSeCreeUnaNota() {
		Integer valor = 7;
		TipoDeNota tipo = TipoDeNota.PRIMER_PARCIAL;
		
		Nota nuevaNota = new Nota(tipo);
		
		assertNotNull(nuevaNota);
	}
}
