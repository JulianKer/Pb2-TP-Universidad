package ar.edu.unlam.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestProfesor {

	@Test
	public void queSeCreeUnProfesor() {
		Integer dniP = 1234567;
		String nombreP = "Andy", apellidoP = "Borgeat";
		
		Profesor nuevoProfe = new Profesor(dniP, nombreP, apellidoP);
		
		assertNotNull(nuevoProfe);
	}

}
