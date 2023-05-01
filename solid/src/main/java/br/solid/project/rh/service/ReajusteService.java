package br.solid.project.rh.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import br.solid.project.rh.exception.ValidacaoException;
import br.solid.project.rh.model.Funcionario;
import br.solid.project.rh.validacoes.IValidacaoReajuste;

public class ReajusteService {
    
    // The IValidacaoReajuste use the principle of "Open Close Principle where we have many type of validation implemented separadamente."
    private List<IValidacaoReajuste> listaValidacoes;

    public ReajusteService(List<IValidacaoReajuste> listaValidacoes) {
        this.listaValidacoes = listaValidacoes;
    }

    public void reajusteSalarioFuncionario(Funcionario func, BigDecimal aumento){

        //apply the validation to reajuste to funcionario.
        // Here verify the rules to reajusteSalario.
        this.listaValidacoes.forEach(v -> v.validar(func, aumento));

        // Reajuste only is applied if all rules is OK.
        BigDecimal novoSalarioAtualizado = func.getdPessoais().getSalario().add(aumento);
        func.atualizarSalario(novoSalarioAtualizado);

    }
}
