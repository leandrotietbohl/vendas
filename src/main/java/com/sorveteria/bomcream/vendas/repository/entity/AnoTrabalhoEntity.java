package com.sorveteria.bomcream.vendas.repository.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnoTrabalhoEntity {
    private int ano;
    private List<MesTrabalhoEntity> meses;
}
