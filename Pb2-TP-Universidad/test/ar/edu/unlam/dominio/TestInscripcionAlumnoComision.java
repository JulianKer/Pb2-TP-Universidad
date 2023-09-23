package ar.edu.unlam.dominio;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestInscripcionAlumnoComision {

	@Test                                                //         (seria)
	public void queSeCreeUnaInscripcionAlumnoComision() { // comision ----> curso pero asi lo llama el tp
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		// creo comision:
		Integer codigo = 910;
		String nombre = "Pb2";
		
		Materia nuevaMateria = new Materia(codigo, nombre);
		unlam.registraMateria(nuevaMateria);
		
		LocalDate fechaInicioCiclo = LocalDate.of(2023, 04, 05);
		LocalDate fechaFinCiclo = LocalDate.of(2023, 07, 05);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 03, 01);
		LocalDate fechaFinInscripcion = LocalDate.of(2023, 03, 10);
		
		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicioCiclo, fechaFinCiclo, fechaInicioInscripcion, fechaFinInscripcion);
		
		Integer numeroAula = 406;
		Integer cantidadDeAlumnos = 30;
		Aula nuevaAula = new Aula(numeroAula, cantidadDeAlumnos);
		unlam.registrarAula(nuevaAula);
		
		Integer idComision = 1300;
		Comision nuevaComision = new Comision(idComision, nuevaMateria, nuevoCiclo, Turno.MANANA, nuevaAula, Dias.LUN_Y_JUE);
		unlam.registrarComision(nuevaComision);
		
		//creo alumno:
		Integer dni = 12345678;
		String nombreA = "Julian", apellido = "Ker";
		LocalDate fechaNacimiento = LocalDate.of(2004, 10, 13);
		LocalDate fechaIngreso = LocalDate.of(2023, 4, 07);
		
		Alumno nuevoAlumno = new Alumno(dni, nombreA, apellido, fechaNacimiento, fechaIngreso);
		unlam.registrarAlumno(nuevoAlumno);
		
		// elijo la fecha en la que se está inscribiendo el alumno
		Integer dia= 5;
		Integer mes = 03;
		Integer año = 2023;
		
		LocalDate inscripcionDelAlumno = LocalDate.of(año, mes, dia);
		
		// los uno en una InscripcionAlumnoComision:

		assertTrue(unlam.inscribirAlumnoAComision(dni, idComision, inscripcionDelAlumno));
		assertFalse(unlam.inscribirAlumnoAComision(dni, idComision, inscripcionDelAlumno));
	}

}
