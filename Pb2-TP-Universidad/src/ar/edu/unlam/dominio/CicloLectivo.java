package ar.edu.unlam.dominio;

import java.time.LocalDate;

public class CicloLectivo {
	
	private static Integer contadorIdIncrementadoCiclo = 0;
	private Integer idDelCiclo;
	private LocalDate fechaInicioCiclo;
	private LocalDate fechaFinCiclo;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinInscripcion; 

	public CicloLectivo(LocalDate fechaInicioCiclo, LocalDate fechaFinCiclo, LocalDate fechaInicioInscripcion,
			LocalDate fechaFinInscripcion) {
		
		this.fechaInicioCiclo = fechaInicioCiclo;
		this.fechaFinCiclo = fechaFinCiclo;
		this.fechaInicioInscripcion = fechaInicioInscripcion;
		this.fechaFinInscripcion = fechaFinInscripcion;
		
		CicloLectivo.contadorIdIncrementadoCiclo++;
		this.idDelCiclo = contadorIdIncrementadoCiclo;
	}
	
	public Integer getIdDelCiclo() {
		return this.idDelCiclo;
	}
	
	public static Integer getContadorIdIncrementado() {
		return CicloLectivo.contadorIdIncrementadoCiclo;
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
