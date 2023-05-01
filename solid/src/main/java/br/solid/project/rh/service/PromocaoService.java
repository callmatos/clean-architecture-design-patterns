package br.solid.project.rh.service;

import br.solid.project.rh.exception.ValidacaoException;
import br.solid.project.rh.model.Cargo;
import br.solid.project.rh.model.Funcionario;

public class PromocaoService {

    public void promover(Funcionario func, boolean metBatida){

        Cargo cargoAtual = func.getdPessoais().getCargo();

        if( Cargo.GERENTE == cargoAtual){
            throw new ValidacaoException("Gerentes nao pode ser promovidos");
        }

        if (metBatida){
            Cargo novoCargo = cargoAtual.getProximoCargo();
            func.promover(novoCargo);
        } else {
            throw new ValidacaoException("Funcionario nao bateu a meta!");
        }
    }

}