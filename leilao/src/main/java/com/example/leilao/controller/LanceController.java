package com.example.leilao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leilao.model.Lance;
import com.example.leilao.service.LanceService;

@RestController
@RequestMapping("/lances")
public class LanceController {

    @Autowired
    private LanceService lanceService;

    @PostMapping
    public ResponseEntity<Lance> criarLance(@RequestBody Lance lance) {
        Lance savedLance = lanceService.criarOuAtualizarLance(lance);
        return ResponseEntity.status(201).body(savedLance); // Retorna 201 Created
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lance> buscarLancePorId(@PathVariable Long id) {
        Optional<Lance> lance = lanceService.buscarLancePorId(id);
        return lance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Lance>> listarLances() {
        List<Lance> lances = lanceService.listarLances();
        return ResponseEntity.ok(lances);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirLance(@PathVariable Long id) {
        if (lanceService.excluirLance(id)) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        return ResponseEntity.notFound().build(); // 404 Not Found
    }

    @GetMapping("/produto/{produtoId}")
    public ResponseEntity<List<Lance>> buscarLancesPorProduto(@PathVariable Long produtoId) {
        List<Lance> lances = lanceService.buscarLancesPorProduto(produtoId);
        return ResponseEntity.ok(lances);
    }
}
