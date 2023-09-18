package ar.edu.unlam.dominio;

import java.util.ArrayList;

public class InscripcionAlumnoComision {

	private Integer id = 0;
	private Alumno alumno;
	private Comision comision;
	private ArrayList<Nota> notas;

	public InscripcionAlumnoComision(Alumno alumAInscribir, Comision comAInscibir) {
		this.id++;
		this.alumno = alumAInscribir;
		this.comision = comAInscibir;
		this.notas = new ArrayList<>();
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
		
		if (this.notas.size() <= 3 && encontrada == null) {
			
			if (tipoDeNota.equals(TipoDeNota.PRIMER_PARCIAL) || tipoDeNota.equals(TipoDeNota.SEGUNDO_PARCIAL)  /*si es 1er o 2do parcal, calificalo*/
					|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL) && primerParcial != null && segundoParcial != null && recuPrimerParcial == null && recuSegundoParcial == null
					|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL) && primerParcial == null && segundoParcial != null && recuPrimerParcial == null && recuSegundoParcial == null
					|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL) && primerParcial != null && segundoParcial != null && recuPrimerParcial == null && recuSegundoParcial == null
					|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL) && primerParcial != null && segundoParcial == null && recuPrimerParcial == null && recuSegundoParcial == null
					) { 
				/* 1-	Puedo calificar Recu1 si tengo p1 con -7 y p2 con +=7
				 * 2-	Puedo calificar Recu1 si tengo p1 con -4 y p2 con  +=4 y -7
				 * 3-	Puedo calificar Recu1 si tengo p1 con A y p2 con +=7
				 * 4-	Puedo calificar Recu1 si tengo p1 con A y p2 con +=4 y -7
				 * 
				 * 
				 * 1-	Puedo calificar Recu2 si tengo p1 con += 7 y p2 con -7
				 * 2-	Puedo calificar Recu2 si tengo p1 con +=4 y -7 y p2 con -4
				 * 3-	Puedo calificar Recu2 si tengo p1 con +=7 y p2 con A
				 * 4-	Puedo calificar Recu2 si tengo p1 con +=4 y -7 y p2 con A
*/
				if (tipoDeNota.equals(TipoDeNota.PRIMER_PARCIAL) || tipoDeNota.equals(TipoDeNota.SEGUNDO_PARCIAL)
						|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL) && primerParcial == null && segundoParcial.getValor() >= 7
						|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL) && primerParcial == null && segundoParcial.getValor() >= 4 && segundoParcial.getValor() < 7
						|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL) && primerParcial.getValor() >= 7 && segundoParcial == null
						|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL) && primerParcial.getValor() >=4 && primerParcial.getValor() < 7 && segundoParcial == null
						|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL) && primerParcial.getValor() < 7 && segundoParcial.getValor() >= 7
						|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL) && primerParcial.getValor() < 4 && segundoParcial.getValor() >= 4 && segundoParcial.getValor() < 7
						|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL) && primerParcial.getValor() >= 7 && segundoParcial.getValor() < 7
						|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL) && primerParcial.getValor() >= 4 && primerParcial.getValor() < 7 && segundoParcial.getValor() < 4) {
					
					Nota nuevaNota = new Nota(tipoDeNota);
					asignado = nuevaNota.asignarValor(valor);
					if (asignado) {
						seCalifico = this.notas.add(nuevaNota);
					}
				}
			}
		}
		return seCalifico;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer calcularNotaFinal() {
		Integer notaFinal = 0;

		// aca declaro estas variables para no estar poniendo el buscar... cada vez q las necesito
		Nota primerParcial = buscarNotaPorTipo(TipoDeNota.PRIMER_PARCIAL);
		Nota segundoParcial = buscarNotaPorTipo(TipoDeNota.SEGUNDO_PARCIAL);
		Nota recuPrimerParcial = buscarNotaPorTipo(TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL);
		Nota recuSegundoParcial = buscarNotaPorTipo(TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL);

		if (this.notas.size() >= 2) { // puedo calcalcular notaFinal si por lo menos tengo 2 notas
			switch (this.notas.size()) {
			case 2:
				if (primerParcial != null && segundoParcial != null) {
					notaFinal = (primerParcial.getValor() + segundoParcial.getValor()) / 2;

				} else if (primerParcial != null && recuSegundoParcial != null) {
					notaFinal = (primerParcial.getValor() + recuSegundoParcial.getValor()) / 2;

				} else if (segundoParcial != null && recuPrimerParcial != null) {
					notaFinal = (segundoParcial.getValor() + recuPrimerParcial.getValor()) / 2;
				}
				break;
			case 3:
				if (primerParcial != null && segundoParcial != null && recuPrimerParcial != null) {
					notaFinal = (segundoParcial.getValor() + recuPrimerParcial.getValor()) /2;
					
				} else if (primerParcial != null && segundoParcial != null && recuSegundoParcial != null) {
					notaFinal = (primerParcial.getValor() + recuSegundoParcial.getValor()) /2;
					
				}
				break;
			}
		}

		return notaFinal;
	}
}
