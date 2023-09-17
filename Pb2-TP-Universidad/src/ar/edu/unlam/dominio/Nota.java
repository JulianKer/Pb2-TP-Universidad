package ar.edu.unlam.dominio;

public class Nota {

	private TipoDeNota tipoDeNota;
	private Integer valor;

	public Nota(TipoDeNota tipo) {
		this.tipoDeNota = tipo;
		this.valor = 0;
	}

	public TipoDeNota getTipoDeNota() {
		return tipoDeNota;
	}

	public void setTipoDeNota(TipoDeNota tipoDeNota) {
		this.tipoDeNota = tipoDeNota;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Boolean asignarValor(Integer valor) {
		Boolean seAsigno = false;
		
		if (valor >= 1 && valor <= 10) {
			this.valor = valor;
			seAsigno = true;
		}
		return seAsigno;
	}
}
