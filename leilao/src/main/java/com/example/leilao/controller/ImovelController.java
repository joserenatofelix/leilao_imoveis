package com.example.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.leilao.exception.ImovelNotFoundException;
import com.example.leilao.model.Imovel;
import com.example.leilao.service.ImovelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/imoveis")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    @PostMapping
    public ResponseEntity<Imovel> criarOuAtualizarImovel(@Valid @RequestBody Imovel imovel) {
        Imovel savedImovel = imovelService.criarOuAtualizarImovel(imovel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedImovel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imovel> buscarImovelPorId(@PathVariable Long id) {
        Imovel imovel = imovelService.buscarImovelPorId(id)
                .orElseThrow(() -> new ImovelNotFoundException("Imóvel não encontrado."));
        return ResponseEntity.ok(imovel);
    }

    @GetMapping
    public ResponseEntity<List<Imovel>> listarImoveis() {
        List<Imovel> imoveis = imovelService.listarImoveis();
        return ResponseEntity.ok(imoveis);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirImovel(@PathVariable Long id) {
        imovelService.excluirImovel(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Imovel>> buscarImoveisPorStatus(@PathVariable String status) {
        List<Imovel> imoveis = imovelService.buscarImoveisPorStatus(status);
        return ResponseEntity.ok(imoveis);
    }
}
