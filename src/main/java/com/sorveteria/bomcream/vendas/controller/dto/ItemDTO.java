package com.sorveteria.bomcream.vendas.controller.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private String uid;
    private String nome;
    private BigDecimal valor;
    private BigDecimal quantidadeInicial;
    private BigDecimal quantidadeEmEstoque;
    private String tipoMedida;
    private LocalDateTime create;
    private LocalDateTime update;
}
