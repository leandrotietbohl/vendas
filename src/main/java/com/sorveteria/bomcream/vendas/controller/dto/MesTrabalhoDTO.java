package com.sorveteria.bomcream.vendas.controller.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MesTrabalhoDTO {
    private int numero;
    private String mes;
    private List<DiaTrabalhoDTO> dias;
}
