package ar.edu.unlam.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMateria {

	@Test
	public void queSeCreeLaMateria() {
		Integer codigo = 910;
		String nombre = "Pb2";
		
		Materia nuevaMateria = new Materia(codigo, nombre);
		assertNotNull(nuevaMateria);
	}

}
