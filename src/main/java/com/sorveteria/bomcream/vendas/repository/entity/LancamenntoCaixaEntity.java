package com.sorveteria.bomcream.vendas.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "lancamento")
public class LancamenntoCaixaEntity {
    @Id
    private String uid;
    private String caixa;
    private String descricao;
    private String tipo;
    private String user;
    private BigDecimal valor;
    private LocalDateTime create = LocalDateTime.now();
}
