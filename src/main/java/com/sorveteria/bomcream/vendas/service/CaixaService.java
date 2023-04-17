package com.sorveteria.bomcream.vendas.service;

import com.sorveteria.bomcream.vendas.controller.dto.CaixaInDTO;
import com.sorveteria.bomcream.vendas.controller.dto.CaixaOutDTO;
import com.sorveteria.bomcream.vendas.controller.dto.LancamentoDTO;
import com.sorveteria.bomcream.vendas.controller.dto.VendaDTO;
import com.sorveteria.bomcream.vendas.repository.CaixaRepository;
import com.sorveteria.bomcream.vendas.repository.LancamentoRepository;
import com.sorveteria.bomcream.vendas.repository.VendaRepository;
import com.sorveteria.bomcream.vendas.repository.entity.CaixaEntity;
import com.sorveteria.bomcream.vendas.repository.entity.LancamenntoCaixaEntity;
import com.sorveteria.bomcream.vendas.repository.entity.VendaEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CaixaService {
    private final CaixaRepository repository;
    private final VendaRepository vendaRepository;
    private final LancamentoRepository lancamentoRepository;
    private final ModelMapper mapper;


    public CaixaOutDTO abrir(CaixaInDTO dto) {
        if (dto.getInicio() == null || dto.getUser() == null) {
            throw new RuntimeException("Data inicio e Usuario não podem ser nulos");
        }
        if (repository.existsByFimIsNull()) {
            throw new RuntimeException("Já existe um caixa aberto, feche o anterio para abrir o novo");
        }
        CaixaEntity caixaAnterior = repository.findFirstByFimIsNotNull(Sort.by(Sort.Direction.DESC, "fim"));
        CaixaEntity novoCaixa = CaixaEntity.builder()
                .userInicio(dto.getUser())
                .inicio(dto.getInicio())
                .build();
        if (caixaAnterior != null) {
            novoCaixa.setValorInicioDinheiro(caixaAnterior.getValorFimDinheiro());
        } else {
            novoCaixa.setValorInicioDinheiro(BigDecimal.ZERO);
        }
        return converterEntityToDTO(repository.save(novoCaixa));
    }

    public void fechar(CaixaInDTO dto) {
        if (dto.getUid() == null || dto.getFim() == null || dto.getUser() == null) {
            throw new RuntimeException("Id, Data fim e Usuario não podem ser nulos");
        }
        CaixaEntity caixa = repository.findById(dto.getUid())
                .orElseThrow(() -> new RuntimeException("Caixa não encontrado"));

        caixa.setFim(dto.getFim());
        caixa.setUserFim(dto.getUser());
        List<VendaEntity> vendas = vendaRepository.findAllByCaixa(caixa.getUid());

        BigDecimal sumDinheiro = caixa.getValorInicioDinheiro();
        if (vendas != null) {
            BigDecimal valorPago = BigDecimal.valueOf(vendas.stream().filter(v -> v.getFormaPagamento().equals("Dinheiro"))
                    .mapToDouble(v -> v.getValorPago().doubleValue()).sum());
            BigDecimal valorTroco = BigDecimal.valueOf(vendas.stream().filter(v -> v.getFormaPagamento().equals("Dinheiro"))
                    .mapToDouble(v -> v.getValorTroco().doubleValue()).sum());
            sumDinheiro = sumDinheiro.add(valorPago).subtract(valorTroco);
        }
        caixa.setValorFimDinheiro(sumDinheiro);

        repository.save(caixa);
    }

    public void addLancamento(LancamentoDTO dto) {
        lancamentoRepository.save(converterDTOToEntity(dto));
    }

    public List<LancamentoDTO> findLancamentoByCaixa(String uidCaixa) {
        return lancamentoRepository.findAllByCaixaOrderByCreate(uidCaixa).stream()
                .map(this::converterEntityToDTO).collect(Collectors.toList());
    }

    public List<VendaDTO> findVendasByCaixa(String uidCaixa) {
        return vendaRepository.findAllByCaixaOrderByCreate(uidCaixa).stream()
                .map(this::converterEntityToDTO).collect(Collectors.toList());
    }

    public CaixaOutDTO findCaixaAberto() {
        return converterEntityToDTO(repository.findFirstByFimIsNull());
    }

    public CaixaOutDTO findUltimoCaixa() {
        return converterEntityToDTO(repository.findFirstByFimIsNotNull(Sort.by(Sort.Direction.DESC, "fim")));
    }

    public List<CaixaOutDTO> findAll() {
        return ((List<CaixaEntity>) repository.findAll()).stream()
                .map(this::converterEntityToDTO).collect(Collectors.toList());
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    private CaixaOutDTO converterEntityToDTO(CaixaEntity entity) {
        if (entity != null) {
            return mapper.map(entity, CaixaOutDTO.class);
        } else {
            return null;
        }
    }

    private VendaDTO converterEntityToDTO(VendaEntity entity) {
        return mapper.map(entity, VendaDTO.class);
    }

    private LancamentoDTO converterEntityToDTO(LancamenntoCaixaEntity entity) {
        return mapper.map(entity, LancamentoDTO.class);
    }

    private LancamenntoCaixaEntity converterDTOToEntity(LancamentoDTO entity) {
        return mapper.map(entity, LancamenntoCaixaEntity.class);
    }
}
