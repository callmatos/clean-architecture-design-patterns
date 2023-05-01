package br.solid.project.rh.model;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Funcionario {

	private LocalDate dataUltimoReajuste;
	private DadosPessoais dPessoais;

	public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
	
		// Principio de Liskov Substituion Principle
		dPessoais = new DadosPessoais(nome, cpf, cargo, salario);
	}

	public void atualizarSalario(BigDecimal aumento) {
		
		this.dPessoais.setSalario(aumento);
		this.dataUltimoReajuste = LocalDate.now();
	}


	public LocalDate getDataUltimoReajuste() {
		return dataUltimoReajuste;
	}

	public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
		this.dataUltimoReajuste = dataUltimoReajuste;
	}

    public void promover(Cargo novoCargo) {

		this.dPessoais.setCargo(novoCargo); 
    }

	public DadosPessoais getdPessoais() {
		return dPessoais;
	}

}