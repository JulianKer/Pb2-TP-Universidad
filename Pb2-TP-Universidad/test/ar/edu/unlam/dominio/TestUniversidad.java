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
	public void queNoSeRegistreUnaComisionConIgualIdTurnoYAula() {
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
		assertFalse(unlam.registrarComision(nuevaComision));
	}
	
	@Test
	public void queSiSeRegistreUnaComisionConDistintoIdYDistintoTurnoPeroMismaAula() {
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
		Comision nuevaComision2 = new Comision(10, nuevaMateria, nuevoCiclo, Turno.NOCHE, nuevaAula);
		
		assertTrue(unlam.registrarComision(nuevaComision));
		assertTrue(unlam.registrarComision(nuevaComision2));
	}
	
	@Test
	public void queSeRegistreUnaInscripcionAlumnoComision() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		// creo comision:
		Integer codigoMateria = 910;
		String nombre = "Pb2";
		
		Materia nuevaMateria = new Materia(codigoMateria, nombre);
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
		
		LocalDate fechaInscripcionDelAlumno = LocalDate.of(año, mes, dia);
		
		// los uno en una InscripcionAlumnoComision:
		assertTrue(unlam.inscribirAlumnoAComision(dni, idComision, fechaInscripcionDelAlumno));
	}
	
	@Test
	public void queNoSeRegistreUnaInscripcionAlumnoComisionIgual() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		// creo comision:
		Integer codigoMateria = 910;
		String nombre = "Pb2";
		
		Materia nuevaMateria = new Materia(codigoMateria, nombre);
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
		
		LocalDate fechaInscripcionDelAlumno = LocalDate.of(año, mes, dia);
		
		// los uno en una InscripcionAlumnoComision:
		assertTrue(unlam.inscribirAlumnoAComision(dni, idComision, fechaInscripcionDelAlumno));
		assertFalse(unlam.inscribirAlumnoAComision(dni, idComision, fechaInscripcionDelAlumno));
	}
	
	@Test
	public void queSePuedaEvaluar() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		// creo comision:
		Integer codigoMateria = 910;
		String nombre = "Pb2";
		
		Materia nuevaMateria = new Materia(codigoMateria, nombre);
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
		
		LocalDate fechaInscripcionDelAlumno = LocalDate.of(año, mes, dia);
		
		// los uno en una InscripcionAlumnoComision:
		unlam.inscribirAlumnoAComision(dni, idComision, fechaInscripcionDelAlumno);
		
		Integer valorNota = 7;
		
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.PRIMER_PARCIAL, valorNota));
	}
	
	@Test
	public void queNoPuedaEvaluarComoPrimerNotaUnRecuperatorio() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		// creo comision:
		Integer codigoMateria = 910;
		String nombre = "Pb2";
		
		Materia nuevaMateria = new Materia(codigoMateria, nombre);
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
		
		LocalDate fechaInscripcionDelAlumno = LocalDate.of(año, mes, dia);
		
		// los uno en una InscripcionAlumnoComision:
		unlam.inscribirAlumnoAComision(dni, idComision, fechaInscripcionDelAlumno);
		
		Integer valorNota = 7;
		
		assertFalse(unlam.evaluar(dni, codigoMateria, TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL, valorNota));
		assertFalse(unlam.evaluar(dni, codigoMateria, TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL, valorNota));
	}
	
	@Test
	public void quePuedaEvaluarse1erY2doParcialAprobadosYNoUnRecuperatorio() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		// creo comision:
		Integer codigoMateria = 910;
		String nombre = "Pb2";
		
		Materia nuevaMateria = new Materia(codigoMateria, nombre);
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
		
		LocalDate fechaInscripcionDelAlumno = LocalDate.of(año, mes, dia);
		
		// los uno en una InscripcionAlumnoComision:
		unlam.inscribirAlumnoAComision(dni, idComision, fechaInscripcionDelAlumno);
		
		Integer valorNota7 = 7;
		Integer valorNota6 = 6;
		
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.PRIMER_PARCIAL, valorNota7));
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.SEGUNDO_PARCIAL, valorNota7));
		assertFalse(unlam.evaluar(dni, codigoMateria, TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL, valorNota7));
		assertFalse(unlam.evaluar(dni, codigoMateria, TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL, valorNota7));
	}
	
	@Test
	public void queEvalueEl1erParcialCon7YEl2doCon6YElRecuperatorioDel2doCon7() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		// creo comision:
		Integer codigoMateria = 910;
		String nombre = "Pb2";
		
		Materia nuevaMateria = new Materia(codigoMateria, nombre);
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
		
		LocalDate fechaInscripcionDelAlumno = LocalDate.of(año, mes, dia);
		
		// los uno en una InscripcionAlumnoComision:
		unlam.inscribirAlumnoAComision(dni, idComision, fechaInscripcionDelAlumno);
		
		Integer valorNota7 = 7;
		Integer valorNota6 = 6;
		
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.PRIMER_PARCIAL, valorNota7));
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.SEGUNDO_PARCIAL, valorNota6));
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL, valorNota7));
	}
	
	@Test
	public void queEvalueEl1erParcialCon6YEl2doCon7YElRecuperatorioDel1roCon7() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		// creo comision:
		Integer codigoMateria = 910;
		String nombre = "Pb2";
		
		Materia nuevaMateria = new Materia(codigoMateria, nombre);
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
		
		LocalDate fechaInscripcionDelAlumno = LocalDate.of(año, mes, dia);
		
		// los uno en una InscripcionAlumnoComision:
		unlam.inscribirAlumnoAComision(dni, idComision, fechaInscripcionDelAlumno);
		
		Integer valorNota7 = 7;
		Integer valorNota6 = 6;
		
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.PRIMER_PARCIAL, valorNota6));
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.SEGUNDO_PARCIAL, valorNota7));
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL, valorNota7));
	}
	
	@Test
	public void quePuedaEvaluarse1erParcialYrecuperatorioDelSegundoPorQueEstuveAusente() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		// creo comision:
		Integer codigoMateria = 910;
		String nombre = "Pb2";
		
		Materia nuevaMateria = new Materia(codigoMateria, nombre);
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
		
		LocalDate fechaInscripcionDelAlumno = LocalDate.of(año, mes, dia);
		
		// los uno en una InscripcionAlumnoComision:
		unlam.inscribirAlumnoAComision(dni, idComision, fechaInscripcionDelAlumno);
		
		Integer valorNota7 = 7;
		Integer valorNota6 = 6;
		
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.PRIMER_PARCIAL, valorNota6));
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL, valorNota7));
	}
	
	@Test
	public void quePuedaEvaluarse2doParcialYrecuperatorioDelPrimeroPorQueEstuveAusente() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		// creo comision:
		Integer codigoMateria = 910;
		String nombre = "Pb2";
		
		Materia nuevaMateria = new Materia(codigoMateria, nombre);
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
		
		LocalDate fechaInscripcionDelAlumno = LocalDate.of(año, mes, dia);
		
		// los uno en una InscripcionAlumnoComision:
		unlam.inscribirAlumnoAComision(dni, idComision, fechaInscripcionDelAlumno);
		
		Integer valorNota7 = 7;
		Integer valorNota6 = 6;
		
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.SEGUNDO_PARCIAL, valorNota6));
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL, valorNota7));
	}
	
	@Test
	public void quePuedaEvaluarseUnaMateriaQueTieneLasCorrelativasAprobadas() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		//creo alumno:
		Integer dni = 12345678;
		String nombreA = "Julian", apellido = "Ker";
		LocalDate fechaNacimiento = LocalDate.of(2004, 10, 13);
		LocalDate fechaIngreso = LocalDate.of(2023, 4, 07);
		
		Alumno nuevoAlumno = new Alumno(dni, nombreA, apellido, fechaNacimiento, fechaIngreso);
		unlam.registrarAlumno(nuevoAlumno);
		
		
		Integer codigoMateria = 910;
		String nombre = "Pb2";
		
		Materia nuevaMateria = new Materia(codigoMateria, nombre);
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
		
		
		// elijo la fecha en la que se está inscribiendo el alumno
		Integer dia= 5;
		Integer mes = 03;
		Integer año = 2023;
		
		LocalDate fechaInscripcionDelAlumno = LocalDate.of(año, mes, dia);
		
		// los uno en una InscripcionAlumnoComision:
		unlam.inscribirAlumnoAComision(dni, idComision, fechaInscripcionDelAlumno);
		
		Integer valorNota7 = 7;
		Integer valorNota6 = 6;
		
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.SEGUNDO_PARCIAL, valorNota6));
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL, valorNota7));
	}
	Me falta hacer el test para ver si puedo evaluar a un alumno en una materia que tiene correlativas y estan o no aprobadas
	osea hacer pb2 y pb1, pb1 la meto en pb2, evaluo pb1, me intento inscribir en pb2, e intento evaluar pb2
	
	obvio que despues me falta lo que seria inscripcion profeComision, lo de que solo puede haber 1 cada 20 alumnos
	y lo de mostrar los alumnos aprobados en listas y esos metodos del tp
}
