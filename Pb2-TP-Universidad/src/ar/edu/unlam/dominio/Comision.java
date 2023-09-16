package ar.edu.unlam.dominio;

public class Comision {
	
	private Integer id = 0;
	private Integer idComision;
	private Materia Materia;
	private CicloLectivo Ciclo;
	private Turno turno;
	private Aula aula;
 
	public Comision(Integer idComision, Materia materia, CicloLectivo ciclo, Turno turno, Aula aula) {
		this.id++;
		this.idComision = idComision;
		this.Materia = materia;
		this.Ciclo = ciclo;
		this.turno = turno;
		this.aula = aula;
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

	public Materia getMateria() {
		return Materia;
	}

	public void setMateria(Materia materia) {
		Materia = materia;
	}

	public CicloLectivo getCiclo() {
		return Ciclo;
	}

	public void setCiclo(CicloLectivo ciclo) {
		Ciclo = ciclo;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

}
