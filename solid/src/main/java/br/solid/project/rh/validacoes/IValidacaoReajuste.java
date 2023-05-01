package br.solid.project.rh.validacoes;

import java.math.BigDecimal;

import br.solid.project.rh.model.Funcionario;

//Open Close Principle
public interface IValidacaoReajuste {

    void validar(Funcionario func, BigDecimal aumento);

}
