package com.sorveteria.bomcream.vendas.repository.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MesTrabalhoEntity {
    private int numero;
    private String mes;
    private List<DiaTrabalhoEntity> dias;
    private BigDecimal valorMes;
}
