package com.senac.consultorio.model;

public class Paciente {
	private String nome;
	private int idade;
	private String telefone;
	private String endereco;
	private long cpf;
	
	/**
	 * Construtor vazio.
	 */
	public Paciente() {}
	
	/**
	 * Construtor com parametros.
	 * @param nome
	 * @param idade
	 * @param telefone
	 * @param endereco
	 * @param cpf
	 */
	public Paciente(
			String nome, 
			int idade, 
			String telefone, 
			String endereco, 
			long cpf) 
	{
		this.nome = nome;
		this.idade = idade;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return getNome();
	}
}
