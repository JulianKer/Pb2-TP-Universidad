package ar.edu.unlam.dominio;

public class Nota {
	
	private static Integer contadorIdIncrementadoNota = 0;
	private Integer idNota;
	private TipoDeNota tipoDeNota;
	private Integer valor;

	public Nota(TipoDeNota tipo) {
		this.tipoDeNota = tipo;
		this.valor = 0;
		
		Nota.contadorIdIncrementadoNota++;
		this.idNota = contadorIdIncrementadoNota;
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

	public static Integer getContadorIdIncrementadoNota() {
		return contadorIdIncrementadoNota;
	}

	public static void setContadorIdIncrementadoNota(Integer contadorIdIncrementadoNota) {
		Nota.contadorIdIncrementadoNota = contadorIdIncrementadoNota;
	}

	public Integer getIdNota() {
		return idNota;
	}

	public void setIdNota(Integer idNota) {
		this.idNota = idNota;
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
