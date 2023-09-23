package ar.edu.unlam.dominio;

public class Aula {
	
	private static Integer contadorIdIncrementadoAula = 0;
	private Integer idAula;
	private Integer cantMaxDeAlumnos;
	private Integer numeroAula;
 
	public Aula(Integer numeroAula, Integer cantidadMaxDeAlumnos) {
		this.numeroAula = numeroAula;
		this.cantMaxDeAlumnos = cantidadMaxDeAlumnos;
		Aula.contadorIdIncrementadoAula++;
		this.idAula = contadorIdIncrementadoAula;
	}

	public Integer getIdAula() {
		return idAula;
	}

	public Integer getCantMaxDeAlumnos() {
		return cantMaxDeAlumnos;
	}

	public void setCantMaxDeAlumnos(Integer cantMaxDeAlumnos) {
		this.cantMaxDeAlumnos = cantMaxDeAlumnos;
	}

	public Integer getNumeroAula() {
		return numeroAula;
	}

	public void setNumeroAula(Integer numeroAula) {
		this.numeroAula = numeroAula;
	}
}
