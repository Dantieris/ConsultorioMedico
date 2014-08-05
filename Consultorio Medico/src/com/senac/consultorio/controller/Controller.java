package com.senac.consultorio.controller;

import java.util.ArrayList;

import com.senac.consultorio.model.Paciente;
import com.senac.consultorio.view.Menu;

public class Controller {
	
	private ArrayList<Paciente> pacientes;
	
	public Controller() {
		pacientes = new ArrayList<Paciente>();
	}
	
	public static void main(String[] args) {
		while(true) {
			Controller controller = new Controller();
			controller.menu();
		}
	}
	
	public void menu() {
		int op = Menu.exibirMenu();
		
		switch(op) {
		case 1 : exibirCadastrarPaciente();
		case 2 :
		case 3 :
		case 4 :
		case 5 :
		case 6 : System.exit(0);
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
		System.out.println("Paciente cadastrado com sucesso!");
	}
	
	private void addPaciente(Paciente paciente) {
		pacientes.add(paciente);
	}

}
