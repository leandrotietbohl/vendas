package com.sorveteria.bomcream.vendas.repository.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "item")
public class ItemEntity {
    @Id
    private String uid;
    private String nome;
    private BigDecimal valor;
    private BigDecimal quantidadeInicial;
    private BigDecimal quantidadeEmEstoque;
    private String tipoMedida;
    private LocalDateTime create = LocalDateTime.now();
    private LocalDateTime update;
}
