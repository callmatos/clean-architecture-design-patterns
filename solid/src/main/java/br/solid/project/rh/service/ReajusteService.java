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
    
    private List<IValidacaoReajuste> listaValidacoes;

    public ReajusteService(List<IValidacaoReajuste> listaValidacoes) {
        this.listaValidacoes = listaValidacoes;
    }

    public void reajusteSalarioFuncionario(Funcionario func, BigDecimal aumento){

        //apply the validation to reajuste to funcionario.
        this.listaValidacoes.forEach(v -> v.validar(func, aumento));

        BigDecimal novoSalarioAtualizado = func.getSalario().add(aumento);
        func.atualizarSalario(novoSalarioAtualizado);

    }
}
