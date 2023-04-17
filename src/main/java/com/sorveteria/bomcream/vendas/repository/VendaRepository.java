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
    public Page<VendaEntity> findByCreateBetween(LocalDateTime start, LocalDateTime end, Pageable pageable);

    public List<VendaEntity> findAllByCreateBetween(LocalDateTime start, LocalDateTime end);

    public List<VendaEntity> findAllByCreateAfter(LocalDateTime start);

    public List<VendaEntity> findAllByCreateBefore(LocalDateTime end);

    public List<VendaEntity> findAllByCaixa(String caixa);

    public List<VendaEntity> findAllByCaixaOrderByCreate(String caixa);
}
