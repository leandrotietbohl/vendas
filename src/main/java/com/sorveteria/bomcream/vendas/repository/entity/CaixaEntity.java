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
import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "caixa")
public class CaixaEntity {
    @Id
    private String uid;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private String userInicio;
    private String userFim;
    private BigDecimal valorInicioDinheiro;
    private BigDecimal valorFimDinheiro;

}
