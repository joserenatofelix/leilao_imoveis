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

import com.example.leilao.exception.ResourceNotFoundException;
import com.example.leilao.model.Veiculo;
import com.example.leilao.service.VeiculoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<Veiculo> criarOuAtualizarVeiculo(@Valid @RequestBody Veiculo veiculo) {
        Veiculo savedVeiculo = veiculoService.criarOuAtualizarVeiculo(veiculo);
        return ResponseEntity.status(201).body(savedVeiculo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarVeiculoPorId(@PathVariable Long id) {
        Veiculo veiculo = veiculoService.buscarVeiculoPorId(id)
            .orElseThrow(() -> new ResourceNotFoundException("Veículo com ID " + id + " não encontrado."));
        return ResponseEntity.ok(veiculo);
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarVeiculos() {
        List<Veiculo> veiculos = veiculoService.listarVeiculos();
        return ResponseEntity.ok(veiculos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirVeiculo(@PathVariable Long id) {
        veiculoService.excluirVeiculo(id); // Lançará uma exceção se não encontrado
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Veiculo>> buscarVeiculosPorTipo(@PathVariable String tipo) {
        List<Veiculo> veiculos = veiculoService.buscarVeiculosPorTipo(tipo);
        return ResponseEntity.ok(veiculos);
    }
}
