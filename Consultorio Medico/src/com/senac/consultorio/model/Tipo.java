package com.senac.consultorio.model;

public enum Tipo {
	ORAL("Oral"),
	INTRA_VENOSO("Intra Venoso"),
	CAPSULA("Capsula"),
	INTRA_MUSCULAR("Intra Muscular");
	
	private String descricao;
	
	private Tipo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
