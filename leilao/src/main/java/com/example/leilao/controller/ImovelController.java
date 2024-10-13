package com.example.leilao.controller;

import com.example.leilao.model.Imovel;
import com.example.leilao.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/imoveis")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    @PostMapping
    public ResponseEntity<Imovel> criarOuAtualizarImovel(@RequestBody Imovel imovel) {
        Imovel savedImovel = imovelService.criarOuAtualizarImovel(imovel);
        return ResponseEntity.ok(savedImovel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imovel> buscarImovelPorId(@PathVariable Long id) {
        Optional<Imovel> imovel = imovelService.buscarImovelPorId(id);
        return imovel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
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
