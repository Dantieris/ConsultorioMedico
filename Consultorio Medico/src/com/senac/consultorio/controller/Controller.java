package com.senac.consultorio.controller;

import java.util.ArrayList;

import com.senac.consultorio.model.Consulta;
import com.senac.consultorio.model.Medicamento;
import com.senac.consultorio.model.Paciente;
import com.senac.consultorio.model.Tipo;
import com.senac.consultorio.view.Console;
import com.senac.consultorio.view.Menu;

public class Controller {
	
	private ArrayList<Paciente> pacientes;
	private ArrayList<Medicamento> medicamentos;
	private ArrayList<Consulta> consultas;
	
	public Controller() {
		pacientes 		= new ArrayList<Paciente>();
		medicamentos	= new ArrayList<Medicamento>();
		consultas 		= new ArrayList<Consulta>();
	}
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		
		Console.exibirSaudacao();
		
		while(true) {
			controller.menu();
		}
	}
	
	public void menu() {
		int op = Menu.exibirMenu();
		
		switch(op) {
		case 1 : exibirCadastrarPaciente(); break;
		case 2 : exibirCadastrarMedicamento(); break;
		case 3 : exibirAgendamentoConsulta(); break;
		case 4 : exibirRegistrarConsulta(); break;
		case 5 : exibirHistorico(); break;
		case 6 : Console.exibirEncerramento(); System.exit(0);
		}
	}
	
	private void exibirCadastrarPaciente() {
		Menu.exibirCadastrarPaciente();
		
		Paciente paciente = new Paciente(
				Menu.receberNome(),
				Menu.receberIdade(),
				Menu.receberTelefone(),
				Menu.receberEndereco(),
				Menu.receberCPF());
		
		addPaciente(paciente);
		Menu.exibirCadastradoSucesso();
	}
	
	private void addPaciente(Paciente paciente) {
		pacientes.add(paciente);
	}
	
	private void exibirCadastrarMedicamento() {
		Menu.exibirCadastroMedicamento();
		
		Medicamento medicamento = new Medicamento(
				Menu.receberNome(),
				Menu.receberCodigoBarra(),
				receberTipo(Menu.receberTipo()),
				Menu.receberSubstancia()				
				);
		
		addMedicamento(medicamento);
		Menu.exibirCadastradoSucesso();
	}

	private Tipo receberTipo(int tipo) {
		switch(tipo) {
		case 1 : return Tipo.ORAL;
		case 2 : return Tipo.INTRA_VENOSO;
		case 3 : return Tipo.CAPSULA;
		case 4 : return Tipo.INTRA_MUSCULAR;
		}
		return null;
	}
	
	private void addMedicamento(Medicamento medicamento) {
		medicamentos.add(medicamento);
	}
	
	public void exibirAgendamentoConsulta() {
		Menu.exibirAgendamentoConsulta();
		
		Consulta consulta = new Consulta(
				Menu.receberNumero(),
				Menu.receberHorario(),
				Menu.receberData(),
				Menu.receberObservacao());
		
		addConsulta(consulta);
		Menu.exibirCadastradoSucesso();
	}
	
	private void addConsulta(Consulta consulta) {
		consultas.add(consulta);
	}

	public void exibirRegistrarConsulta() {
		Menu.exibirRegistrarConsulta();
	}
	
	public void exibirHistorico() {
		Menu.exibirHistorico();
	}

}
