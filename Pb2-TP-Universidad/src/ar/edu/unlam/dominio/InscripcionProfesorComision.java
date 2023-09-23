package ar.edu.unlam.dominio;

public class InscripcionProfesorComision {

	private static Integer idIncrementativo = 0;
	private Integer idDeInscripcionProfeComision;
	private Profesor profesor;
	private Comision comision;

	public InscripcionProfesorComision(Profesor nuevoProfe, Comision nuevaComision) {
		this.profesor = nuevoProfe;
		this.comision = nuevaComision;
		
		InscripcionProfesorComision.idIncrementativo++;
		this.idDeInscripcionProfeComision = idIncrementativo;
	}

	public Integer getIdDeInscripcionProfeComision() {
		return idDeInscripcionProfeComision;
	}

	public void setIdDeInscripcionProfeComision(Integer idDeInscripcionProfeComision) {
		this.idDeInscripcionProfeComision = idDeInscripcionProfeComision;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Comision getComision() {
		return comision;
	}

	public void setComision(Comision comision) {
		this.comision = comision;
	}
}
