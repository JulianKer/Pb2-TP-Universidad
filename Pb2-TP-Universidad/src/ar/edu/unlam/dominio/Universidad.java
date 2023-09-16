package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {

	private String nombre; 
	private ArrayList <Alumno> alumnos;
	private ArrayList <Materia> materias;
	private ArrayList <Aula> aulas;
	private ArrayList <Comision> comisiones;
	private ArrayList <Profesor> profesores;
	
	public Universidad(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<>();
		this.materias = new ArrayList<>();
		this.aulas = new ArrayList<>();
		this.comisiones = new ArrayList<>();
		this.profesores = new ArrayList<>();
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean registrarAlumno(Alumno nuevoAlumno) {
		Boolean seRegistro = false;
		Alumno encontrado =  buscarAlumnoPorDni(nuevoAlumno);
		
		if (encontrado == null) {
			this.alumnos.add(nuevoAlumno);
			seRegistro = this.alumnos.contains(nuevoAlumno);
		}
		return seRegistro;
	}

	public Alumno buscarAlumnoPorDni(Alumno nuevoAlumno) {
		Alumno encontrado = null;
		
		for (int i = 0; i < this.alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(nuevoAlumno.getDni())) {
				encontrado = this.alumnos.get(i);
			}
		}
//		Boolean yaExiste = this.alumnos.contains(nuevoAlumno);
//		Alumno encontrado = null;
//		 primero pregunto si lo contiene, si lo contiene, buscamelo, sino devolve null
//		if (yaExiste) {
//			encontrado = this.alumnos.get(this.alumnos.indexOf(nuevoAlumno));
//		}
//      aca le pido al array q me de algo segun un indice, y el indice
//      lo obtengo pasandole un objeto al indexOf y me devuelve su posicion
//      podria haber usado el for de toda la vida, si pero asi me manejo con arraylist
		
//      aunq aca me comparo objeto con objeto y no por dni
		return encontrado;
	}

	public Boolean registraMateria(Materia nuevaMateria) {
		Boolean seRegistro = false;
		Materia encontrada = buscarMateriaPorCodigo(nuevaMateria.getCodigo());
		
		if (encontrada == null) {
			this.materias.add(nuevaMateria);
			seRegistro = this.materias.contains(nuevaMateria);
		}
		return seRegistro;
	}

	public Materia buscarMateriaPorCodigo(Integer codigo) {
		Materia encontrada = null;
		
		for (int i = 0; i < this.materias.size(); i++) {
			if (this.materias.get(i).getCodigo().equals(codigo)) {
				encontrada = this.materias.get(i);
			}
		}
		return encontrada;
	}

	public Boolean registrarComision(Comision nuevaComision) {
		Boolean seRegistro = false;
		Comision encontrada = buscarComisionPorIdComision(nuevaComision.getIdComision());
		
		if (encontrada == null) {
			this.comisiones.add(nuevaComision);
			seRegistro = true;
		}
		return seRegistro;
	}

	public Comision buscarComisionPorIdComision(Integer idComision) {
		Comision encontrada = null;
		
		for (int i = 0; i < this.comisiones.size(); i++) {
			if (this.comisiones.get(i).getIdComision().equals(idComision)) {
				encontrada = this.comisiones.get(i);
			}
		}
		return encontrada;
	}

	public Boolean registrarProfesor(Profesor nuevoProfe) {
		Boolean seRegistro = false;
		Profesor encontrado = buscarProfesorPorDni(nuevoProfe.getDni());
		
		if (encontrado == null) {
			this.profesores.add(nuevoProfe);
			seRegistro = true;
		}
		return seRegistro;
	}

	public Profesor buscarProfesorPorDni(Integer dni) {
		Profesor encontrado = null;
		
		for (int i = 0; i < this.profesores.size(); i++) {
			if (this.profesores.get(i).getDni().equals(dni)) {
				encontrado = this.profesores.get(i);
			}
		}
		return encontrado;
	}
	
	public Boolean agregarCorrelativaAUnaMateria(Integer codigo, Integer codigoAAgregar) {
		Boolean seAgrego = false;
		Materia materia = null;
		Materia materiaAAgregar = null;
		
		
		if (!codigo.equals(codigoAAgregar)) {
			materia = buscarMateriaPorCodigo(codigo);
			materiaAAgregar = buscarMateriaPorCodigo(codigoAAgregar);
			
			if (materia != null && materiaAAgregar != null) {
				seAgrego = materia.agregarCorrelativa(codigoAAgregar);
			}
		}
		
		return seAgrego;
	}

	public Boolean eliminarCorrelativaDeUnaMateria(Integer codigo, Integer codigoAEliminar) {
		Boolean seElimino = false;
		Materia materia = buscarMateriaPorCodigo(codigo);
		Materia materiaAEliminar = buscarMateriaPorCodigo(codigoAEliminar);
		
		if (materia != null && materiaAEliminar != null) {
			seElimino = materia.eliminarCorrelativa(codigoAEliminar);
		}
		return seElimino;
	}
}
