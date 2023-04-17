package com.sorveteria.bomcream.vendas.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaixaOutDTO {
    private String uid;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private String userInicio;
    private String userFim;
    private BigDecimal valorInicioDinheiro;
    private BigDecimal valorFimDinheiro;
}
