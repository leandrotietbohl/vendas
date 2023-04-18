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
public class CaixaInDTO {
    private String uid;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private BigDecimal valorFimDinheiro;
    private String user;
}
