package ar.edu.unlam.dominio;

public class Aula {
	
	private Integer id = 0;
	private Integer cantMaxDeAlumnos;
	private Integer numeroAula;
	private Integer cantAlumnos;
 
	public Aula(Integer numeroAula, Integer cantidadMaxDeAlumnos) {
		this.id++;
		this.numeroAula = numeroAula;
		this.cantMaxDeAlumnos = cantidadMaxDeAlumnos;
		this.cantAlumnos = 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public Integer getCantAlumnos() {
		return cantAlumnos;
	}

	public void setCantAlumnos(Integer cantAlumnos) {
		this.cantAlumnos = cantAlumnos;
	}
	
	public void sumarAlumno() {
		this.cantAlumnos++;
	}
}
