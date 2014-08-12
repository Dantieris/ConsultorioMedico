package com.senac.consultorio.controller;

import java.util.ArrayList;

import com.senac.consultorio.model.Consulta;
import com.senac.consultorio.model.Medicamento;
import com.senac.consultorio.model.Paciente;
import com.senac.consultorio.model.Tipo;
import com.senac.consultorio.teste.CadastrosTeste;
import com.senac.consultorio.view.Console;
import com.senac.consultorio.view.Menu;

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
		
		while(true) {
			controller.menu();
		}
	}
	
	public void menu() {
		int op = Menu.exibirMenu();
		
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
			Console.exibirEncerramento(); 
			System.exit(0);
			break;
		default : Menu.exibirMensagem("Opção Inválida!");
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
		case 1 : 
			return Tipo.ORAL;
		case 2 : 
			return Tipo.INTRA_VENOSO;
		case 3 : 
			return Tipo.CAPSULA;
		case 4 : 
			return Tipo.INTRA_MUSCULAR;
		default : 
			Menu.exibirMensagem("Opção Inválida!");
		}
		return null;
	}
	
	private void addMedicamento(Medicamento medicamento) {
		medicamentos.add(medicamento);
	}
	
	private void exibirAgendamentoConsulta() {
		Menu.exibirAgendamentoConsulta();
		
		Consulta consulta = new Consulta(
				localizarPaciente(),				
				Menu.receberHorario(),
				Menu.receberData());
		
		addConsulta(consulta);
		Menu.exibirCadastradoSucesso();
	}
	
	private void addConsulta(Consulta consulta) {
		agendaConsultas.add(consulta);
	}

	private void exibirRegistrarConsulta() {
		Menu.exibirRegistrarConsulta();
		
		Consulta consulta = localizarConsulta();
		
		consulta.setMedicamento(localizarMedicamento());
		consulta.setObservacao(Menu.receberObservacao());
		
		if (Menu.receberFinalizarConsulta() == 1) {
			Menu.exibirConsultaRegistrada();
			this.registroConsultas.add(consulta);
			
		} else {
			Menu.exibirConsultaNaoRegistrada();
		}
	}
	
	private void exibirHistorico() {
		//Menu.exibirHistorico();
		for(Consulta c : this.registroConsultas){
			System.out.println(c.toString());
		}
		
	}

	private Paciente localizarPaciente() {
		Menu.exibirLocalizarPaciente();
		
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
		
		Menu.exibirMensagem(ms.toString());
		return (Menu.receberNumeroPaciente() - 1);
	}
	
	private Medicamento localizarMedicamento() {
		Menu.exibirLocalizarMedicamento();
		
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
		Menu.exibirMensagem(ms.toString());
		int retorno = Menu.receberNumeroMedicamento();
		if(retorno == 0){
			return 0;
		}else{
			return (retorno - 1);
		}
	}
	
	private Consulta localizarConsulta() {
		Menu.exibirLocalizarConsulta();
		
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
		
		Menu.exibirMensagem(ms.toString());
		return (Menu.receberNumeroConsulta() - 1);
	}
}
