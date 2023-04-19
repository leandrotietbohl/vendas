package com.sorveteria.bomcream.vendas.service;

import com.sorveteria.bomcream.vendas.controller.dto.LoginDTO;
import com.sorveteria.bomcream.vendas.repository.UsuarioRepository;
import com.sorveteria.bomcream.vendas.repository.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;
    private final ModelMapper mapper;

    public void create(LoginDTO dto) {
        repository.save(converterDTOToEntity(dto));
    }

    public List<LoginDTO> findAll() {
        return ((List<UsuarioEntity>) repository.findAll(Sort.by(Sort.Direction.ASC, "login"))).stream()
                .map(this::converterEntityToDTO).collect(Collectors.toList());
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public String validaLogin(String login, String pass) {
        UsuarioEntity usu = repository.findById(login)
                .orElseThrow(() -> new RuntimeException("Login não encontrado"));

        if (usu.getPass().equals(pass)) {
            return usu.getTipo();
        } else {
            return null;
        }
    }

    public LoginDTO get(String login) {
        return converterEntityToDTO(repository.findById(login)
                .orElseThrow(() -> new RuntimeException("Login não encontrado")));
    }

    private LoginDTO converterEntityToDTO(UsuarioEntity entity) {
        return mapper.map(entity, LoginDTO.class);
    }

    private UsuarioEntity converterDTOToEntity(LoginDTO dto) {
        return mapper.map(dto, UsuarioEntity.class);
    }

}
