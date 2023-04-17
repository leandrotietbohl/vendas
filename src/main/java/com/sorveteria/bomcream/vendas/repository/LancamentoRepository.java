package com.sorveteria.bomcream.vendas.repository;

import com.sorveteria.bomcream.vendas.repository.entity.LancamenntoCaixaEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LancamentoRepository extends PagingAndSortingRepository<LancamenntoCaixaEntity, String> {
    List<LancamenntoCaixaEntity> findAllByCaixaOrderByCreate(String caixa);
}
