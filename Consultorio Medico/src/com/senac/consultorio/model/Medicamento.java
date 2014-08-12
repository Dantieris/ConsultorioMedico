package com.senac.consultorio.model;

public class Medicamento {
	private static String proxCodigo;
	private static int cont = 10201;
	private String codigoBarra;
	private String nome;
	private Tipo tipo;
	private String substancia;
	
	public Medicamento(String nome, Tipo tipo, String substancia) {
		calculaCodigoBarra();
		this.nome = nome;
		this.codigoBarra = proxCodigo;
		this.tipo = tipo;
		this.substancia = substancia;
	}
	
	private void calculaCodigoBarra() {
		proxCodigo = "7891254" + cont++ + "1";
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
