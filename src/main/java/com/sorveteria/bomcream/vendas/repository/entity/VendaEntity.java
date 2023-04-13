package com.sorveteria.bomcream.vendas.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "venda")
public class VendaEntity {
    @Id
    private String uid;
    private String cliente;
    private Collection<ItemVendaEntity> itens;
    private BigDecimal valorDesconto;
    private BigDecimal valorTotal;
    private BigDecimal valorPago;
    private BigDecimal valorTroco;
    private String formaPagamento;
    private LocalDateTime create = LocalDateTime.now();
}
