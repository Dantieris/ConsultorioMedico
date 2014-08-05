package com.senac.consultorio.controller;

import java.util.ArrayList;

import com.senac.consultorio.model.Paciente;
import com.senac.consultorio.view.Console;
import com.senac.consultorio.view.Menu;

public class Controller {
	
	private ArrayList<Paciente> pacientes;
	
	public Controller() {
		pacientes 	= new ArrayList<Paciente>();
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
		case 2 : break;
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
		System.out.println("Paciente cadastrado com sucesso!");
	}
	
	private void addPaciente(Paciente paciente) {
		pacientes.add(paciente);
	}

}
