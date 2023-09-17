package ar.edu.unlam.dominio;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestUniversidad {

	@Test
	public void queSeCreeLaUniversidad() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		assertNotNull(unlam);
	}
	
	@Test
	public void queSeRegistreUnAlumno() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		Integer dni = 12345678;
		String nombre = "Julian", apellido = "Ker";
		LocalDate fechaNacimiento = LocalDate.of(2004, 10, 13);
		LocalDate fechaIngreso = LocalDate.of(2023, 4, 07);
		
		Alumno nuevoAlumno = new Alumno(dni, nombre, apellido, fechaNacimiento, fechaIngreso);
		
		assertTrue(unlam.registrarAlumno(nuevoAlumno));
	}
	
	@Test
	public void queNoSeRegistreUnAlumnoRepetido() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		Integer dni = 12345678;
		String nombre = "Julian", apellido = "Ker";
		LocalDate fechaNacimiento = LocalDate.of(2004, 10, 13);
		LocalDate fechaIngreso = LocalDate.of(2023, 4, 07);
		
		Alumno nuevoAlumno = new Alumno(dni, nombre, apellido, fechaNacimiento, fechaIngreso);
		
		assertTrue(unlam.registrarAlumno(nuevoAlumno));
		assertFalse(unlam.registrarAlumno(nuevoAlumno));
	}
	
	@Test
	public void queSeRegistreUnAula() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		Integer numeroAula = 406;
		Integer cantidadDeAlumnos = 30;
		Aula nuevaAula = new Aula(numeroAula, cantidadDeAlumnos);
		
		assertTrue(unlam.registrarAula(nuevaAula));
	}
	
	@Test
	public void queSeRegistreLaMateria() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		Integer codigo = 910;
		String nombre = "Pb2";
		Materia nuevaMateria = new Materia(codigo, nombre);
		
		assertTrue(unlam.registraMateria(nuevaMateria));
	}
	
	@Test
	public void queNoSeRegistreLaMateriaConMismoCodigo() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		Integer codigo = 910;
		String nombre = "Pb2";
		String nombre2 = "Bsd1";
		Materia nuevaMateria = new Materia(codigo, nombre);
		Materia nuevaMateria2 = new Materia(codigo, nombre2);
		
		assertTrue(unlam.registraMateria(nuevaMateria));
		assertFalse(unlam.registraMateria(nuevaMateria2));
	}
	
	@Test
	public void queSeAgregueUnaCorrelativaAUnaMateria() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		Integer codigo = 910;
		String nombre = "Pb2";
		Materia nuevaMateria = new Materia(codigo, nombre);
		unlam.registraMateria(nuevaMateria);
		
		Integer codigo2 = 810;
		String nombre2 = "Pb1";
		Materia nuevaMateria2 = new Materia(codigo2, nombre2);
		unlam.registraMateria(nuevaMateria2);
		
		assertTrue(unlam.agregarCorrelativaAUnaMateria(codigo, codigo2));
	}
	
	@Test
	public void queNoSeAgregueUnaMismaCorrelativaAUnaMateria() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		
		Integer codigo = 910;
		String nombre = "Pb2";
		Materia nuevaMateria = new Materia(codigo, nombre);
		unlam.registraMateria(nuevaMateria);
		
		Integer codigo2 = 810;
		String nombre2 = "Pb1";
		Materia nuevaMateria2 = new Materia(codigo2, nombre2);
		unlam.registraMateria(nuevaMateria2);
		
		assertTrue(unlam.agregarCorrelativaAUnaMateria(codigo, codigo2));
		assertFalse(unlam.agregarCorrelativaAUnaMateria(codigo, codigo2));
	}
	
	@Test
	public void queSeElimineUnaCorreltivaDeUnaMateria() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		Integer codigo = 910;
		String nombre = "Pb2";
		Materia nuevaMateria = new Materia(codigo, nombre);
		unlam.registraMateria(nuevaMateria);
		
		Integer codigo2 = 810;
		String nombre2 = "Pb1";
		Materia nuevaMateria2 = new Materia(codigo2, nombre2);
		unlam.registraMateria(nuevaMateria2);
		
		unlam.agregarCorrelativaAUnaMateria(codigo, codigo2);
		
		assertTrue(unlam.eliminarCorrelativaDeUnaMateria(codigo, codigo2));
	}
	
	@Test
	public void queNoSeElimineUnaCorreltivaDeUnaMateriaQueNoExiste() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		Integer codigo = 910;
		String nombre = "Pb2";
		Materia nuevaMateria = new Materia(codigo, nombre);
		unlam.registraMateria(nuevaMateria);
		
		Integer codigo2 = 810;
		String nombre2 = "Pb1";
		Materia nuevaMateria2 = new Materia(codigo2, nombre2);
		unlam.registraMateria(nuevaMateria2);
		
		unlam.agregarCorrelativaAUnaMateria(codigo, codigo2);
		
		assertFalse(unlam.eliminarCorrelativaDeUnaMateria(codigo, 2500));
	}
	
	@Test
	public void queSeRegistreUnProfesor() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		Integer dniP = 1234567;
		String nombreP = "Andy", apellidoP = "Borgeat";
		
		Profesor nuevoProfe = new Profesor(dniP, nombreP, apellidoP);
		
		assertTrue(unlam.registrarProfesor(nuevoProfe));
	}
	
	@Test
	public void queNoSeRegistreUnProfesorConMismoDni() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		Integer dniP = 1234567;
		String nombreP = "Andy", apellidoP = "Borgeat";
		
		Profesor nuevoProfe = new Profesor(dniP, nombreP, apellidoP);
		
		assertTrue(unlam.registrarProfesor(nuevoProfe));
		assertFalse(unlam.registrarProfesor(nuevoProfe));
	}
	
	
	@Test
	public void queSeRegistreUnaComision() {
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
		
		Integer numeroAula = 406;
		Integer cantidadDeAlumnos = 30;
		Aula nuevaAula = new Aula(numeroAula, cantidadDeAlumnos);
		
		Integer codigoComision = 1300;
		Comision nuevaComision = new Comision(codigoComision, nuevaMateria, nuevoCiclo, Turno.MANANA, nuevaAula);
		
		assertTrue(unlam.registrarComision(nuevaComision));
	}
	
	@Test
	public void queNoSeoRegistreUnaComisionIgual() {
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
		
		Integer numeroAula = 406;
		Integer cantidadDeAlumnos = 30;
		Aula nuevaAula = new Aula(numeroAula, cantidadDeAlumnos);
		
		Integer codigoComision = 1300;
		Comision nuevaComision = new Comision(codigoComision, nuevaMateria, nuevoCiclo, Turno.MANANA, nuevaAula);
		Comision nuevaComision2 = new Comision(codigoComision, nuevaMateria, nuevoCiclo, Turno.MANANA, nuevaAula);
		
		assertTrue(unlam.registrarComision(nuevaComision));
		assertFalse(unlam.registrarComision(nuevaComision2));
	}
	
	@Test
	public void queSeRegistreUnaInscripcionAlumnoComision() {
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
		Comision nuevaComision = new Comision(idComision, nuevaMateria, nuevoCiclo, Turno.MANANA, nuevaAula);
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
	}
	
	@Test
	public void queNoSeRegistreUnaInscripcionAlumnoComisionIgual() {
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
		Comision nuevaComision = new Comision(idComision, nuevaMateria, nuevoCiclo, Turno.MANANA, nuevaAula);
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
	probar el tema de evaluar a un alumno , meter correlativas a una materia para luego ver si
	puedo evaluar o no, o ver si lo puedo inscribir en otra materia si no tiene aprobadas con +4
	las correlativas, etc, hago un push pq me costó una banda esto jajaja

}
