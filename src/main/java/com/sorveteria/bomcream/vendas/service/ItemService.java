package com.sorveteria.bomcream.vendas.service;

import com.sorveteria.bomcream.vendas.controller.dto.ItemDTO;
import com.sorveteria.bomcream.vendas.repository.ItemRepository;
import com.sorveteria.bomcream.vendas.repository.entity.ItemEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository repository;
    private final ModelMapper mapper;

    public void create(ItemDTO dto) {
        repository.save(converterDTOToEntity(dto));
    }

    public void createAll(List<ItemDTO> list) {
        repository.saveAll(list.stream().map(this::converterDTOToEntity).collect(Collectors.toList()));
    }

    public void edit(ItemDTO dto, String id) {
        ItemEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        entity.setNome(dto.getNome());
        entity.setValor(dto.getValor());
        entity.setTipoMedida(dto.getTipoMedida());
        entity.setQuantidadeInicial(dto.getQuantidadeInicial());
        entity.setQuantidadeEmEstoque(dto.getQuantidadeEmEstoque());
        entity.setUpdate(LocalDateTime.now());

        repository.save(entity);
    }

    public List<ItemDTO> findAll() {
        return ((List<ItemEntity>) repository.findAll()).stream()
                .map(this::converterEntityToDTO).collect(Collectors.toList());
    }

    public Page<ItemDTO> findPage(Pageable pageable) {
        return repository.findAll(pageable).map(this::converterEntityToDTO);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public ItemDTO get(String id) {
        return converterEntityToDTO(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado")));
    }

    private ItemDTO converterEntityToDTO(ItemEntity entity) {
        return mapper.map(entity, ItemDTO.class);
    }

    private ItemEntity converterDTOToEntity(ItemDTO dto) {
        return mapper.map(dto, ItemEntity.class);
    }

}
