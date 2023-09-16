package ar.edu.unlam.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAula {

	@Test
	public void queSeCreeUnAula() {
		Integer cantidadDeAlumnos = 30;
		
		Aula nuevaAula = new Aula(cantidadDeAlumnos);
		
		assertNotNull(nuevaAula);
	}

}
