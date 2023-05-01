package br.solid.project.rh.reajuste;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Reajuste {
    
    BigDecimal valor();
    LocalDate data();
    
}
