package br.solid.project.rh.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.solid.project.rh.exception.ValidacaoException;
import br.solid.project.rh.model.Funcionario;

public class ReajusteService {
    

    public void reajusteSalarioFuncionario(Funcionario func, BigDecimal aumento){
        
        BigDecimal salarioAtual = func.getSalario();

        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
		
        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}

        BigDecimal novoSalarioAtualizado = salarioAtual.add(aumento);
        func.atualizarSalario(novoSalarioAtualizado);

    }
}
