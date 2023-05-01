package br.solid.project.rh.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.solid.project.rh.exception.ValidacaoException;
import br.solid.project.rh.model.Funcionario;

public class ReajusteService {
    

    public void reajusteSalarioFuncionario(Funcionario func, BigDecimal aumento){
        
        BigDecimal salarioAtual = func.getSalario();

        // Valida o percentual
        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}

        // Valida se o novo reajuste foi antes de 6 meses.
        LocalDate dataUltimoReajuste = func.getDataUltimoReajuste();
        long mesesDeseUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, LocalDate.now());
        if (mesesDeseUltimoReajuste < 6) {
			throw new ValidacaoException("Intervalo entre reajuste abaixo de 6 meses.");
		}

        BigDecimal novoSalarioAtualizado = salarioAtual.add(aumento);
        func.atualizarSalario(novoSalarioAtualizado);

    }
}
