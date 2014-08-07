package com.senac.consultorio.model;

public class Medicamento {
	private String codigoBarra;
	private String nome;
	private Tipo tipo;
	private String substancia;
	
	public Medicamento(String nome, String codigoBarra,
			Tipo tipo, String substancia) {
		this.nome = nome;
		this.codigoBarra = codigoBarra;
		this.tipo = tipo;
		this.substancia = substancia;
	}
	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public String getSubstancia() {
		return substancia;
	}
	public void setSubstancia(String substancia) {
		this.substancia = substancia;
	}
}
