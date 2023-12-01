package com.sorveteria.bomcream.vendas.controller.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaTrabalhoDTO {
    private int dia;
    private LocalTime horaInicio1;
    private LocalTime horaFim1;
    private BigDecimal valorPeriodo1;
    private LocalTime horaInicio2;
    private LocalTime horaFim2;
    private BigDecimal valorPeriodo2;
}
