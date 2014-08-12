package com.senac.consultorio.controller;

import java.util.ArrayList;

import com.senac.consultorio.model.Consulta;
import com.senac.consultorio.model.Medicamento;
import com.senac.consultorio.model.Paciente;
import com.senac.consultorio.model.Tipo;
import com.senac.consultorio.teste.CadastrosTeste;
import com.senac.consultorio.view.Console;

public class Controller {
	
	private ArrayList<Paciente> pacientes;
	private ArrayList<Medicamento> medicamentos;
	private ArrayList<Consulta> agendaConsultas;
	private ArrayList<Consulta> registroConsultas;
	
	public Controller() {
		this.pacientes 			= new ArrayList<Paciente>();
		this.medicamentos		= new ArrayList<Medicamento>();
		this.agendaConsultas 	= new ArrayList<Consulta>();
		this.registroConsultas 	= new ArrayList<Consulta>();
		
		inserirCadastroTeste();
	}
	
	private void inserirCadastroTeste() {
		CadastrosTeste ct = new CadastrosTeste();
		
		for (Paciente p : ct.pacientesCadastrados()) {
			pacientes.add(p);
		}
		
		for (Medicamento m : ct.medicamentosCadastrados()) {
			medicamentos.add(m);
		}
		
		for (Consulta c : ct.consultasAgendadas(pacientes)) {
			agendaConsultas.add(c);
		}
	}
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		
		Console.exibirSaudacao();
		
		int exit = 0;
		while(exit == 0) {
			exit = controller.menu();
		}
	}
	
	public int menu() {
		int op = Console.exibirMenu();
		
		switch(op) {
			case 1 : 
				exibirCadastrarPaciente(); 
				break;
			case 2 : 
				exibirCadastrarMedicamento(); 
				break;
			case 3 : 
				exibirAgendamentoConsulta(); 
				break;
			case 4 : 
				exibirRegistrarConsulta(); 
				break;
			case 5 : 
				exibirHistorico(); 
				break;
			case 6 : 
				exibirPacientes();
				break;
			case 7 : 
				exibirMedicamentos();
				break;
			case 8 :
				Console.exibirEncerramento(); 
				return 1;
			default : Console.exibirMensagem("Opção Inválida!");
		}
		return 0;
	}
	
	private void exibirPacientes() {
		for (Paciente paciente : pacientes) {
			Console.exibirMensagem(
					"Nome: " + 
					paciente.getNome() + 
					" - Idade: " + 
					paciente.getIdade() + 
					" anos - CPF: " + 
					paciente.getCpf() + 
					" - End.:" + 
					paciente.getEndereco() + 
					" - Fone: " + 
					paciente.getTelefone());
		}
	}
	
	private void exibirMedicamentos() {
		for (Medicamento medicamento : medicamentos) {
			Console.exibirMensagem(
					"Nome: " +
					medicamento.getNome() + 
					" - Tipo: " + 
					medicamento.getTipo().getDescricao() + 
					" - Substância: " + 
					medicamento.getSubstancia() + 
					" - Código de Barra: " + 
					medicamento.getCodigoBarra()
					);
		}
	}
	
	private void exibirCadastrarPaciente() {
		Console.exibirCadastrarPaciente();
		
		Paciente paciente = new Paciente(
				Console.receberNome(),
				Console.receberIdade(),
				Console.receberTelefone(),
				Console.receberEndereco(),
				Console.receberCPF());
		
		addPaciente(paciente);
		Console.exibirCadastradoSucesso();
	}
	
	private void addPaciente(Paciente paciente) {
		pacientes.add(paciente);
	}
	
	private void exibirCadastrarMedicamento() {
		Console.exibirCadastroMedicamento();
		
		Medicamento medicamento = new Medicamento(
				Console.receberNome(),
				receberTipo(Console.receberTipo()),
				Console.receberSubstancia()				
				);
		
		addMedicamento(medicamento);
		Console.exibirCadastradoSucesso();
	}

	private Tipo receberTipo(int tipo) {
		switch(tipo) {
		case 1 : 
			return Tipo.ORAL;
		case 2 : 
			return Tipo.INTRA_VENOSO;
		case 3 : 
			return Tipo.CAPSULA;
		case 4 : 
			return Tipo.INTRA_MUSCULAR;
		default : 
			Console.exibirMensagem("Opção Inválida!");
		}
		return null;
	}
	
	private void addMedicamento(Medicamento medicamento) {
		medicamentos.add(medicamento);
	}
	
	private void exibirAgendamentoConsulta() {
		Console.exibirAgendamentoConsulta();
		
		Consulta consulta = new Consulta(
				localizarPaciente(),				
				Console.receberHorario(),
				Console.receberData());
		
		addConsulta(consulta);
		Console.exibirCadastradoSucesso();
	}
	
	private void addConsulta(Consulta consulta) {
		agendaConsultas.add(consulta);
	}

	private void exibirRegistrarConsulta() {
		Console.exibirRegistrarConsulta();
		
		Consulta consulta = localizarConsulta();
		
		consulta.setMedicamento(localizarMedicamento());
		consulta.setObservacao(Console.receberObservacao());
		
		if (Console.receberFinalizarConsulta() == 1) {
			Console.exibirConsultaRegistrada();
			this.registroConsultas.add(consulta);
			
		} else {
			Console.exibirConsultaNaoRegistrada();
		}
	}
	
	private void exibirHistorico() {
		//Menu.exibirHistorico();
		for(Consulta c : this.registroConsultas){
			System.out.println(c.toString());
		}
		
	}

	private Paciente localizarPaciente() {
		Console.exibirLocalizarPaciente();
		
		Paciente paciente;
		do {
			paciente = pacientes.get(buscarPaciente());
		} while(paciente == null);
		
		return paciente;
	}
	
	private int buscarPaciente() {
		StringBuffer ms = new StringBuffer();
		int cont = 1;
		
		for (Paciente paciente : pacientes) {
			ms.append(cont++ + 
					" - " + 
					paciente.getNome() + 
					"\n");
		}
		
		Console.exibirMensagem(ms.toString());
		return (Console.receberNumeroPaciente() - 1);
	}
	
	private Medicamento localizarMedicamento() {
		Console.exibirLocalizarMedicamento();
		
		Medicamento medicamento;
		do {
			int idMedicamento = buscarMedicamento();
			if(idMedicamento == 0){
				medicamento = null;
				break;
			}else{			
				medicamento = medicamentos.get(idMedicamento);
			}
		} while(medicamento == null);
		
		return medicamento;
	}

	private int buscarMedicamento() {
		StringBuffer ms = new StringBuffer();
		int cont = 1;
		
		for (Medicamento medicamento : medicamentos) {
			ms.append(cont++ + 
					" - " + 
					medicamento.getNome() + 
					"\n");
		}
		Console.exibirMensagem(ms.toString());
		int retorno = Console.receberNumeroMedicamento();
		if(retorno == 0){
			return 0;
		}else{
			return (retorno - 1);
		}
	}
	
	private Consulta localizarConsulta() {
		Console.exibirLocalizarConsulta();
		
		Consulta consulta;
		do {
			consulta = agendaConsultas.get(buscarConsulta());
		} while(consulta == null);
		
		return consulta;
	}

	private int buscarConsulta() {
		StringBuffer ms = new StringBuffer();
		int cont = 1;
		
		for (Consulta consulta : agendaConsultas) {
			ms.append(cont++ + 
					" - Data: " + consulta.getData() + 
					" - Hora: " + consulta.getHorario() + 
					"\n");
		}
		
		Console.exibirMensagem(ms.toString());
		return (Console.receberNumeroConsulta() - 1);
	}
}
