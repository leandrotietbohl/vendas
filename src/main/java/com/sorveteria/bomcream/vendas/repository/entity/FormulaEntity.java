package com.sorveteria.bomcream.vendas.repository.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "formula")
public class FormulaEntity {
    @Id
    private String uid;
    private List<ComposicaoEntity> ingredientes;
    private LocalDateTime create = LocalDateTime.now();
}
