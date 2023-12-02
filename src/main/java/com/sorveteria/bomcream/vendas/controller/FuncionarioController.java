package com.sorveteria.bomcream.vendas.controller;

import com.sorveteria.bomcream.vendas.controller.dto.CategoriaDTO;
import com.sorveteria.bomcream.vendas.controller.dto.FuncionarioDTO;
import com.sorveteria.bomcream.vendas.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/funcionario")
@RequiredArgsConstructor
public class FuncionarioController {
    private final FuncionarioService service;

    @GetMapping("/{id}")
    public ResponseEntity findFuncionarioByID(@PathVariable String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody FuncionarioDTO dto) {
        try {
            return ResponseEntity.ok(service.create(dto));
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable String id, @RequestBody FuncionarioDTO dto) {
        try {
            service.edit(dto, id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/all")
    public ResponseEntity deleteAll() {
        service.deleteAll();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity listAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
