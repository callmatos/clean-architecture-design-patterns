package br.solid.project.rh.validacoes;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.solid.project.rh.exception.ValidacaoException;
import br.solid.project.rh.model.Funcionario;

//Open Close Principle. Class responsible only to Percentual.
public class ValidacaoPercentualReajuste implements IValidacaoReajuste{
    
    @Override
    public void validar(Funcionario func, BigDecimal aumento){
        
        BigDecimal salarioAtual = func.getdPessoais().getSalario();

        // Valida o percentual
        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
    }
}
