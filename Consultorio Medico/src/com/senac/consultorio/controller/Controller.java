package com.senac.consultorio.controller;

import java.util.ArrayList;

import com.senac.consultorio.model.Medicamento;
import com.senac.consultorio.model.Paciente;
import com.senac.consultorio.model.Tipo;
import com.senac.consultorio.view.Console;
import com.senac.consultorio.view.Menu;

public class Controller {
	
	private ArrayList<Paciente> pacientes;
	private ArrayList<Medicamento> medicamentos;
	
	public Controller() {
		pacientes 		= new ArrayList<Paciente>();
		medicamentos	= new ArrayList<Medicamento>();
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
		case 3 : break;
		case 4 : break;
		case 5 : break;
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

}
