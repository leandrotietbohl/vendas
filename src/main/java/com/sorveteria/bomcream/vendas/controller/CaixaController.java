package com.sorveteria.bomcream.vendas.controller;

import com.sorveteria.bomcream.vendas.controller.dto.CaixaInDTO;
import com.sorveteria.bomcream.vendas.controller.dto.LancamentoDTO;
import com.sorveteria.bomcream.vendas.service.CaixaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/caixa")
@RequiredArgsConstructor
public class CaixaController {
    private final CaixaService service;

    @PostMapping("/abrir")
    public ResponseEntity abrirCaixa(@RequestBody CaixaInDTO dto) {
        try {
            return ResponseEntity.ok(service.abrir(dto));
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
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

    @GetMapping("/vendas/{id}")
    public ResponseEntity findVendasByCaixa(@PathVariable String id) {
        return ResponseEntity.ok(service.findVendasByCaixa(id));
    }

    @GetMapping("/lancamentos/{id}")
    public ResponseEntity findLancamentoByCaixa(@PathVariable String id) {
        return ResponseEntity.ok(service.findLancamentoByCaixa(id));
    }

    @PostMapping("/lancamentos/")
    public ResponseEntity addLancamento(@RequestBody LancamentoDTO dto) {
        service.addLancamento(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/last")
    public ResponseEntity findUltimoCaixa() {
        return ResponseEntity.ok(service.findUltimoCaixa());
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
