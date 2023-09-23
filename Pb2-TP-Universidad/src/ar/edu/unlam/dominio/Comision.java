package ar.edu.unlam.dominio;

public class Comision {
	
	private static Integer contadorIdIncrementadoCiclo = 0;
	private Integer idIncrementadoDeLaComision = 0;
	private Integer idComision;
	private Materia Materia;
	private CicloLectivo Ciclo;
	private Turno turno;
	private Aula aula;
	private Dias dias;
 
	public Comision(Integer idComision, Materia materia, CicloLectivo ciclo, Turno turno, Aula aula, Dias dias) {
		this.idComision = idComision;
		this.Materia = materia;
		this.Ciclo = ciclo;
		this.turno = turno;
		this.aula = aula;
		this.dias = dias;
		Comision.contadorIdIncrementadoCiclo++;
		this.idIncrementadoDeLaComision = contadorIdIncrementadoCiclo;
	}

	public Integer getIdIncrementadoDeLaComision() {
		return idIncrementadoDeLaComision;
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

	public Dias getDias() {
		return dias;
	}

	public void setDias(Dias dias) {
		this.dias = dias;
	}
}
