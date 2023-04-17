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
public class LancamentoDTO {
    private String uid;
    private String caixa;
    private String descricao;
    private String tipo;
    private String user;
    private BigDecimal valor;
    private LocalDateTime create;
}
