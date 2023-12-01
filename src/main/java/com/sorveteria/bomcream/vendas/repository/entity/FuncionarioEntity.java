package com.sorveteria.bomcream.vendas.repository.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "funcionario")
public class FuncionarioEntity {
    @Id
    private String cpf;
    private String nome;
    private BigDecimal valorHora;
    private List<AnoTrabalhoEntity> anos;

}
