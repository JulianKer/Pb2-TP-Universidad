package ar.edu.unlam.dominio;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestAlumno {

	@Test
	public void queSeCreeUnAlumno() {
		Integer dni = 12345678;
		String nombre = "Julian", apellido = "Ker";
		LocalDate fechaNacimiento = LocalDate.of(2004, 10, 13);
		LocalDate fechaIngreso = LocalDate.of(2023, 4, 07);
		
		Alumno nuevoAlumno = new Alumno(dni, nombre, apellido, fechaNacimiento, fechaIngreso);
		
		assertNotNull(nuevoAlumno);
	}

}
