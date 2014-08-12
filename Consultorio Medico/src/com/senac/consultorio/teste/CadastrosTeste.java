package com.senac.consultorio.teste;

import java.util.ArrayList;
import java.util.List;

import com.senac.consultorio.model.Consulta;
import com.senac.consultorio.model.Medicamento;
import com.senac.consultorio.model.Paciente;
import com.senac.consultorio.model.Tipo;

public class CadastrosTeste {
	public List<Paciente> pacientesCadastrados() {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		
		Paciente joao = new Paciente("João", 21, "5123568956", "Rua Andradas, Nº 3214", 03123056345);
		Paciente jose = new Paciente("José", 21, "5123568956", "Rua Andradas, Nº 3214", 03123056345);
		Paciente pedro = new Paciente("Pedro", 21, "5123568956", "Rua Andradas, Nº 3214", 03123056345);
		Paciente luiz = new Paciente("Luiz", 21, "5123568956", "Rua Andradas, Nº 3214", 03123056345);
		Paciente maria = new Paciente("Maria", 21, "5123568956", "Rua Andradas, Nº 3214", 03123056345);
		
		pacientes.add(pedro);
		pacientes.add(jose);
		pacientes.add(maria);
		pacientes.add(luiz);
		pacientes.add(joao);
		
		return pacientes;
	}
	
	public List<Medicamento> medicamentosCadastrados() {
		List<Medicamento> medicamentos = new ArrayList<Medicamento>();
		
		Medicamento neosoro = new Medicamento("Neosoro", Tipo.ORAL, "benzalconio + clor.sodio + nafazolina");
		Medicamento salonpas = new Medicamento("Salonpas" , Tipo.ORAL, "canfora+mentol+salicilato metila");
		Medicamento buscopan = new Medicamento("Buscopan", Tipo.CAPSULA, "escopolamina");
		Medicamento rivotril = new Medicamento("Rivotril", Tipo.CAPSULA, "clonazepam");
				
		medicamentos.add(neosoro);
		medicamentos.add(rivotril);
		medicamentos.add(buscopan);
		medicamentos.add(salonpas);
		
		return medicamentos;
	}
	
	public List<Consulta> consultasAgendadas(List<Paciente> pacientes) {
		List<Consulta> consultas = new ArrayList<Consulta>();
		
		Consulta consulta1345 = new Consulta(pacientes.get(0), 13112014, 1245);
		Consulta consulta1530 = new Consulta(pacientes.get(1), 13112014, 1530);
		Consulta consulta1000 = new Consulta(pacientes.get(2), 12112014, 1000);
		Consulta consulta1615 = new Consulta(pacientes.get(4), 12112014, 1615);
		
		consultas.add(consulta1615);
		consultas.add(consulta1000);
		consultas.add(consulta1530);
		consultas.add(consulta1345);
		
		return consultas;
	}
}
