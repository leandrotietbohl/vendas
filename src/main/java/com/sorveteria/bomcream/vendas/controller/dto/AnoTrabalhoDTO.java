package com.sorveteria.bomcream.vendas.controller.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnoTrabalhoDTO {
    private int ano;
    private List<MesTrabalhoDTO> meses;
}
