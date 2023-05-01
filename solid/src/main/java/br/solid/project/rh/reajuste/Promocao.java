package br.solid.project.rh.reajuste;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Promocao implements ReajusteTributavel{

    private BigDecimal valor;
    private LocalDate data;

    public Promocao(BigDecimal valor){
        this.valor = valor;
        this.data = LocalDate.now();
    }

    @Override
    public BigDecimal valor() {
        return this.valor;
    }

    @Override
    public LocalDate data() {
        return this.data;
    }

    @Override
    public BigDecimal valorImpostoRenda() {
        return valor.multiply(new BigDecimal("0.1"));
    }
    
}
