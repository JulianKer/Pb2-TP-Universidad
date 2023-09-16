package ar.edu.unlam.dominio;

public class Aula {
	
	private Integer id = 0;
	private Integer cantMaxDeAlumnos;
 
	public Aula(Integer cantMaxDeAlumnos) {
		this.id++;
		this.cantMaxDeAlumnos = cantMaxDeAlumnos;
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
}
