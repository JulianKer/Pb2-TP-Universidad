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
		unlam.registrarCicloLectivo(nuevoCiclo);
		
		Integer numeroAula = 406;
		Integer cantidadDeAlumnos = 30;
		Aula nuevaAula = new Aula(numeroAula, cantidadDeAlumnos);
		
		Integer codigoComision = 1300;
		Comision nuevaComision = new Comision(codigoComision, nuevaMateria, nuevoCiclo, Turno.MANANA, nuevaAula, Dias.LUN_Y_JUE);
		
		assertTrue(unlam.registrarComision(nuevaComision));
	}
	
	@Test
	public void queNoSeRegistreUnaComisionIgual() {
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
		
		assertTrue(unlam.registrarComision(nuevaComision));
		assertFalse(unlam.registrarComision(nuevaComision));
	}
	
	@Test
	public void queNoSeRegistreUnaComisionQueTieneDistintoIdPeroIgualMateria() {
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
		
		assertTrue(unlam.registrarComision(nuevaComision));
		assertFalse(unlam.registrarComision(nuevaComision));
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
		unlam.registrarCicloLectivo(nuevoCiclo);
		
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
		unlam.registrarCicloLectivo(nuevoCiclo);
		
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
		unlam.registrarCicloLectivo(nuevoCiclo);
		
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
		unlam.registrarCicloLectivo(nuevoCiclo);
		
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
		unlam.registrarCicloLectivo(nuevoCiclo);
		
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
		
		LocalDate fechaInscripcionDelAlumno = LocalDate.of(año, mes, dia);
		
		// los uno en una InscripcionAlumnoComision:
		unlam.inscribirAlumnoAComision(dni, idComision, fechaInscripcionDelAlumno);
		
		Integer valorNota7 = 7;
		
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
		unlam.registrarCicloLectivo(nuevoCiclo);
		
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
		unlam.registrarCicloLectivo(nuevoCiclo);
		
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
		unlam.registrarCicloLectivo(nuevoCiclo);
		
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
		unlam.registrarCicloLectivo(nuevoCiclo);
		
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
		unlam.registrarCicloLectivo(nuevoCiclo);
		
		Integer numeroAula = 406;
		Integer cantidadDeAlumnos = 30;
		Aula nuevaAula = new Aula(numeroAula, cantidadDeAlumnos);
		unlam.registrarAula(nuevaAula);
		
		Integer idComision = 1300;
		Comision nuevaComision = new Comision(idComision, nuevaMateria, nuevoCiclo, Turno.MANANA, nuevaAula, Dias.LUN_Y_JUE);
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
	
	@Test
	public void queNoPuedaEvaluarComoPrimerNotaUnFinal() {
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
		unlam.registrarCicloLectivo(nuevoCiclo);
		
		Integer numeroAula = 406;
		Integer cantidadDeAlumnos = 30;
		Aula nuevaAula = new Aula(numeroAula, cantidadDeAlumnos);
		unlam.registrarAula(nuevaAula);
		
		Integer idComision = 1300;
		Comision nuevaComision = new Comision(idComision, nuevaMateria, nuevoCiclo, Turno.MANANA, nuevaAula, Dias.LUN_Y_JUE);
		unlam.registrarComision(nuevaComision);
		
		
		// elijo la fecha en la que se está inscribiendo el alumno
		Integer dia= 5;
		Integer mes = 03;
		Integer año = 2023;
		
		LocalDate fechaInscripcionDelAlumno = LocalDate.of(año, mes, dia);
		
		// los uno en una InscripcionAlumnoComision:
		unlam.inscribirAlumnoAComision(dni, idComision, fechaInscripcionDelAlumno);
		
		Integer valorNota6 = 6;
		
		assertFalse(unlam.evaluar(dni, codigoMateria, TipoDeNota.FINAL, valorNota6));
	}
	
	@Test
	public void quePuedaEvaluarUnaMateriConUnFinalLaCualTieneAprobadasSusCorrelativasCon7() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		//creo alumno:
		Integer dni = 12345678;
		String nombreA = "Julian", apellido = "Ker";
		LocalDate fechaNacimiento = LocalDate.of(2004, 10, 13);
		LocalDate fechaIngreso = LocalDate.of(2023, 4, 07);
		
		Alumno nuevoAlumno = new Alumno(dni, nombreA, apellido, fechaNacimiento, fechaIngreso);
		unlam.registrarAlumno(nuevoAlumno);
		
		// creo materias
		Integer codigoMateria = 1100;
		String nombre = "Pb1";
		
		Materia nuevaMateria = new Materia(codigoMateria, nombre);
		unlam.registraMateria(nuevaMateria);
		
		Integer codigoMateria1 = 2200;
		String nombre1 = "Pb2";
		
		Materia nuevaMateria1 = new Materia(codigoMateria1, nombre1);
		unlam.registraMateria(nuevaMateria1);
		
		//le agrego pb1 como correlativa a pb2
		unlam.agregarCorrelativaAUnaMateria(codigoMateria1, codigoMateria);
		
		//creo un ciclo (con fechas de primer cuatri)
		
		LocalDate fechaInicioCiclo = LocalDate.of(2023, 03, 11); // año mes dia
		LocalDate fechaFinCiclo = LocalDate.of(2023, 06, 11); // año mes dia
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 03, 01); // año mes dia
		LocalDate fechaFinInscripcion = LocalDate.of(2023, 03, 10); // año mes dia
		
		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicioCiclo, fechaFinCiclo, fechaInicioInscripcion, fechaFinInscripcion);
		unlam.registrarCicloLectivo(nuevoCiclo);
		
		LocalDate fechaInicioCiclo1 = LocalDate.of(2023, 8, 14); // año mes dia
		LocalDate fechaFinCiclo1 = LocalDate.of(2023, 12, 14); // año mes dia
		LocalDate fechaInicioInscripcion1 = LocalDate.of(2023, 8, 01); // año mes dia
		LocalDate fechaFinInscripcion1 = LocalDate.of(2023, 8, 10); // año mes dia
		
		CicloLectivo nuevoCiclo1 = new CicloLectivo(fechaInicioCiclo1, fechaFinCiclo1, fechaInicioInscripcion1, fechaFinInscripcion1);
		unlam.registrarCicloLectivo(nuevoCiclo1);
		
		// creo dos aulas 
		Integer numeroAula = 406;
		Integer cantidadDeAlumnos = 30;
		Aula nuevaAula = new Aula(numeroAula, cantidadDeAlumnos);
		unlam.registrarAula(nuevaAula);
		
		Integer numeroAula1 = 520;
		Integer cantidadDeAlumnos1 = 45;
		Aula nuevaAula1 = new Aula(numeroAula1, cantidadDeAlumnos1);
		unlam.registrarAula(nuevaAula1);
		
		// creo las dos comisiones (las creo con distintos dias, turnos y aula pero podria no hacerlo pq en tanto el ciclo no sea el mismo, podria)
		Integer idComision = 1300;
		Comision nuevaComision = new Comision(idComision, nuevaMateria, nuevoCiclo, Turno.MANANA, nuevaAula, Dias.LUN_Y_JUE);
		unlam.registrarComision(nuevaComision);
		
		Integer idComision1 = 5100;
		Comision nuevaComision1 = new Comision(idComision1, nuevaMateria1, nuevoCiclo1, Turno.NOCHE, nuevaAula, Dias.MIE_Y_SAB);
		unlam.registrarComision(nuevaComision1);
		
		
		// elijo la fecha en la que se está inscribiendo el alumno para pb1 (primer materia en primer cuatri)
		Integer dia = 5;
		Integer mes = 03;
		Integer año = 2023;
		
		LocalDate fechaInscripcionDelAlumno = LocalDate.of(año, mes, dia);
		
		Integer dia1 = 5;
		Integer mes1 = 8;
		Integer año1 = 2023;
		
		LocalDate fechaInscripcionDelAlumno1 = LocalDate.of(año1, mes1, dia1);
		
		//------------------------------------------------------------------------------------------------------------
		// inscribo el alumno en la primer materia (pb1) y lo evaluo para luego inscribirme en pb2, entonces ahora:   //
		   																											  //
		// inscribo el alumno en pb1                                                                                  //---> PRIMER
		unlam.inscribirAlumnoAComision(dni, idComision, fechaInscripcionDelAlumno);                                   //   CUATRIMESTRE
		// lo evaluo en pb1 con primer y segundo parcial con 7 (osea ya promociono la materia pb1)                    //
		unlam.evaluar(dni, codigoMateria, TipoDeNota.PRIMER_PARCIAL, 7);                                              //
		unlam.evaluar(dni, codigoMateria, TipoDeNota.SEGUNDO_PARCIAL, 7);                                             //
		//-------------------------------------------------------------------------------------------------------------
		
		
		//------------------------------------------------------------------------------------------------------------
		// ahora intento inscribo el alumno en pb2 (en el 2do cuatri)												  //
		unlam.inscribirAlumnoAComision(dni, idComision1, fechaInscripcionDelAlumno1);								  //----> SEGUNDO
		// ahora lo evaluo con primer y segundo parcial con 7 (osea que tambien promociono la materia pb2)            //    CUATRIMESTRE
		unlam.evaluar(dni, codigoMateria1, TipoDeNota.PRIMER_PARCIAL, 7);											  //
		unlam.evaluar(dni, codigoMateria1, TipoDeNota.SEGUNDO_PARCIAL, 7);											  //
		//------------------------------------------------------------------------------------------------------------
		
		Integer notaEsperada = 7;
		Integer notaObtenida = unlam.buscarInscripcionPorDniAlumnoYIdComision(dni, idComision1).calcularNotaFinal();
		
		assertEquals(notaEsperada, notaObtenida);
	}
	
	@Test
	public void queNoPuedaCalificarConUnaNotaComunSiYaHayUnFinal() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		// este metodo lo podria dejar en el constructor de universidad (como lo deje comentado)
		// pero lo pongo aca para q en los anterioires test, me deje crear esas materias que cree,
		// pq sino me saltaba error porque para registrar materia le puse un limite de 20 (que es 
		// la cantidad que hay en desarrollo web)
//		unlam.crearYRegistrarMateriasDeDesarrolloWeb();
		
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
		unlam.registrarCicloLectivo(nuevoCiclo);
		
		Integer numeroAula = 406;
		Integer cantidadDeAlumnos = 30;
		Aula nuevaAula = new Aula(numeroAula, cantidadDeAlumnos);
		unlam.registrarAula(nuevaAula);
		
		Integer idComision = 1300;
		Comision nuevaComision = new Comision(idComision, nuevaMateria, nuevoCiclo, Turno.MANANA, nuevaAula, Dias.LUN_Y_JUE);
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
		
		// estoy calificando el pb2 que registre en este test, y no la que esta registrada
		//por el metodo de crearMaterias, lo hice para calificar mas rapido  
		unlam.evaluar(dni, codigoMateria, TipoDeNota.PRIMER_PARCIAL, valorNota6);
		unlam.evaluar(dni, codigoMateria, TipoDeNota.SEGUNDO_PARCIAL, valorNota6);
		unlam.evaluar(dni, codigoMateria, TipoDeNota.FINAL, valorNota7);
		 
		// como ya califique un final, no debe dejarme calificar otra nota comun
		assertFalse(unlam.evaluar(dni, codigoMateria, TipoDeNota.PRIMER_PARCIAL, valorNota7));
		assertFalse(unlam.evaluar(dni, codigoMateria, TipoDeNota.SEGUNDO_PARCIAL, valorNota7));
		assertFalse(unlam.evaluar(dni, codigoMateria, TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL, valorNota7));
		assertFalse(unlam.evaluar(dni, codigoMateria, TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL, valorNota7));
	}
	
	@Test
	public void pruebaDeDevolverLasQueMeFaltanCursar() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		// este metodo lo podria dejar en el constructor de universidad (como lo deje comentado)
		// pero lo pongo aca para q en los anterioires test, me deje crear esas materias que cree,
		// pq sino me saltaba error porque para registrar materia le puse un limite de 20 (que es 
		// la cantidad que hay en desarrollo web)
		unlam.crearYRegistrarMateriasDeDesarrolloWeb();
		
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
		unlam.registrarCicloLectivo(nuevoCiclo);
		
		Integer numeroAula = 406;
		Integer cantidadDeAlumnos = 30;
		Aula nuevaAula = new Aula(numeroAula, cantidadDeAlumnos);
		unlam.registrarAula(nuevaAula);
		
		Integer idComision = 1300;
		Comision nuevaComision = new Comision(idComision, nuevaMateria, nuevoCiclo, Turno.MANANA, nuevaAula, Dias.LUN_Y_JUE);
		unlam.registrarComision(nuevaComision);
		
		
		// elijo la fecha en la que se está inscribiendo el alumno
		Integer dia= 5;
		Integer mes = 03;
		Integer año = 2023;
		
		LocalDate fechaInscripcionDelAlumno = LocalDate.of(año, mes, dia);
		
		// los uno en una InscripcionAlumnoComision:
		unlam.inscribirAlumnoAComision(dni, idComision, fechaInscripcionDelAlumno);
		
		Integer valorNota7 = 7;
		
		unlam.evaluar(dni, codigoMateria, TipoDeNota.PRIMER_PARCIAL, valorNota7);
		unlam.evaluar(dni, codigoMateria, TipoDeNota.SEGUNDO_PARCIAL, valorNota7);
		
		Integer cantEsperada = 20; // pongo 20 pq de todas las q se crean, estoy agregarndo
		                          // la de este test, y apruebo la de este test
		
		
		//creo alumno:
		Integer dni3 = 11155455;
		String nombreA3 = "Julian", apellido3 = "Ker";
		LocalDate fechaNacimiento3 = LocalDate.of(2004, 10, 13);
		LocalDate fechaIngreso3 = LocalDate.of(2023, 4, 07);
		
		Alumno nuevoAlumno3 = new Alumno(dni3, nombreA3, apellido3, fechaNacimiento3, fechaIngreso3);
		unlam.registrarAlumno(nuevoAlumno3);
		
		//ñññññññ
		
		Integer cantObtenida = unlam.obtenerMateriasQueFaltanCursarParaUnAlumno(dni).size();
		
		assertEquals(cantEsperada, cantObtenida);		
	}
}
