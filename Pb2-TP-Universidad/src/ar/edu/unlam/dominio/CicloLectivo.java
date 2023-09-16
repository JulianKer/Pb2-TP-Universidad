package ar.edu.unlam.dominio;

import java.time.LocalDate;

public class CicloLectivo {
	
	private Integer id = 0;
	private LocalDate fechaInicioCiclo;
	private LocalDate fechaFinCiclo;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinInscripcion; 

	public CicloLectivo(LocalDate fechaInicioCiclo, LocalDate fechaFinCiclo, LocalDate fechaInicioInscripcion,
			LocalDate fechaFinInscripcion) {
		this.id++;
		this.fechaInicioCiclo = fechaInicioCiclo;
		this.fechaFinCiclo = fechaFinCiclo;
		this.fechaInicioInscripcion = fechaInicioInscripcion;
		this.fechaFinInscripcion = fechaFinInscripcion;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFechaInicioCiclo() {
		return fechaInicioCiclo;
	}

	public void setFechaInicioCiclo(LocalDate fechaInicioCiclo) {
		this.fechaInicioCiclo = fechaInicioCiclo;
	}

	public LocalDate getFechaFinCiclo() {
		return fechaFinCiclo;
	}

	public void setFechaFinCiclo(LocalDate fechaFinCiclo) {
		this.fechaFinCiclo = fechaFinCiclo;
	}

	public LocalDate getFechaInicioInscripcion() {
		return fechaInicioInscripcion;
	}

	public void setFechaInicioInscripcion(LocalDate fechaInicioInscripcion) {
		this.fechaInicioInscripcion = fechaInicioInscripcion;
	}

	public LocalDate getFechaFinInscripcion() {
		return fechaFinInscripcion;
	}

	public void setFechaFinInscripcion(LocalDate fechaFinInscripcion) {
		this.fechaFinInscripcion = fechaFinInscripcion;
	}
}
