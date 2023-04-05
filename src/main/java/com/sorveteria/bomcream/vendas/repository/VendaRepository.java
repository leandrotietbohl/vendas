package com.sorveteria.bomcream.vendas.repository;

import com.sorveteria.bomcream.vendas.repository.entity.VendaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface VendaRepository extends PagingAndSortingRepository<VendaEntity, String> {
    public Page<VendaEntity> findByCreateBetween(LocalDateTime start, LocalDateTime end, Pageable pageable);
}
