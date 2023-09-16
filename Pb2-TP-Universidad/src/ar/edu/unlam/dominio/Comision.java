package ar.edu.unlam.dominio;

public class Comision {
	
	private Integer id = 0;
	private Integer idComision;
	private Materia nuevaMateria;
	private CicloLectivo nuevoCiclo;
	private Turno turno;
 
	public Comision(Integer idComision, Materia nuevaMateria, CicloLectivo nuevoCiclo, Turno turno) {
		this.id++;
		this.idComision = idComision;
		this.nuevaMateria = nuevaMateria;
		this.nuevoCiclo = nuevoCiclo;
		this.turno = turno;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdComision() {
		return idComision;
	}

	public void setIdComision(Integer idComision) {
		this.idComision = idComision;
	}

	public Materia getNuevaMateria() {
		return nuevaMateria;
	}

	public void setNuevaMateria(Materia nuevaMateria) {
		this.nuevaMateria = nuevaMateria;
	}

	public CicloLectivo getNuevoCiclo() {
		return nuevoCiclo;
	}

	public void setNuevoCiclo(CicloLectivo nuevoCiclo) {
		this.nuevoCiclo = nuevoCiclo;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}
}
