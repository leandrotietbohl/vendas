package com.sorveteria.bomcream.vendas.repository.entity;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComposicaoEntity {
    private ItemEntity item;
    private BigDecimal quantidade;
}
