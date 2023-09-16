package ar.edu.unlam.dominio;

import java.util.ArrayList;

public class Materia {

	private Integer id = 0;
	private Integer codigo;
	private String nombre;
	private ArrayList <Integer> correlativas;
	private Integer cantMaximaDeCorrelativas;

	public Materia(Integer codigo, String nombre) {
		this.id++;
		this.codigo = codigo;
		this.nombre = nombre;
		this.correlativas = new ArrayList<>();
		this.cantMaximaDeCorrelativas = 5;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Integer> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(ArrayList<Integer> correlativas) {
		this.correlativas = correlativas;
	}

	public Integer getCantMaximaDeCorrelativas() {
		return cantMaximaDeCorrelativas;
	}

	public void setCantMaximaDeCorrelativas(Integer cantMaximaDeCorrelativas) {
		this.cantMaximaDeCorrelativas = cantMaximaDeCorrelativas;
	}

	public Boolean agregarCorrelativa(Integer codigoAAgregar) {
		Boolean seAgrego = false;
		Boolean yaEstaAgregada = this.correlativas.contains(codigoAAgregar);
		
		if (!yaEstaAgregada && this.correlativas.size() <= 5) {
			this.correlativas.add(codigoAAgregar);
			seAgrego = true;
		}
		return seAgrego;
	}

	public Boolean eliminarCorrelativa(Integer codigoAEliminar) {
		Boolean seElimino = false;
		Boolean codEncontrado = this.correlativas.contains(codigoAEliminar);
		
		if (codEncontrado) {
			this.correlativas.remove(codigoAEliminar);
			seElimino = true;
		}
		return seElimino;
	}
	

}