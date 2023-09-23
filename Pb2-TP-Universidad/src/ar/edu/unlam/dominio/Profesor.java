package ar.edu.unlam.dominio;

public class Profesor {

	private static Integer contadorIdIncrementadoProfesor = 0;
	private int idProfesor = 0;
	private Integer dni; 
	private String nombre;
	private String apellido;

	public Profesor(Integer dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		
		Profesor.contadorIdIncrementadoProfesor++;
		this.idProfesor = contadorIdIncrementadoProfesor;
	}

	public int getId() {
		return idProfesor;
	}

	public void setId(int id) {
		this.idProfesor = id;
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
}
