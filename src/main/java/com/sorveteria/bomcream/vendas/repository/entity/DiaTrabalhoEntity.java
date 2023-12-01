package com.sorveteria.bomcream.vendas.repository.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaTrabalhoEntity {
    private int dia;
    private LocalTime horaInicio1;
    private LocalTime horaFim1;
    private BigDecimal valorPeriodo1;
    private LocalTime horaInicio2;
    private LocalTime horaFim2;
    private BigDecimal valorPeriodo2;
}
