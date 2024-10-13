package com.example.leilao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.leilao.exception.LanceNotFoundException;
import com.example.leilao.model.Lance;
import com.example.leilao.repository.LanceRepository;

@Service
public class LanceService {

    @Autowired
    private LanceRepository lanceRepository;

    public Lance criarOuAtualizarLance(Lance lance) {
        return lanceRepository.save(lance);
    }

    public Optional<Lance> buscarLancePorId(Long id) {
        return lanceRepository.findById(id);
    }

    public List<Lance> listarLances() {
        return lanceRepository.findAll();
    }

    public void excluirLance(Long id) {
        if (!lanceRepository.existsById(id)) {
            throw new LanceNotFoundException("Lance com ID " + id + " não encontrado.");
        }
        lanceRepository.deleteById(id);
    }

    public List<Lance> buscarLancesPorProduto(Long produtoId) {
        return lanceRepository.findByLeilaoId(produtoId); // Certifique-se de que isso reflete o que você deseja buscar
    }
}
