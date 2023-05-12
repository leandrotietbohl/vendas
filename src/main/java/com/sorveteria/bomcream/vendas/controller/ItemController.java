package com.sorveteria.bomcream.vendas.controller;

import com.sorveteria.bomcream.vendas.controller.dto.ItemDTO;
import com.sorveteria.bomcream.vendas.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService service;

    @GetMapping("/all")
    public ResponseEntity listAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/page")
    public ResponseEntity page(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(service.findPage(PageRequest.of(page, size)));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ItemDTO dto) {
        service.create(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/all")
    public ResponseEntity createAll(@RequestBody List<ItemDTO> list) {
        service.createAll(list);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable String id) {
        try {
            return ResponseEntity.ok(service.get(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable String id, @RequestBody ItemDTO dto) {
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
}
