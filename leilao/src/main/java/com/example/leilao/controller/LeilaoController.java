package com.example.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leilao.exception.ResourceNotFoundException; // Certifique-se de que esta exceção exista
import com.example.leilao.model.Leilao;
import com.example.leilao.service.LeilaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/leiloes")
public class LeilaoController {

    @Autowired
    private LeilaoService leilaoService;

    @PostMapping
    public ResponseEntity<Leilao> criarOuAtualizarLeilao(@Valid @RequestBody Leilao leilao) {
        Leilao savedLeilao = leilaoService.criarOuAtualizarLeilao(leilao);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLeilao); // Retorna 201 Created
    }

    @GetMapping("/{id}")
    public ResponseEntity<Leilao> buscarLeilaoPorId(@PathVariable Long id) {
        Leilao leilao = leilaoService.buscarLeilaoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leilão não encontrado com ID: " + id));
        return ResponseEntity.ok(leilao);
    }

    @GetMapping
    public ResponseEntity<List<Leilao>> listarLeiloes() {
        List<Leilao> leiloes = leilaoService.listarLeiloes();
        return ResponseEntity.ok(leiloes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirLeilao(@PathVariable Long id) {
        leilaoService.excluirLeilao(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<Leilao>> buscarLeiloesAtivos() {
        List<Leilao> leiloes = leilaoService.buscarLeiloesAtivos();
        return ResponseEntity.ok(leiloes);
    }
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    
}
