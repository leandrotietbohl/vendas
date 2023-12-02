package com.sorveteria.bomcream.vendas.service;

import com.sorveteria.bomcream.vendas.controller.dto.FuncionarioDTO;
import com.sorveteria.bomcream.vendas.repository.FuncionarioRepository;
import com.sorveteria.bomcream.vendas.repository.entity.AnoTrabalhoEntity;
import com.sorveteria.bomcream.vendas.repository.entity.DiaTrabalhoEntity;
import com.sorveteria.bomcream.vendas.repository.entity.FuncionarioEntity;
import com.sorveteria.bomcream.vendas.repository.entity.MesTrabalhoEntity;
import com.sorveteria.bomcream.vendas.util.Meses;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class FuncionarioService {
    private final FuncionarioRepository repository;
    private final ModelMapper mapper;

    public FuncionarioDTO create(FuncionarioDTO dto) {
        if (repository.existsById(dto.getCpf())) {
            throw new RuntimeException("CPF já cadastrado como funcionario.");
        } else {
            FuncionarioEntity entity = FuncionarioEntity.builder()
                    .cpf(dto.getCpf())
                    .nome(dto.getNome())
                    .valorHora(dto.getValorHora())
                    .anos(criaAno())
                    .build();
            return mapper.map(repository.save(entity), FuncionarioDTO.class);
        }
    }

    private List<AnoTrabalhoEntity> criaAno() {
        AnoTrabalhoEntity anoAtual = AnoTrabalhoEntity.builder()
                .ano(LocalDate.now().getYear())
                .meses(criaMeses())
                .build();
        return List.of(anoAtual);
    }

    private List<MesTrabalhoEntity> criaMeses() {
        List<MesTrabalhoEntity> meses = new ArrayList<>();
        Arrays.stream(Meses.values()).forEach(m -> meses.add(MesTrabalhoEntity.builder()
                .numero(m.getCodigoMes())
                .mes(m.getNomeMesCompleto())
                .dias(criaDiasMes(m.getCodigoMes()))
                .valorMes(BigDecimal.ZERO)
                .build()));
        return meses;
    }

    private List<DiaTrabalhoEntity> criaDiasMes(int codigoMes) {
        List<DiaTrabalhoEntity> dias;
        int ultimoDiaMes = LocalDate.of(LocalDate.now().getYear(), codigoMes, 1).lengthOfMonth();
        dias = IntStream.range(0, ultimoDiaMes).mapToObj(d -> DiaTrabalhoEntity.builder()
                .dia(d + 1)
                .valorTrabalho(BigDecimal.ZERO)
                .valorTotalDia(BigDecimal.ZERO)
                .build()).collect(Collectors.toList());
        return dias;
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public FuncionarioDTO getById(String cpf) {
        return mapper.map(repository.findById(cpf).orElse(null), FuncionarioDTO.class);
    }

    public List<FuncionarioDTO> findAll() {
        return ((List<FuncionarioEntity>) repository.findAll()).stream()
                .map(f -> mapper.map(f, FuncionarioDTO.class))
                .collect(Collectors.toList());
    }

    public void edit(FuncionarioDTO dto, String id) {
        repository.save(mapper.map(dto, FuncionarioEntity.class));
    }
}
