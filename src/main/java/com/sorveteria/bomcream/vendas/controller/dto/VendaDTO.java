package com.sorveteria.bomcream.vendas.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendaDTO {
    private String uid;
    private String caixa;
    private String cliente;
    private Collection<ItemVendaDTO> itens;
    private BigDecimal valorDesconto;
    private BigDecimal valorTotal;
    private BigDecimal valorPago;
    private BigDecimal valorTroco;
    private String formaPagamento;
    private LocalDateTime create;
}
