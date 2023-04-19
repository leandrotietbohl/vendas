package com.sorveteria.bomcream.vendas.controller;

import com.sorveteria.bomcream.vendas.controller.dto.LoginDTO;
import com.sorveteria.bomcream.vendas.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/login")
@RequiredArgsConstructor
public class LoginController {
    private final UsuarioService service;

    @GetMapping("/all")
    public ResponseEntity listAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity create(@RequestBody LoginDTO dto) {
        service.create(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/valida")
    public ResponseEntity valida(@RequestBody LoginDTO dto) {
        return ResponseEntity.ok(service.validaLogin(dto.getLogin(), dto.getPass()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable String id) {
        try {
            return ResponseEntity.ok(service.get(id));
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
}
