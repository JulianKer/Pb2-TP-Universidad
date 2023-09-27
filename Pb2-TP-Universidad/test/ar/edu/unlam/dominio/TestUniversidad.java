package ar.edu.unlam.dominio;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Test;
import java.util.ArrayList;

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
	public void queNoSeRegistreUnAulaDeMismoNumero() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		Integer numeroAula = 406;
		Integer cantidadDeAlumnos1 = 30, cantidadDeAlumnos2 = 70;
		Aula nuevaAula1 = new Aula(numeroAula, cantidadDeAlumnos1);
		Aula nuevaAula2 = new Aula(numeroAula, cantidadDeAlumnos2);
		
		assertTrue(unlam.registrarAula(nuevaAula1));
		assertFalse(unlam.registrarAula(nuevaAula2));
	}
	
	@Test
	public void queSeRegistrenDosAulasDistintas() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		Integer numeroAula1 = 406, numeroAula2 = 120;
		Integer cantidadDeAlumnos1 = 30, cantidadDeAlumnos2 = 70;
		Aula nuevaAula1 = new Aula(numeroAula1, cantidadDeAlumnos1);
		Aula nuevaAula2 = new Aula(numeroAula2, cantidadDeAlumnos2);
		
		assertTrue(unlam.registrarAula(nuevaAula1));
		assertTrue(unlam.registrarAula(nuevaAula2));
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
	public void queSeRegistrenMateriaDistintas() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		Integer codigo1 = 2540, codigo2 = 2610;
		String nombre = "Pb2", nombre2 = "Bsd1";
		
		Materia nuevaMateria1 = new Materia(codigo1, nombre);
		Materia nuevaMateria2 = new Materia(codigo2, nombre2);
		
		assertTrue(unlam.registraMateria(nuevaMateria1));
		assertTrue(unlam.registraMateria(nuevaMateria2));
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
	public void queSeAgreguenMasDeUnaCorrelativaAUnaMateria() {
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
		
		Integer codigo3 = 500;
		String nombre3 = "Informatica General";
		Materia nuevaMateria3 = new Materia(codigo3, nombre3);
		unlam.registraMateria(nuevaMateria3);
		
		assertTrue(unlam.agregarCorrelativaAUnaMateria(codigo, codigo2));
		assertTrue(unlam.agregarCorrelativaAUnaMateria(codigo, codigo3));
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
	public void queSeRegistreUnCiclo() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		LocalDate fechaInicioCiclo = LocalDate.of(2023, 04, 05);
		LocalDate fechaFinCiclo = LocalDate.of(2023, 07, 05);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 03, 01);
		LocalDate fechaFinInscripcion = LocalDate.of(2023, 03, 10);
		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicioCiclo, fechaFinCiclo, fechaInicioInscripcion, fechaFinInscripcion);
		
		assertTrue(unlam.registrarCicloLectivo(nuevoCiclo));
	}
	
	@Test
	public void queNoSeRegistreUnMismoCiclo() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		LocalDate fechaInicioCiclo = LocalDate.of(2023, 04, 05);
		LocalDate fechaFinCiclo = LocalDate.of(2023, 07, 05);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 03, 01);
		LocalDate fechaFinInscripcion = LocalDate.of(2023, 03, 10);
		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicioCiclo, fechaFinCiclo, fechaInicioInscripcion, fechaFinInscripcion);
		
		assertTrue(unlam.registrarCicloLectivo(nuevoCiclo));
		assertFalse(unlam.registrarCicloLectivo(nuevoCiclo));
	}
	
	@Test
	public void queSeRegistren2CiclosSinFechasSuperpuestas() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		//creo un ciclo de 1er cuatri
		LocalDate fechaInicioCiclo1 = LocalDate.of(2023, 04, 05);
		LocalDate fechaFinCiclo1 = LocalDate.of(2023, 07, 05);
		LocalDate fechaInicioInscripcion1 = LocalDate.of(2023, 03, 01);
		LocalDate fechaFinInscripcion1 = LocalDate.of(2023, 03, 10);
		CicloLectivo nuevoCiclo1 = new CicloLectivo(fechaInicioCiclo1, fechaFinCiclo1, fechaInicioInscripcion1, fechaFinInscripcion1);
		
		// creo un ciclo 2do cuatri
		LocalDate fechaInicioCiclo2 = LocalDate.of(2023, 8, 05);
		LocalDate fechaFinCiclo2 = LocalDate.of(2023, 11, 05);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(2023, 07, 20);
		LocalDate fechaFinInscripcion2 = LocalDate.of(2023, 07, 28);
		CicloLectivo nuevoCiclo2 = new CicloLectivo(fechaInicioCiclo2, fechaFinCiclo2, fechaInicioInscripcion2, fechaFinInscripcion2);
		
		assertTrue(unlam.registrarCicloLectivo(nuevoCiclo1));
		assertTrue(unlam.registrarCicloLectivo(nuevoCiclo2));
	}
	
	@Test
	public void queNoSeRegistren2CiclosPorQueTienenFechasSuperpuestas() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		//creo un ciclo de 1er cuatri
		LocalDate fechaInicioCiclo1 = LocalDate.of(2023, 04, 05);
		LocalDate fechaFinCiclo1 = LocalDate.of(2023, 07, 05);
		LocalDate fechaInicioInscripcion1 = LocalDate.of(2023, 03, 01);
		LocalDate fechaFinInscripcion1 = LocalDate.of(2023, 03, 10);
		CicloLectivo nuevoCiclo1 = new CicloLectivo(fechaInicioCiclo1, fechaFinCiclo1, fechaInicioInscripcion1, fechaFinInscripcion1);
		
		// creo un ciclo 2do cuatri
		LocalDate fechaInicioCiclo2 = LocalDate.of(2023, 6, 05);
		LocalDate fechaFinCiclo2 = LocalDate.of(2023, 11, 05);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(2023, 6, 01);
		LocalDate fechaFinInscripcion2 = LocalDate.of(2023, 6, 04);
		CicloLectivo nuevoCiclo2 = new CicloLectivo(fechaInicioCiclo2, fechaFinCiclo2, fechaInicioInscripcion2, fechaFinInscripcion2);
		
		assertTrue(unlam.registrarCicloLectivo(nuevoCiclo1));
		assertFalse(unlam.registrarCicloLectivo(nuevoCiclo2));
	}
	
	@Test
	public void queSeRegistren2CiclosConFechasIgualesOSuperpuestasPeroQueTienenDistintoAño() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		//creo un ciclo de 1er cuatri
		LocalDate fechaInicioCiclo1 = LocalDate.of(2023, 04, 05);
		LocalDate fechaFinCiclo1 = LocalDate.of(2023, 07, 05);
		LocalDate fechaInicioInscripcion1 = LocalDate.of(2023, 03, 01);
		LocalDate fechaFinInscripcion1 = LocalDate.of(2023, 03, 10);
		CicloLectivo nuevoCiclo1 = new CicloLectivo(fechaInicioCiclo1, fechaFinCiclo1, fechaInicioInscripcion1, fechaFinInscripcion1);
		
		// creo un ciclo 2do cuatri
		LocalDate fechaInicioCiclo2 = LocalDate.of(2024, 04, 05);
		LocalDate fechaFinCiclo2 = LocalDate.of(2024, 07, 05);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(2024, 6, 01);
		LocalDate fechaFinInscripcion2 = LocalDate.of(2024, 6, 04);
		CicloLectivo nuevoCiclo2 = new CicloLectivo(fechaInicioCiclo2, fechaFinCiclo2, fechaInicioInscripcion2, fechaFinInscripcion2);
		
		assertTrue(unlam.registrarCicloLectivo(nuevoCiclo1));
		assertTrue(unlam.registrarCicloLectivo(nuevoCiclo2));
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
	public void queSeAsigneUnProfeAUnaComision() {
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
		
		//creo alumno:
		Integer dni = 12345678;
		String nombreA = "Julian", apellido = "Ker";
		LocalDate fechaNacimiento = LocalDate.of(2004, 10, 13);
		LocalDate fechaIngreso = LocalDate.of(2023, 4, 07);
		
		Alumno nuevoAlumno = new Alumno(dni, nombreA, apellido, fechaNacimiento, fechaIngreso);
		unlam.registrarAlumno(nuevoAlumno);
		
		Integer dia= 5;
		Integer mes = 03;
		Integer año = 2023;
		
		LocalDate fechaInscripcionDelAlumno = LocalDate.of(año, mes, dia);
		
		// los uno en una InscripcionAlumnoComision:
		assertTrue(unlam.inscribirAlumnoAComision(dni, codigoComision, fechaInscripcionDelAlumno));
		
		
		Integer dniP = 1234567;
		String nombreP = "Andy", apellidoP = "Borgeat";
		
		Profesor nuevoProfe = new Profesor(dniP, nombreP, apellidoP);
		
		unlam.registrarProfesor(nuevoProfe);
		
		assertTrue(unlam.asignarProfesorComision(dniP, codigoComision));
	}
	
	@Test
	public void queNoSeAsigneUnMismoProfeAUnaComision() {
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
		
		//creo alumno:
		Integer dni = 12345678;
		String nombreA = "Julian", apellido = "Ker";
		LocalDate fechaNacimiento = LocalDate.of(2004, 10, 13);
		LocalDate fechaIngreso = LocalDate.of(2023, 4, 07);
		
		Alumno nuevoAlumno = new Alumno(dni, nombreA, apellido, fechaNacimiento, fechaIngreso);
		unlam.registrarAlumno(nuevoAlumno);
		
		Integer dia= 5;
		Integer mes = 03;
		Integer año = 2023;
		
		LocalDate fechaInscripcionDelAlumno = LocalDate.of(año, mes, dia);
		
		// los uno en una InscripcionAlumnoComision:
		assertTrue(unlam.inscribirAlumnoAComision(dni, codigoComision, fechaInscripcionDelAlumno));
		
		
		Integer dniP = 1234567;
		String nombreP = "Andy", apellidoP = "Borgeat";
		
		Profesor nuevoProfe = new Profesor(dniP, nombreP, apellidoP);
		
		unlam.registrarProfesor(nuevoProfe);
		
		assertTrue(unlam.asignarProfesorComision(dniP, codigoComision));
		assertFalse(unlam.asignarProfesorComision(dniP, codigoComision));
	}
	
	@Test
	public void queNoSeAsigneUnProfeMasDeLosNecesariosAUnaComision() {
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
		
		//creo alumno:
		Integer dni = 12345678;
		String nombreA = "Julian", apellido = "Ker";
		LocalDate fechaNacimiento = LocalDate.of(2004, 10, 13);
		LocalDate fechaIngreso = LocalDate.of(2023, 4, 07);
		
		Alumno nuevoAlumno = new Alumno(dni, nombreA, apellido, fechaNacimiento, fechaIngreso);
		unlam.registrarAlumno(nuevoAlumno);
		
		Integer dia= 5;
		Integer mes = 03;
		Integer año = 2023;
		
		LocalDate fechaInscripcionDelAlumno = LocalDate.of(año, mes, dia);
		
		// los uno en una InscripcionAlumnoComision:
		assertTrue(unlam.inscribirAlumnoAComision(dni, codigoComision, fechaInscripcionDelAlumno));
		
		
		Integer dniP = 1234567;
		String nombreP = "Andy", apellidoP = "Borgeat";
		
		Profesor nuevoProfe = new Profesor(dniP, nombreP, apellidoP);
		unlam.registrarProfesor(nuevoProfe);
		
		Integer dniP2 = 5684215;
		String nombreP2 = "German", apellidoP2 = "Mazza";
		
		Profesor nuevoProfe2 = new Profesor(dniP2, nombreP2, apellidoP2);
		unlam.registrarProfesor(nuevoProfe2);
		
		
		
		assertTrue(unlam.asignarProfesorComision(dniP, codigoComision));
		assertFalse(unlam.asignarProfesorComision(dniP2, codigoComision));
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
	public void queSePuedaIrAFinalYAlEvaluarseNOEvaluarDeNuevoUnFinalSiFueMayorOigualA4() {
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
		
		Integer valorNota6 = 6;
		Integer valorNota4 = 4;
		
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.PRIMER_PARCIAL, valorNota6));
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.SEGUNDO_PARCIAL, valorNota6));
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.FINAL, valorNota4));
		assertFalse(unlam.evaluar(dni, codigoMateria, TipoDeNota.FINAL, valorNota4));
	}
	
	@Test
	public void queSePuedaEvaluarUnFinalConMenosDe4YotraVezUnFinalPeroCon4() {
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
		
		Integer valorNota6 = 6;
		Integer valorNota4 = 4;
		Integer valorNota2 = 2;
		
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.PRIMER_PARCIAL, valorNota6));
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.SEGUNDO_PARCIAL, valorNota6));
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.FINAL, valorNota2));
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.FINAL, valorNota4));
	}
	
	@Test
	public void queSePuedaEvaluarUn2DoParcialYDespuesNoEvaluarUn1ErParcial() {
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
		
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.SEGUNDO_PARCIAL, valorNota));
		assertFalse(unlam.evaluar(dni, codigoMateria, TipoDeNota.PRIMER_PARCIAL, valorNota));
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
	public void queNoSePuedaEvaluarUnRecuSiTengoLos2ParcialesPromocionados() {
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
	public void quePuedaEvaluarse1erParcialCon6YrecuperatorioDelSegundoPorQueEstuveAusenteCon7YAdemasElFinal() {
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
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.FINAL, valorNota7));
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
	public void quePuedaEvaluarse2doParcialYrecuperatorioDelPrimeroPorQueEstuveAusenteYAdemasElFinal() {
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
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.FINAL, valorNota7));
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
	public void quePrimeroEvalueUnaMateriaCorrelativaYLuegoLaMateriaActual() {
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
		
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.PRIMER_PARCIAL, valorNota6));
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.SEGUNDO_PARCIAL, valorNota6));
		assertTrue(unlam.evaluar(dni, codigoMateria, TipoDeNota.FINAL, valorNota7));
		 
		// como ya califique un final, no debe dejarme calificar otra nota comun
		assertFalse(unlam.evaluar(dni, codigoMateria, TipoDeNota.PRIMER_PARCIAL, valorNota7));
		assertFalse(unlam.evaluar(dni, codigoMateria, TipoDeNota.SEGUNDO_PARCIAL, valorNota7));
		assertFalse(unlam.evaluar(dni, codigoMateria, TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL, valorNota7));
		assertFalse(unlam.evaluar(dni, codigoMateria, TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL, valorNota7));
	}
	
	@Test
	public void pruebaDeDevolverLaCantidadDeLasQueMeFaltanCursarConElToString() {
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
		
		//creo un ciclo
		LocalDate fechaInicioCiclo = LocalDate.of(2023, 04, 05);
		LocalDate fechaFinCiclo = LocalDate.of(2023, 07, 05);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 03, 01);
		LocalDate fechaFinInscripcion = LocalDate.of(2023, 03, 10);
		
		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicioCiclo, fechaFinCiclo, fechaInicioInscripcion, fechaFinInscripcion);
		unlam.registrarCicloLectivo(nuevoCiclo);
		
		//creo un aula
		Integer cantidadDeAlumnos = 30;
		
		Integer numeroAula1 = 400;
		Aula nuevaAula1 = new Aula(numeroAula1, cantidadDeAlumnos);
		unlam.registrarAula(nuevaAula1);
		
		Integer numeroAula2 = 410;
		Aula nuevaAula2 = new Aula(numeroAula2, cantidadDeAlumnos);
		unlam.registrarAula(nuevaAula2);
		
		Integer numeroAula3 = 420;
		Aula nuevaAula3 = new Aula(numeroAula3, cantidadDeAlumnos);
		unlam.registrarAula(nuevaAula3);

		// busco las materias que quiero agregar a las comisiones
		Materia pb1 = unlam.buscarMateriaPorCodigo(2619);
		Materia informaticaGeneral = unlam.buscarMateriaPorCodigo(2620);
		Materia matematicaGeneral = unlam.buscarMateriaPorCodigo(2621);
		
		
		// creo las comisiones
		Integer idComision1 = 1000;
		Comision nuevaComision1 = new Comision(idComision1, pb1, nuevoCiclo, Turno.MANANA, nuevaAula1, Dias.LUN_Y_JUE);
		unlam.registrarComision(nuevaComision1);
		
		Integer idComision2 = 1100;
		Comision nuevaComision2 = new Comision(idComision2, informaticaGeneral, nuevoCiclo, Turno.MANANA, nuevaAula2, Dias.MAR_Y_VIE);
		unlam.registrarComision(nuevaComision2);
		
		Integer idComision3 = 1200;
		Comision nuevaComision3 = new Comision(idComision3, matematicaGeneral, nuevoCiclo, Turno.MANANA, nuevaAula3, Dias.MIE_Y_SAB);
		unlam.registrarComision(nuevaComision3);
		
		
		// elijo la fecha en la que se está inscribiendo el alumno
		Integer dia= 5;
		Integer mes = 03;
		Integer año = 2023;
		
		LocalDate fechaInscripcionDelAlumno = LocalDate.of(año, mes, dia);
		
		// inscribo al alumno en cada materia
		unlam.inscribirAlumnoAComision(dni, idComision1, fechaInscripcionDelAlumno);
		unlam.inscribirAlumnoAComision(dni, idComision2, fechaInscripcionDelAlumno);
		unlam.inscribirAlumnoAComision(dni, idComision3, fechaInscripcionDelAlumno);
		
		
		// evaluo las 3 materias con 7 tanto en 1er y 2do parcial en todas
		Integer valorNota7 = 7;
		
		unlam.evaluar(dni, 2619, TipoDeNota.PRIMER_PARCIAL, valorNota7);
		unlam.evaluar(dni, 2619, TipoDeNota.SEGUNDO_PARCIAL, valorNota7);
		
		unlam.evaluar(dni, 2620, TipoDeNota.PRIMER_PARCIAL, valorNota7);
		unlam.evaluar(dni, 2620, TipoDeNota.SEGUNDO_PARCIAL, valorNota7);
		
		unlam.evaluar(dni, 2621, TipoDeNota.PRIMER_PARCIAL, valorNota7);
		unlam.evaluar(dni, 2621, TipoDeNota.SEGUNDO_PARCIAL, valorNota7);
		//---------------------------
		
		ArrayList <Materia> listaQueFaltanCursar = new ArrayList<>();
		
		Integer cantEsperada = 17;
		Integer cantObtenida = unlam.obtenerMateriasQueFaltanCursarParaUnAlumno(dni).size();
		
		assertEquals(cantEsperada, cantObtenida);		
		
		listaQueFaltanCursar = unlam.obtenerMateriasQueFaltanCursarParaUnAlumno(dni);
		
		Integer i = 1;
		System.out.println("Materias que me FALTAN CURSAR: \n");
		for (Materia materia : listaQueFaltanCursar) {
			System.out.println((i) + "- " + materia.toString());
			i++;
		}
		
	}

	@Test
	public void pruebaDeDevolverLasMateriasAprobadasYMostrarlasConElToString() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		// este metodo lo podria dejar en el constructor de universidad
		// pero lo pongo aca para q en los anterioires test, me deje crear esas materias que cree,
		// pq sino me saltaba error porque para registrar materia le puse un limite de 20 (que es 
		// la cantidad que hay en desarrollo web)
		unlam.crearYRegistrarMateriasDeDesarrolloWeb();
		
		//creo alumno:
		Integer dni = 46091742;
		String nombreA = "Julian Gabriel", apellido = "Schmuker";
		LocalDate fechaNacimiento = LocalDate.of(2004, 10, 13);
		LocalDate fechaIngreso = LocalDate.of(2023, 4, 07);
		
		Alumno nuevoAlumno = new Alumno(dni, nombreA, apellido, fechaNacimiento, fechaIngreso);
		unlam.registrarAlumno(nuevoAlumno);
		
		//creo un ciclo de 1er cuatri, 2do cuatri y 3er cuatri
		LocalDate fechaInicioCiclo1 = LocalDate.of(2023, 04, 05);
		LocalDate fechaFinCiclo1 = LocalDate.of(2023, 07, 05);
		LocalDate fechaInicioInscripcion1 = LocalDate.of(2023, 03, 01);
		LocalDate fechaFinInscripcion1 = LocalDate.of(2023, 03, 10);
		
		CicloLectivo nuevoCiclo1 = new CicloLectivo(fechaInicioCiclo1, fechaFinCiclo1, fechaInicioInscripcion1, fechaFinInscripcion1);
		unlam.registrarCicloLectivo(nuevoCiclo1);
		
		// creo un ciclo 2do cuatri
		LocalDate fechaInicioCiclo2 = LocalDate.of(2023, 8, 05);
		LocalDate fechaFinCiclo2 = LocalDate.of(2023, 11, 05);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(2023, 07, 20);
		LocalDate fechaFinInscripcion2 = LocalDate.of(2023, 07, 28);
		
		CicloLectivo nuevoCiclo2 = new CicloLectivo(fechaInicioCiclo2, fechaFinCiclo2, fechaInicioInscripcion2, fechaFinInscripcion2);
		unlam.registrarCicloLectivo(nuevoCiclo2);
		
		// creo un ciclo 3er cuatri
		LocalDate fechaInicioCiclo3 = LocalDate.of(2023, 02, 05);
		LocalDate fechaFinCiclo3 = LocalDate.of(2023, 03, 05);
		LocalDate fechaInicioInscripcion3 = LocalDate.of(2023, 02, 01);
		LocalDate fechaFinInscripcion3 = LocalDate.of(2023, 02, 04);
		
		CicloLectivo nuevoCiclo3 = new CicloLectivo(fechaInicioCiclo3, fechaFinCiclo3, fechaInicioInscripcion3, fechaFinInscripcion3);
		unlam.registrarCicloLectivo(nuevoCiclo3);
		
		//creo un aula
		Integer cantidadDeAlumnos = 30;
		
		Integer numeroAula1 = 400;
		Aula nuevaAula1 = new Aula(numeroAula1, cantidadDeAlumnos);
		unlam.registrarAula(nuevaAula1);
		
		Integer numeroAula2 = 410;
		Aula nuevaAula2 = new Aula(numeroAula2, cantidadDeAlumnos);
		unlam.registrarAula(nuevaAula2);
		
		Integer numeroAula3 = 420;
		Aula nuevaAula3 = new Aula(numeroAula3, cantidadDeAlumnos);
		unlam.registrarAula(nuevaAula3);
		
		// busco las materias que quiero agregar a las comisiones
		Materia pb1 = unlam.buscarMateriaPorCodigo(2619);
		Materia informaticaGeneral = unlam.buscarMateriaPorCodigo(2620);
		Materia matematicaGeneral = unlam.buscarMateriaPorCodigo(2621);
		
		
		// creo las comisiones
		Integer idComision1 = 1000;
		Comision nuevaComision1 = new Comision(idComision1, pb1, nuevoCiclo1, Turno.MANANA, nuevaAula1, Dias.LUN_Y_JUE);
		unlam.registrarComision(nuevaComision1);
		
		Integer idComision2 = 1100;
		Comision nuevaComision2 = new Comision(idComision2, informaticaGeneral, nuevoCiclo2, Turno.MANANA, nuevaAula2, Dias.MAR_Y_VIE);
		unlam.registrarComision(nuevaComision2);
		
		Integer idComision3 = 1200;
		Comision nuevaComision3 = new Comision(idComision3, matematicaGeneral, nuevoCiclo3, Turno.MANANA, nuevaAula3, Dias.MIE_Y_SAB);
		unlam.registrarComision(nuevaComision3);
		
		
		// elijo la fecha en la que se está inscribiendo el alumno al 1er cuatrimestre
		Integer dia1 = 5;
		Integer mes1 = 03;
		Integer año1 = 2023;
		LocalDate fechaInscripcionDelAlumno1 = LocalDate.of(año1, mes1, dia1);
		
		// elijo la fecha en la que se está inscribiendo el alumno al 2do cuatrimestre
		Integer dia2 = 25;
		Integer mes2 = 07;
		Integer año2 = 2023;
		LocalDate fechaInscripcionDelAlumno2 = LocalDate.of(año2, mes2, dia2);
		
		// elijo la fecha en la que se está inscribiendo el alumno al 3er cuatrimestre
		Integer dia3 = 03;
		Integer mes3 = 02;
		Integer año3 = 2023;
		LocalDate fechaInscripcionDelAlumno3 = LocalDate.of(año3, mes3, dia3);
		
		// inscribo al alumno en cada materia
		unlam.inscribirAlumnoAComision(dni, idComision1, fechaInscripcionDelAlumno1);
		unlam.inscribirAlumnoAComision(dni, idComision2, fechaInscripcionDelAlumno2);
		unlam.inscribirAlumnoAComision(dni, idComision3, fechaInscripcionDelAlumno3);
		
		
		// evaluo las 3 materias
		Integer valorNota7 = 7;
		Integer valorNota8 = 8;
		Integer valorNota9 = 9;
		Integer valorNota10 = 10;
		
		unlam.evaluar(dni, 2619, TipoDeNota.PRIMER_PARCIAL, valorNota7);
		unlam.evaluar(dni, 2619, TipoDeNota.SEGUNDO_PARCIAL, valorNota9);
		
		unlam.evaluar(dni, 2620, TipoDeNota.PRIMER_PARCIAL, valorNota10);
		unlam.evaluar(dni, 2620, TipoDeNota.SEGUNDO_PARCIAL, valorNota8);
		
		unlam.evaluar(dni, 2621, TipoDeNota.PRIMER_PARCIAL, valorNota10);
		unlam.evaluar(dni, 2621, TipoDeNota.SEGUNDO_PARCIAL, valorNota10);
		
		
		Integer cantidadEsperada = 3, cantidadObtenida;
		
		ArrayList <InscripcionAlumnoComision> listaAprobadas = new ArrayList<>();
		listaAprobadas = unlam.obtenerListadoDeMateriasAprobadas(dni);
		cantidadObtenida = unlam.obtenerListadoDeMateriasAprobadas(dni).size();
		
		assertEquals(cantidadEsperada, cantidadObtenida);
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("Materias aprobadas SOLO por parciales: \n");
		for (InscripcionAlumnoComision inscripcionConMateriaAprobada : listaAprobadas) {
			System.out.println(inscripcionConMateriaAprobada.toString() + "\n");
		}
		System.out.println("------------------------------------------------------------------------------------------");
	}
	
	@Test
	public void pruebaDeDevolverLasMateriasAprobadasConFinalesYMostrarlasConElToString() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		// este metodo lo podria dejar en el constructor de universidad (como lo deje comentado)
		// pero lo pongo aca para q en los anterioires test, me deje crear esas materias que cree,
		// pq sino me saltaba error porque para registrar materia le puse un limite de 20 (que es 
		// la cantidad que hay en desarrollo web)
		unlam.crearYRegistrarMateriasDeDesarrolloWeb();
		
		//creo alumno:
		Integer dni = 46091742;
		String nombreA = "Julian Gabriel", apellido = "Schmuker";
		LocalDate fechaNacimiento = LocalDate.of(2004, 10, 13);
		LocalDate fechaIngreso = LocalDate.of(2023, 4, 07);
		
		Alumno nuevoAlumno = new Alumno(dni, nombreA, apellido, fechaNacimiento, fechaIngreso);
		unlam.registrarAlumno(nuevoAlumno);
		
		//creo un ciclo de 1er cuatri, 2do cuatri y 3er cuatri
		LocalDate fechaInicioCiclo1 = LocalDate.of(2023, 04, 05);
		LocalDate fechaFinCiclo1 = LocalDate.of(2023, 07, 05);
		LocalDate fechaInicioInscripcion1 = LocalDate.of(2023, 03, 01);
		LocalDate fechaFinInscripcion1 = LocalDate.of(2023, 03, 10);
		
		CicloLectivo nuevoCiclo1 = new CicloLectivo(fechaInicioCiclo1, fechaFinCiclo1, fechaInicioInscripcion1, fechaFinInscripcion1);
		unlam.registrarCicloLectivo(nuevoCiclo1);
		
		// creo un ciclo 2do cuatri
		LocalDate fechaInicioCiclo2 = LocalDate.of(2023, 8, 05);
		LocalDate fechaFinCiclo2 = LocalDate.of(2023, 11, 05);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(2023, 07, 20);
		LocalDate fechaFinInscripcion2 = LocalDate.of(2023, 07, 28);
		
		CicloLectivo nuevoCiclo2 = new CicloLectivo(fechaInicioCiclo2, fechaFinCiclo2, fechaInicioInscripcion2, fechaFinInscripcion2);
		unlam.registrarCicloLectivo(nuevoCiclo2);
		
		// creo un ciclo 3er cuatri
		LocalDate fechaInicioCiclo3 = LocalDate.of(2023, 02, 05);
		LocalDate fechaFinCiclo3 = LocalDate.of(2023, 03, 05);
		LocalDate fechaInicioInscripcion3 = LocalDate.of(2023, 02, 01);
		LocalDate fechaFinInscripcion3 = LocalDate.of(2023, 02, 04);
		
		CicloLectivo nuevoCiclo3 = new CicloLectivo(fechaInicioCiclo3, fechaFinCiclo3, fechaInicioInscripcion3, fechaFinInscripcion3);
		unlam.registrarCicloLectivo(nuevoCiclo3);
		
		//creo un aula
		Integer cantidadDeAlumnos = 30;
		
		Integer numeroAula1 = 400;
		Aula nuevaAula1 = new Aula(numeroAula1, cantidadDeAlumnos);
		unlam.registrarAula(nuevaAula1);
		
		Integer numeroAula2 = 410;
		Aula nuevaAula2 = new Aula(numeroAula2, cantidadDeAlumnos);
		unlam.registrarAula(nuevaAula2);
		
		Integer numeroAula3 = 420;
		Aula nuevaAula3 = new Aula(numeroAula3, cantidadDeAlumnos);
		unlam.registrarAula(nuevaAula3);
		
		// busco las materias que quiero agregar a las comisiones
		Materia pb1 = unlam.buscarMateriaPorCodigo(2619);
		Materia informaticaGeneral = unlam.buscarMateriaPorCodigo(2620);
		Materia matematicaGeneral = unlam.buscarMateriaPorCodigo(2621);
		
		
		// creo las comisiones
		Integer idComision1 = 1000;
		Comision nuevaComision1 = new Comision(idComision1, pb1, nuevoCiclo1, Turno.MANANA, nuevaAula1, Dias.LUN_Y_JUE);
		unlam.registrarComision(nuevaComision1);
		
		Integer idComision2 = 1100;
		Comision nuevaComision2 = new Comision(idComision2, informaticaGeneral, nuevoCiclo2, Turno.MANANA, nuevaAula2, Dias.MAR_Y_VIE);
		unlam.registrarComision(nuevaComision2);
		
		Integer idComision3 = 1200;
		Comision nuevaComision3 = new Comision(idComision3, matematicaGeneral, nuevoCiclo3, Turno.MANANA, nuevaAula3, Dias.MIE_Y_SAB);
		unlam.registrarComision(nuevaComision3);
		
		
		// elijo la fecha en la que se está inscribiendo el alumno al 1er cuatrimestre
		Integer dia1 = 5;
		Integer mes1 = 03;
		Integer año1 = 2023;
		LocalDate fechaInscripcionDelAlumno1 = LocalDate.of(año1, mes1, dia1);
		
		// elijo la fecha en la que se está inscribiendo el alumno al 2do cuatrimestre
		Integer dia2 = 25;
		Integer mes2 = 07;
		Integer año2 = 2023;
		LocalDate fechaInscripcionDelAlumno2 = LocalDate.of(año2, mes2, dia2);
		
		// elijo la fecha en la que se está inscribiendo el alumno al 3er cuatrimestre
		Integer dia3 = 03;
		Integer mes3 = 02;
		Integer año3 = 2023;
		LocalDate fechaInscripcionDelAlumno3 = LocalDate.of(año3, mes3, dia3);
		
		// inscribo al alumno en cada materia
		unlam.inscribirAlumnoAComision(dni, idComision1, fechaInscripcionDelAlumno1);
		unlam.inscribirAlumnoAComision(dni, idComision2, fechaInscripcionDelAlumno2);
		unlam.inscribirAlumnoAComision(dni, idComision3, fechaInscripcionDelAlumno3);
		
		
		// evaluo las 3 materias con 7 tanto en 1er y 2do parcial en todas
		Integer valorNota6 = 6;
		Integer valorNota7 = 7;
		
		assertTrue(unlam.evaluar(dni, 2619, TipoDeNota.PRIMER_PARCIAL, valorNota6));
		assertTrue(unlam.evaluar(dni, 2619, TipoDeNota.SEGUNDO_PARCIAL, valorNota7));
		assertTrue(unlam.evaluar(dni, 2619, TipoDeNota.FINAL, valorNota7));
		
		assertTrue(unlam.evaluar(dni, 2620, TipoDeNota.PRIMER_PARCIAL, valorNota6));
		assertTrue(unlam.evaluar(dni, 2620, TipoDeNota.SEGUNDO_PARCIAL, valorNota6));
		assertTrue(unlam.evaluar(dni, 2620, TipoDeNota.FINAL, valorNota7));
		
		assertTrue(unlam.evaluar(dni, 2621, TipoDeNota.PRIMER_PARCIAL, valorNota7));
		assertTrue(unlam.evaluar(dni, 2621, TipoDeNota.SEGUNDO_PARCIAL, valorNota6));
		assertTrue(unlam.evaluar(dni, 2621, TipoDeNota.FINAL, valorNota7));
		
		
		Integer cantidadEsperada = 3, cantidadObtenida;
		
		ArrayList <InscripcionAlumnoComision> listaAprobadas = new ArrayList<>();
		listaAprobadas = unlam.obtenerListadoDeMateriasAprobadas(dni);
		cantidadObtenida = unlam.obtenerListadoDeMateriasAprobadas(dni).size();
		
		assertEquals(cantidadEsperada, cantidadObtenida);
		
		System.out.println("\n------------------------------------------------------------------------------------------");
		System.out.println("Materias aprobadas por FINALES: \n");
		for (InscripcionAlumnoComision inscripcionConMateriaAprobada : listaAprobadas) {
			System.out.println(inscripcionConMateriaAprobada.toString() + "\n");
		}
		System.out.println("------------------------------------------------------------------------------------------");
	}
	
	@Test
	public void queObtengaPromedioPorDniDelAlumno() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		// este metodo lo podria dejar en el constructor de universidad (como lo deje comentado)
		// pero lo pongo aca para q en los anterioires test, me deje crear esas materias que cree,
		// pq sino me saltaba error porque para registrar materia le puse un limite de 20 (que es 
		// la cantidad que hay en desarrollo web)
		unlam.crearYRegistrarMateriasDeDesarrolloWeb();
		
		//creo alumno:
		Integer dni = 46091742;
		String nombreA = "Julian", apellido = "Ker";
		LocalDate fechaNacimiento = LocalDate.of(2004, 10, 13);
		LocalDate fechaIngreso = LocalDate.of(2023, 4, 07);
		
		Alumno nuevoAlumno = new Alumno(dni, nombreA, apellido, fechaNacimiento, fechaIngreso);
		unlam.registrarAlumno(nuevoAlumno);
		
		//creo un ciclo
		LocalDate fechaInicioCiclo = LocalDate.of(2023, 04, 05);
		LocalDate fechaFinCiclo = LocalDate.of(2023, 07, 05);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 03, 01);
		LocalDate fechaFinInscripcion = LocalDate.of(2023, 03, 10);
		
		CicloLectivo nuevoCiclo = new CicloLectivo(fechaInicioCiclo, fechaFinCiclo, fechaInicioInscripcion, fechaFinInscripcion);
		unlam.registrarCicloLectivo(nuevoCiclo);
		
		//creo un aula
		Integer cantidadDeAlumnos = 30;
		
		Integer numeroAula1 = 400;
		Aula nuevaAula1 = new Aula(numeroAula1, cantidadDeAlumnos);
		unlam.registrarAula(nuevaAula1);
		
		Integer numeroAula2 = 410;
		Aula nuevaAula2 = new Aula(numeroAula2, cantidadDeAlumnos);
		unlam.registrarAula(nuevaAula2);
		
		Integer numeroAula3 = 420;
		Aula nuevaAula3 = new Aula(numeroAula3, cantidadDeAlumnos);
		unlam.registrarAula(nuevaAula3);
		
		// busco las materias que quiero agregar a las comisiones
		Materia pb1 = unlam.buscarMateriaPorCodigo(2619);
		Materia informaticaGeneral = unlam.buscarMateriaPorCodigo(2620);
		Materia matematicaGeneral = unlam.buscarMateriaPorCodigo(2621);
		
		
		// creo las comisiones
		Integer idComision1 = 1000;
		Comision nuevaComision1 = new Comision(idComision1, pb1, nuevoCiclo, Turno.MANANA, nuevaAula1, Dias.LUN_Y_JUE);
		unlam.registrarComision(nuevaComision1);
		
		Integer idComision2 = 1100;
		Comision nuevaComision2 = new Comision(idComision2, informaticaGeneral, nuevoCiclo, Turno.MANANA, nuevaAula2, Dias.MAR_Y_VIE);
		unlam.registrarComision(nuevaComision2);
		
		Integer idComision3 = 1200;
		Comision nuevaComision3 = new Comision(idComision3, matematicaGeneral, nuevoCiclo, Turno.MANANA, nuevaAula3, Dias.MIE_Y_SAB);
		unlam.registrarComision(nuevaComision3);
		
		
		// elijo la fecha en la que se está inscribiendo el alumno
		Integer dia= 5;
		Integer mes = 03;
		Integer año = 2023;
		
		LocalDate fechaInscripcionDelAlumno = LocalDate.of(año, mes, dia);
		
		// inscribo al alumno en cada materia
		unlam.inscribirAlumnoAComision(dni, idComision1, fechaInscripcionDelAlumno);
		unlam.inscribirAlumnoAComision(dni, idComision2, fechaInscripcionDelAlumno);
		unlam.inscribirAlumnoAComision(dni, idComision3, fechaInscripcionDelAlumno);
		
		
		// evaluo las 3 materias
		Integer valorNota8 = 8;
		Integer valorNota9 = 9;
		
		unlam.evaluar(dni, 2619, TipoDeNota.PRIMER_PARCIAL, valorNota8);
		unlam.evaluar(dni, 2619, TipoDeNota.SEGUNDO_PARCIAL, valorNota8);
		
		unlam.evaluar(dni, 2620, TipoDeNota.PRIMER_PARCIAL, valorNota8);
		unlam.evaluar(dni, 2620, TipoDeNota.SEGUNDO_PARCIAL, valorNota8);
		
		unlam.evaluar(dni, 2621, TipoDeNota.PRIMER_PARCIAL, valorNota9);
		unlam.evaluar(dni, 2621, TipoDeNota.SEGUNDO_PARCIAL, valorNota9);
		
		Double valorEsperado, valorObtenido;
		
		valorObtenido = unlam.obtenerPromedio(dni);
		valorEsperado = 8.333;
		
		System.out.println("\nEl promedio, hasta ahora, del alumno de DNI: " + dni + " es: " + valorObtenido);
		
		assertEquals(valorEsperado, valorObtenido, 0.001); 
		              // aca le digo con un delta q, con una diferencia de 0.001, se consideran iguales
	}
	

	@Test
	public void quePuedaObtenerReporteDeNotasDeAlumnosDeUnaComision() {
		String name = "Unlam";
		Universidad unlam = new Universidad(name);
		
		// este metodo lo podria dejar en el constructor de universidad
		// pero lo pongo aca para q en los anterioires test, me deje crear esas materias que cree,
		// pq sino me saltaba error porque para registrar materia le puse un limite de 20 (que es 
		// la cantidad que hay en desarrollo web)
		unlam.crearYRegistrarMateriasDeDesarrolloWeb();
		
		//creo alumno:
		Integer dni = 46091742;
		String nombreA = "Julian Gabriel", apellido = "Schmuker";
		LocalDate fechaNacimiento = LocalDate.of(2004, 10, 13);
		LocalDate fechaIngreso = LocalDate.of(2023, 4, 07);
		
		Alumno nuevoAlumno = new Alumno(dni, nombreA, apellido, fechaNacimiento, fechaIngreso);
		unlam.registrarAlumno(nuevoAlumno);
		
		Integer dni2 = 43000847;
		String nombreA2 = "German", apellido2 = "Renzetti";
		LocalDate fechaNacimiento2 = LocalDate.of(2004, 10, 13);
		LocalDate fechaIngreso2 = LocalDate.of(2023, 4, 07);
		
		Alumno nuevoAlumno2 = new Alumno(dni2, nombreA2, apellido2, fechaNacimiento2, fechaIngreso2);
		unlam.registrarAlumno(nuevoAlumno2);
		
		//creo un ciclo de 1er cuatri, 2do cuatri y 3er cuatri
		LocalDate fechaInicioCiclo1 = LocalDate.of(2023, 04, 05);
		LocalDate fechaFinCiclo1 = LocalDate.of(2023, 07, 05);
		LocalDate fechaInicioInscripcion1 = LocalDate.of(2023, 03, 01);
		LocalDate fechaFinInscripcion1 = LocalDate.of(2023, 03, 10);
		
		CicloLectivo nuevoCiclo1 = new CicloLectivo(fechaInicioCiclo1, fechaFinCiclo1, fechaInicioInscripcion1, fechaFinInscripcion1);
		unlam.registrarCicloLectivo(nuevoCiclo1);
		
		//creo un aula
		Integer cantidadDeAlumnos = 30;
		
		Integer numeroAula1 = 400;
		Aula nuevaAula1 = new Aula(numeroAula1, cantidadDeAlumnos);
		unlam.registrarAula(nuevaAula1);
		
		// busco las materias que quiero agregar a las comisiones
		Materia pb1 = unlam.buscarMateriaPorCodigo(2619);
		
		// creo las comisiones
		Integer idComision1 = 1000;
		Comision nuevaComision1 = new Comision(idComision1, pb1, nuevoCiclo1, Turno.MANANA, nuevaAula1, Dias.LUN_Y_JUE);
		unlam.registrarComision(nuevaComision1);
		
		// elijo la fecha en la que se está inscribiendo los alumnos al 1er cuatrimestre
		Integer dia1 = 5;
		Integer mes1 = 03;
		Integer año1 = 2023;
		LocalDate fechaInscripcionDelAlumno1 = LocalDate.of(año1, mes1, dia1);
		
		// inscribo al alumno en cada materia
		unlam.inscribirAlumnoAComision(dni, idComision1, fechaInscripcionDelAlumno1);
		unlam.inscribirAlumnoAComision(dni2, idComision1, fechaInscripcionDelAlumno1);
		
		// evaluo las 3 materias
		Integer valorNota7 = 7;
		Integer valorNota9 = 9;
		
		unlam.evaluar(dni, 2619, TipoDeNota.PRIMER_PARCIAL, valorNota7);
		unlam.evaluar(dni, 2619, TipoDeNota.SEGUNDO_PARCIAL, valorNota9);
		
		unlam.evaluar(dni2, 2619, TipoDeNota.PRIMER_PARCIAL, valorNota7);
		unlam.evaluar(dni2, 2619, TipoDeNota.SEGUNDO_PARCIAL, valorNota9);
		
		
		ArrayList <String> reporteDeNotas = new ArrayList<>();
		reporteDeNotas = unlam.obtenerReporteDeNotasDeUnaComision(idComision1);
		
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Reporte De Notas de laComision: " + idComision1 + "\n");
		for (String reporteDeAlumno : reporteDeNotas) {
			System.out.println(reporteDeAlumno + "\n");
		}
		System.out.println("---------------------------------------------------------------------------------");

	}
}
