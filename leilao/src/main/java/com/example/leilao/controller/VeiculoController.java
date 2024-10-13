package com.example.leilao.controller;

import com.example.leilao.model.Veiculo;
import com.example.leilao.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<Veiculo> criarOuAtualizarVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo savedVeiculo = veiculoService.criarOuAtualizarVeiculo(veiculo);
        return ResponseEntity.ok(savedVeiculo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarVeiculoPorId(@PathVariable Long id) {
        Optional<Veiculo> veiculo = veiculoService.buscarVeiculoPorId(id);
        return veiculo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarVeiculos() {
        List<Veiculo> veiculos = veiculoService.listarVeiculos();
        return ResponseEntity.ok(veiculos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirVeiculo(@PathVariable Long id) {
        veiculoService.excluirVeiculo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Veiculo>> buscarVeiculosPorTipo(@PathVariable String tipo) {
        List<Veiculo> veiculos = veiculoService.buscarVeiculosPorTipo(tipo);
        return ResponseEntity.ok(veiculos);
    }
}
