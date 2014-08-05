package com.senac.consultorio.model;

public class Medicamento {
	private int codigoBarra;
	private String nome;
	private String tipo;
	private String substancia;
	
	public int getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(int codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSubstancia() {
		return substancia;
	}
	public void setSubstancia(String substancia) {
		this.substancia = substancia;
	}
}
