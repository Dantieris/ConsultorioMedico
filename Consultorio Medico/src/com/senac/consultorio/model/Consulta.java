package com.senac.consultorio.model;

public class Consulta {
	private Paciente paciente;
	private Medicamento medicamento;
	private int numero;
	private int horario;
	private int data;
	private String observacao;
	
	public Consulta() {	}
	
	public Consulta(int numero, int horario, int data,
			String observacao) {
		this.numero 	= numero;
		this.horario 	= horario;
		this.data 		= data;
		this.observacao = observacao;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medicamento getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getHorario() {
		return horario;
	}
	public void setHorario(int horario) {
		this.horario = horario;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
