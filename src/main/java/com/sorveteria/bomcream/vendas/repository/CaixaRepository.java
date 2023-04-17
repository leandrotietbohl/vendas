package com.sorveteria.bomcream.vendas.repository;

import com.sorveteria.bomcream.vendas.repository.entity.CaixaEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CaixaRepository extends PagingAndSortingRepository<CaixaEntity, String> {
    public boolean existsByFimIsNull();
    public CaixaEntity findFirstByFimIsNotNull(Sort sort);
    public CaixaEntity findFirstByFimIsNull();
}
