package com.senac.consultorio.view;

import java.util.Scanner;

public class Menu {
	protected static Scanner scanner() {
		return new Scanner(System.in);
	}
	
	public static int exibirMenu() {
		String menu = "\n"
				+ "1 - Cadastrar Paciente\n"
				+ "2 - Cadastrar Medicamento\n"
				+ "3 - Agendamento de Consulta\n"
				+ "4 - Registrar Consulta\n"
				+ "5 - Histórico\n"
				+ "6 - Sair\n";
		
		System.out.println(menu);
		
		return scanner().nextInt();
	}
	
	public static void exibirCadastrarPaciente() {
		String menu = "Opção Cadastro de Pacientes";
		System.out.println(menu);
	}
	
	public static String receberNome() {
		System.out.println("Digite o nome: ");
		return scanner().nextLine();
	}
	
	public static int receberIdade() {
		System.out.println("Digite a idade: ");
		return scanner().nextInt();
	}
	
	public static String receberTelefone() {
		System.out.println("Digite o telefone: ");
		return scanner().nextLine();
	}
	
	public static String receberEndereco() {
		System.out.println("Digite o endereço: ");
		return scanner().nextLine();
	}
	
	public static long receberCPF() {
		System.out.println("Digite o CPF: ");
		return scanner().nextLong();
	}
}
