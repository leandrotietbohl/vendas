package com.sorveteria.bomcream.vendas.repository;

import com.sorveteria.bomcream.vendas.repository.entity.VendaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VendaRepository extends PagingAndSortingRepository<VendaEntity, String> {
    Page<VendaEntity> findByCreateBetween(LocalDateTime start, LocalDateTime end, Pageable pageable);

    List<VendaEntity> findAllByCreateBetween(LocalDateTime start, LocalDateTime end);

    List<VendaEntity> findAllByCreateAfter(LocalDateTime start);

    List<VendaEntity> findAllByCreateBefore(LocalDateTime end);

    List<VendaEntity> findAllByCaixa(String caixa);

    List<VendaEntity> findAllByCaixaOrderByCreate(String caixa);
}
