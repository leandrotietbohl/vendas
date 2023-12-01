package com.sorveteria.bomcream.vendas.repository;

import com.sorveteria.bomcream.vendas.repository.entity.FuncionarioEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<FuncionarioEntity, String> {
}
