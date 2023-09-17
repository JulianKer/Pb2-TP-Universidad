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

		if (this.notas.size() <= 3 && encontrada == null) {
			if (!tipoDeNota.equals(TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL)    //si el tipo no es de primerRecuperatorio
					|| !tipoDeNota.equals(TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL) // o tampoco es de segundoRecuperatorio, entra.
					|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL) // ahora, si es un primerRecuperatorio, NO tiene que 
							&& buscarNotaPorTipo(TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL) == null   // haber un segudnoRecuperatorio
					|| tipoDeNota.equals(TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL)      // y viceversa, si es de segudnoRecuperatorio,
							&& buscarNotaPorTipo(TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL) == null) {  // NO tiene q haber un primerRecuperatorio

				Nota nuevaNota = new Nota(tipoDeNota);
				asignado = nuevaNota.asignarValor(valor);
				if (asignado) {
					seCalifico = this.notas.add(nuevaNota);
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
