package ar.edu.unlam.dominio;

import java.time.LocalDate;

public class Alumno {
	
	private static Integer contadorIdIncrementadoAlumno = 0;
	private Integer idAlumno;
	private Integer dni;
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private LocalDate fechaIngreso;

	public Alumno(Integer dni, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaIngreso) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
		
		Alumno.contadorIdIncrementadoAlumno++;
		this.idAlumno = contadorIdIncrementadoAlumno;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setId(Integer id) {
		this.idAlumno = id;
	}
	
	

}
