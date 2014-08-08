package com.senac.consultorio.view;

import java.util.ArrayList;
import java.util.Scanner;

import javax.jws.Oneway;

import com.senac.consultorio.model.Paciente;

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
				+ "5 - Hist�rico\n"
				+ "6 - Sair\n";
		
		System.out.println(menu);
		
		return scanner().nextInt();
	}
	
	public static void exibirCadastrarPaciente() {
		String menu = "Op��o Cadastro de Pacientes";
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
		System.out.println("Digite o endere�o: ");
		return scanner().nextLine();
	}
	
	public static long receberCPF() {
		System.out.println("Digite o CPF: ");
		return scanner().nextLong();
	}
	
	public static void exibirCadastradoSucesso() {
		System.out.println("Cadastro Realizado Com Sucesso!");
	}
	
	public static void exibirCadastroMedicamento() {
		String menu = "Op��o Cadastro de Medicamentos";
		System.out.println(menu);
	}
	
	public static String receberCodigoBarra() {
		System.out.println("Digite o c�digo de barra: ");
		return scanner().nextLine();
	}
	
	public static int receberTipo() {
		System.out.println("Escolha o tipo \n"
				+ "\n1 - Oral"
				+ "\n2 - Intra Venoso"
				+ "\n3 - Capsula"
				+ "\n4 - Intra Moscular");
		return scanner().nextInt();
	}
	
	public static String receberSubstancia() {
		System.out.println("Digite a subst�ncia: ");
		return scanner().nextLine();
	}
	
	public static void exibirAgendamentoConsulta() {
		String menu = "Op��o Agendamento de Consultas";
		System.out.println(menu);
	}
	
	public static int receberNumero() {
		System.out.println("Digite o n�mero: ");
		return scanner().nextInt();
	}
	
	public static int receberHorario() {
		System.out.println("Digite o hor�rio: ");
		return scanner().nextInt();
	}
	
	public static int receberData() {
		System.out.println("Digite a data: ");
		return scanner().nextInt();
	}
	
	public static String receberObservacao() {
		System.out.println("Digite a observa��o: ");
		return scanner().nextLine();
	}
	
	public static void exibirRegistrarConsulta() {
		String menu = "Op��o Registrar Consulta";
		System.out.println(menu);
	}
	
	public static void exibirHistorico() {
		String menu = "Op��o Hist�rico";
		System.out.println(menu);
	}

	public static void exibirLocalizarPaciente() {
		String menu = "Localizar Paciente";
		System.out.println(menu);
	}
	
	public static void exibirMensagem(String ms) {
		System.out.println(ms);
	}
}
