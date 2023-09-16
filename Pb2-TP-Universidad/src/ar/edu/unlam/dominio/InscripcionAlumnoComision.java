package ar.edu.unlam.dominio;

import java.time.LocalDate;

public class InscripcionAlumnoComision {
	
	private Integer id = 0;
	private Alumno alumno;
	private Comision comision;
	
	public InscripcionAlumnoComision(Alumno alumAInscribir, Comision comAInscibir) {
		this.id++;
		this.alumno = alumAInscribir;
		this.comision = comAInscibir;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Comision getComision() {
		return comision;
	}

	public void setComision(Comision comision) {
		this.comision = comision;
	}
}
