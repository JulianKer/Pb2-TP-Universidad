package ar.edu.unlam.dominio;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestComision {

	@Test
	public void queSeCreeUnaComsion() {
		
		Integer codigo = 910;
		String nombre = "Pb2";
		
		Materia nuevaMateria = new Materia(codigo, nombre);
		
		LocalDate fechaInicioCiclo = LocalDate.of(2023, 04, 05);
		LocalDate fechaFinCiclo = LocalDate.of(2023, 07, 05);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 03, 01);
		LocalDate fechaFinInscripcion = LocalDate.of(2023, 03, 10);
		
		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicioCiclo, fechaFinCiclo, fechaInicioInscripcion, fechaFinInscripcion);
		
		Integer numeroAula = 406;
		Integer cantidadDeAlumnos = 30;
		Aula nuevaAula = new Aula(numeroAula, cantidadDeAlumnos);
		
		Integer idComision = 1300;
		Comision nuevaComision = new Comision(idComision, nuevaMateria, nuevoCiclo, Turno.MANANA, nuevaAula, Dias.LUN_Y_JUE);
		
		assertNotNull(nuevaComision);
	}

}
