package com.sorveteria.bomcream.vendas.repository.entity;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaTrabalhoEntity {
    private int dia;
    private String horaInicio1;
    private String horaFim1;
    private String horaInicio2;
    private String horaFim2;
    private BigDecimal valorTrabalho;
    private BigDecimal valorVale;
    private BigDecimal valorTotalDia;
}
