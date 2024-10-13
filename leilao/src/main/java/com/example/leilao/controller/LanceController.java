package com.example.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.leilao.exception.LanceNotFoundException;
import com.example.leilao.model.Lance;
import com.example.leilao.service.LanceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/lances")
public class LanceController {

    @Autowired
    private LanceService lanceService;

    @PostMapping
    public ResponseEntity<Lance> criarLance(@Valid @RequestBody Lance lance) {
        Lance savedLance = lanceService.criarOuAtualizarLance(lance);
        return ResponseEntity.status(201).body(savedLance);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lance> buscarLancePorId(@PathVariable Long id) {
        Lance lance = lanceService.buscarLancePorId(id)
                .orElseThrow(() -> new LanceNotFoundException("Lance não encontrado com ID " + id));
        return ResponseEntity.ok(lance);
    }

    @GetMapping
    public ResponseEntity<List<Lance>> listarLances() {
        List<Lance> lances = lanceService.listarLances();
        return ResponseEntity.ok(lances);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirLance(@PathVariable Long id) {
        lanceService.excluirLance(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/produto/{produtoId}")
    public ResponseEntity<List<Lance>> buscarLancesPorProduto(@PathVariable Long produtoId) {
        List<Lance> lances = lanceService.buscarLancesPorProduto(produtoId);
        return ResponseEntity.ok(lances);
    }
}
