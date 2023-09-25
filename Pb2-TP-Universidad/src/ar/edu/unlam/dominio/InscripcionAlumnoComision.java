package ar.edu.unlam.dominio;

import java.util.ArrayList;

public class InscripcionAlumnoComision {

	private static Integer contadorIdIncrementadoInscripcionAlumnoComision = 0;
	private Integer idInscripcionAlumnoComision;
	private Alumno alumno;
	private Comision comision;
	private ArrayList<Nota> notas;
	private Nota notaDelFinal; //----> esta es la nota de UN FINAL

	public InscripcionAlumnoComision(Alumno alumAInscribir, Comision comAInscibir) {
		this.alumno = alumAInscribir;
		this.comision = comAInscibir;
		this.notas = new ArrayList<>();
		this.notaDelFinal = null;    // por defecto la notaDelFinal no existe, es nula
		
		InscripcionAlumnoComision.contadorIdIncrementadoInscripcionAlumnoComision++;
		this.idInscripcionAlumnoComision = contadorIdIncrementadoInscripcionAlumnoComision;
	}

	public Boolean calificar(TipoDeNota tipoDeNota, Integer valor) {
		Boolean seCalifico = false;
		Boolean asignado = false;
		Nota encontrada = buscarNotaPorTipo(tipoDeNota);
		
		// aca declaro estas variables para no estar poniendo el buscar... cada vez q las necesito
		Nota primerParcial = buscarNotaPorTipo(TipoDeNota.PRIMER_PARCIAL);
		Nota segundoParcial = buscarNotaPorTipo(TipoDeNota.SEGUNDO_PARCIAL);
		Nota recuPrimerParcial = buscarNotaPorTipo(TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL);
		Nota recuSegundoParcial = buscarNotaPorTipo(TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL);
		
		// si el tipo NO es de final, entro en este if, pero si SI es de final, entro al else de mas abajo
		if (this.notas.size() < 3 && encontrada == null && !tipoDeNota.equals(TipoDeNota.FINAL) && this.notaDelFinal == null) {
			
			// Estos son los distintos casos para poder calificar una nota DISTINTA de final. (primero pregunto si existen esas bitas o no)
			if (tipoDeNota.equals(TipoDeNota.PRIMER_PARCIAL) && this.notas.size() == 0 
					|| tipoDeNota.equals(TipoDeNota.SEGUNDO_PARCIAL) && this.notas.size() == 0 
					|| tipoDeNota.equals(TipoDeNota.SEGUNDO_PARCIAL) && this.notas.size() == 1 && this.notas.get(0).getTipoDeNota().equals(TipoDeNota.PRIMER_PARCIAL)
					|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL) && primerParcial != null && segundoParcial != null && recuPrimerParcial == null && recuSegundoParcial == null
					|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL) && primerParcial == null && segundoParcial != null && recuPrimerParcial == null && recuSegundoParcial == null
					|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL) && primerParcial != null && segundoParcial != null && recuPrimerParcial == null && recuSegundoParcial == null
					|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL) && primerParcial != null && segundoParcial == null && recuPrimerParcial == null && recuSegundoParcial == null
					) { 
				
				// y aca, si ya paso el anterior if, es pq existen o no esas notas, entonces las q existen, les pregunto su valor.
				
				if (tipoDeNota.equals(TipoDeNota.PRIMER_PARCIAL) || tipoDeNota.equals(TipoDeNota.SEGUNDO_PARCIAL)
						|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL) && primerParcial == null && segundoParcial.getValor() >= 4
						|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL) && primerParcial.getValor() < 7 && segundoParcial.getValor() >= 4
						|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL) && primerParcial.getValor() >= 4 && segundoParcial == null
						|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL) && primerParcial.getValor() >= 4 && segundoParcial.getValor() < 7) {
						
					Nota nuevaNota = new Nota(tipoDeNota);
					asignado = nuevaNota.asignarValor(valor);
					if (asignado) {
						seCalifico = this.notas.add(nuevaNota);
					}
				}
			}
		} else if(TipoDeNota.FINAL.equals(tipoDeNota)){ // si el tipo es FINAL, entro a este else donde se verifican las distintas opciones para poder calificar un final
			if (this.notaDelFinal == null || this.notaDelFinal != null && this.notaDelFinal.getValor() < 4) {
				Nota nuevaNotaFinal = new Nota(tipoDeNota);
				seCalifico = calificarUnFinal(valor, primerParcial, segundoParcial, recuPrimerParcial, recuSegundoParcial, nuevaNotaFinal);				
			}
		}
		 
		return seCalifico;
	}

	private Boolean calificarUnFinal(Integer valor, Nota primerParcial, Nota segundoParcial,
			Nota recuPrimerParcial, Nota recuSegundoParcial, Nota nuevaNotaFinal) {
		Boolean calificado = false;
		
		if (this.notas.size() >= 2) { // puedo calificar un FINAL si tengo las siguientes opciones:
			switch (this.notas.size()) {
			case 2:
				if (primerParcial != null && segundoParcial != null) {
					if (primerParcial.getValor() >= 4 && segundoParcial.getValor() >= 4 
							&& (primerParcial.getValor() < 7 && segundoParcial.getValor() >= 7 
							|| primerParcial.getValor() >= 7 && segundoParcial.getValor() < 7 
							|| primerParcial.getValor() < 7 && segundoParcial.getValor() < 7)) {
						this.notaDelFinal = nuevaNotaFinal;
						calificado = nuevaNotaFinal.asignarValor(valor);
					}
					
				} else if (primerParcial != null && recuSegundoParcial != null) {
					if (primerParcial.getValor() >= 4 && recuSegundoParcial.getValor() >= 4 
							&& (primerParcial.getValor() < 7 && recuSegundoParcial.getValor() >= 7 
							|| primerParcial.getValor() >= 7 && recuSegundoParcial.getValor() < 7 
							|| primerParcial.getValor() < 7 && recuSegundoParcial.getValor() < 7)) {
						calificado = nuevaNotaFinal.asignarValor(valor);					
						this.notaDelFinal = nuevaNotaFinal;
					}
					
				} else if (segundoParcial != null && recuPrimerParcial != null) {
					if (segundoParcial.getValor() >= 4 && recuPrimerParcial.getValor() >= 4 
							&& (segundoParcial.getValor() < 7 && recuPrimerParcial.getValor() >= 7 
							|| segundoParcial.getValor() >= 7 && recuPrimerParcial.getValor() < 7 
							|| segundoParcial.getValor() < 7 && recuPrimerParcial.getValor() < 7)) {
						this.notaDelFinal = nuevaNotaFinal;
						calificado = nuevaNotaFinal.asignarValor(valor);					
					}
				}
				break;
			case 3:
				if (primerParcial != null && segundoParcial != null && recuPrimerParcial != null) {
					if (primerParcial.getValor() < 4 && segundoParcial.getValor() >= 4 && recuPrimerParcial.getValor() >= 4) {
						calificado = nuevaNotaFinal.asignarValor(valor);					
						this.notaDelFinal = nuevaNotaFinal;
					}
					
				} else if (primerParcial != null && segundoParcial != null && recuSegundoParcial != null) {
					if (primerParcial.getValor() >= 4 && recuSegundoParcial.getValor() < 4 && recuSegundoParcial.getValor() >= 4) {
						calificado = nuevaNotaFinal.asignarValor(valor);					
						this.notaDelFinal = nuevaNotaFinal;
					}
				}
				break;
			}
		}
		return calificado;
	}

	public Nota buscarNotaPorTipo(TipoDeNota tipoDeNota) {
		Nota encontrada = null;

		for (int i = 0; i < this.notas.size(); i++) {
			if (this.notas.get(i).getTipoDeNota().equals(tipoDeNota)) {
				encontrada = this.notas.get(i);
			}
		}
		return encontrada;
	}

	public Integer getIdInscripcionAlumnoComision() {
		return idInscripcionAlumnoComision;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Comision getComision() {
		return comision;
	}

	public void setComision(Comision comision) {
		this.comision = comision;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	public Nota getNotaDelFinal() {
		return notaDelFinal;
	}

	public void setNotaDelFinal(Nota notaDelFinal) {
		this.notaDelFinal = notaDelFinal;
	}

	public Integer calcularNotaFinal() {
		Integer notaFinal = 0;

		// aca declaro estas variables para no estar poniendo el buscar... cada vez q las necesito
		Nota primerParcial = buscarNotaPorTipo(TipoDeNota.PRIMER_PARCIAL);
		Nota segundoParcial = buscarNotaPorTipo(TipoDeNota.SEGUNDO_PARCIAL);
		Nota recuPrimerParcial = buscarNotaPorTipo(TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL);
		Nota recuSegundoParcial = buscarNotaPorTipo(TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL);
		
		if (this.notaDelFinal != null) { // si tengo una nota de algun final, entro aca
			notaFinal = this.notaDelFinal.getValor();
		}else {
			if (this.notas.size() >= 2) { // puedo calcalcular notaFinal si por lo menos tengo 2 notas
				switch (this.notas.size()) {
				case 2: // si solo tengo 2 notas, entro aca (pude haber faltado a algun parcial o no haber hecho recuperatorios)
					if (primerParcial != null && segundoParcial != null) {
						if (primerParcial.getValor() >= 7 && segundoParcial.getValor() >= 7) {
							notaFinal = (primerParcial.getValor() + segundoParcial.getValor()) / 2;					
						}
						
					} else if (primerParcial != null && recuSegundoParcial != null) {
						if (primerParcial.getValor() >= 7 && recuSegundoParcial.getValor() >= 7 ) {
							notaFinal = (primerParcial.getValor() + recuSegundoParcial.getValor()) / 2;						
						}
						
					} else if (segundoParcial != null && recuPrimerParcial != null) {
						if (segundoParcial.getValor() >= 7 && recuPrimerParcial.getValor() >= 7 ) {
							notaFinal = (segundoParcial.getValor() + recuPrimerParcial.getValor()) / 2;						
						}
					}
					break;
				case 3: // si tengo 3 notas, entro aca (pude haberme presentado a los parciales pero en alguno me fue mal y lo recupere)
					if (primerParcial != null && segundoParcial != null && recuPrimerParcial != null) {
						if (segundoParcial.getValor() >= 7 && recuPrimerParcial.getValor() >= 7 ) {
							notaFinal = (segundoParcial.getValor() + recuPrimerParcial.getValor()) /2;						
						}
						
					} else if (primerParcial != null && segundoParcial != null && recuSegundoParcial != null) {
						if (primerParcial.getValor() >= 7 && recuSegundoParcial.getValor() >= 7 ) {
							notaFinal = (primerParcial.getValor() + recuSegundoParcial.getValor()) /2;						
						}
					}
					break;
				}
			}
		}

		return notaFinal;
	}

	@Override
	public String toString() {
		String mensaje = this.alumno.getDni() + " " + this.alumno.getApellido() + " " + this.alumno.getNombre() 
		+ " | Materia: " + this.comision.getMateria().getNombre() + " | Nota: " + calcularNotaFinal()
		+ " | " + this.comision.getCiclo().getFechaFinCiclo().getYear();
		
		if (this.comision.getCiclo().getFechaInicioCiclo().getMonthValue() > 3 && this.comision.getCiclo().getFechaFinCiclo().getMonthValue() < 8)
			mensaje += " 1C";	// despues de 3 (Marzo) y antes de 8 (Agosto) --> 1C 
		else if (this.comision.getCiclo().getFechaInicioCiclo().getMonthValue() > 7 && this.comision.getCiclo().getFechaFinCiclo().getMonthValue() < 12) 
			mensaje += " 2C";  // despues de 7 (Julio) y antes de 12 (Diciembre) --> 2C
		else 
			mensaje += " 3C";  // despues de 11 (Noviembre) y antes de 4 (Abril) --> 3C (serian las materias de verano)
		
		return mensaje;
	}
	
	
}
