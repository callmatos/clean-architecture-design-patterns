package br.solid.project.rh.validacoes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.solid.project.rh.exception.ValidacaoException;
import br.solid.project.rh.model.Funcionario;

public class ValidacaoTempoReajuste implements IValidacaoReajuste{

    @Override
    public void validar(Funcionario func, BigDecimal aumento) {
        
        // Valida se o novo reajuste foi antes de 6 meses.
        LocalDate dataUltimoReajuste = func.getDataUltimoReajuste();
        long mesesDeseUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, LocalDate.now());
        if (mesesDeseUltimoReajuste < 6) {
			throw new ValidacaoException("Intervalo entre reajuste abaixo de 6 meses.");
		}
    }
}
