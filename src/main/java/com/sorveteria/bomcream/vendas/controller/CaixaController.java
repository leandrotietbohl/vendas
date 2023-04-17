package com.sorveteria.bomcream.vendas.controller;

import com.sorveteria.bomcream.vendas.controller.dto.CaixaInDTO;
import com.sorveteria.bomcream.vendas.controller.dto.CategoriaDTO;
import com.sorveteria.bomcream.vendas.service.CaixaService;
import com.sorveteria.bomcream.vendas.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/caixa")
@RequiredArgsConstructor
public class CaixaController {
    private final CaixaService service;

    @PostMapping("/abrir")
    public ResponseEntity abrirCaixa(@RequestBody CaixaInDTO dto) {
        try {
            service.abrir(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/fechar")
    public ResponseEntity fecharCaixa(@RequestBody CaixaInDTO dto) {
        try {
            service.fechar(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get")
    public ResponseEntity findCaixaAberto() {
        return ResponseEntity.ok(service.findCaixaAberto());
    }

    @GetMapping("/all")
    public ResponseEntity listAll() {
        return ResponseEntity.ok(service.findAll());
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
}
