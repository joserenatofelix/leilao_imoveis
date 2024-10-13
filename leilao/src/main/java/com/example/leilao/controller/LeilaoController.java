package com.example.leilao.controller;

import com.example.leilao.model.Leilao;
import com.example.leilao.service.LeilaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/leiloes")
public class LeilaoController {

    @Autowired
    private LeilaoService leilaoService;

    // Criar ou atualizar leilão
    @PostMapping
    public ResponseEntity<Leilao> criarOuAtualizarLeilao(@RequestBody Leilao leilao) {
        Leilao savedLeilao = leilaoService.criarOuAtualizarLeilao(leilao);
        return ResponseEntity.ok(savedLeilao);
    }

    // Buscar leilão por ID
    @GetMapping("/{id}")
    public ResponseEntity<Leilao> buscarLeilaoPorId(@PathVariable Long id) {
        Optional<Leilao> leilao = leilaoService.buscarLeilaoPorId(id);
        return leilao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Listar todos os leilões
    @GetMapping
    public ResponseEntity<List<Leilao>> listarLeiloes() {
        List<Leilao> leiloes = leilaoService.listarLeiloes();
        return ResponseEntity.ok(leiloes);
    }

    // Excluir leilão por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirLeilao(@PathVariable Long id) {
        leilaoService.excluirLeilao(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar leilões ativos
    @GetMapping("/ativos")
    public ResponseEntity<List<Leilao>> buscarLeiloesAtivos() {
        List<Leilao> leiloes = leilaoService.buscarLeiloesAtivos();
        return ResponseEntity.ok(leiloes);
    }
}
