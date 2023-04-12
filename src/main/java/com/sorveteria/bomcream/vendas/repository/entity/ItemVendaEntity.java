package com.sorveteria.bomcream.vendas.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemVendaEntity {
    ProdutoEntity produto;
    BigDecimal quantidade;
    BigDecimal valorItem;
}
