package com.sorveteria.bomcream.vendas.repository;

import com.sorveteria.bomcream.vendas.repository.entity.UsuarioEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<UsuarioEntity, String> {
}
