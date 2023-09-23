package ar.edu.unlam.dominio;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestInscripcionProfesorComision {

	@Test
	public void queSeCreeUnaInscripcionProfeComision() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		Integer codigo = 910;
		String nombre = "Pb2";
		Materia nuevaMateria = new Materia(codigo, nombre);
		unlam.registraMateria(nuevaMateria);
		
		LocalDate fechaInicioCiclo = LocalDate.of(2023, 04, 05);
		LocalDate fechaFinCiclo = LocalDate.of(2023, 07, 05);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 03, 01);
		LocalDate fechaFinInscripcion = LocalDate.of(2023, 03, 10);
		
		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicioCiclo, fechaFinCiclo, fechaInicioInscripcion, fechaFinInscripcion);
		unlam.registrarCicloLectivo(nuevoCiclo);
		
		Integer numeroAula = 406;
		Integer cantidadDeAlumnos = 30;
		Aula nuevaAula = new Aula(numeroAula, cantidadDeAlumnos);
		
		Integer codigoComision = 1300;
		Comision nuevaComision = new Comision(codigoComision, nuevaMateria, nuevoCiclo, Turno.MANANA, nuevaAula, Dias.LUN_Y_JUE);
		unlam.registrarComision(nuevaComision);
		
		
		Integer dniP = 1234567;
		String nombreP = "Andy", apellidoP = "Borgeat";
		
		Profesor nuevoProfe = new Profesor(dniP, nombreP, apellidoP);
		unlam.registrarProfesor(nuevoProfe);
		
		InscripcionProfesorComision nuevaInsProfeComision = new InscripcionProfesorComision(nuevoProfe, nuevaComision);
		
		assertNotNull(nuevaInsProfeComision);
	}

}
