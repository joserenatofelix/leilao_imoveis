package com.example.leilao.service;

import com.example.leilao.model.Lance;
import com.example.leilao.repository.LanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public boolean excluirLance(Long id) {
        Optional<Lance> lance = lanceRepository.findById(id);
        if (lance.isPresent()) {
            lanceRepository.delete(lance.get());
            return true; // Retorna true se a exclusão foi bem-sucedida
        }
        return false; // Retorna false se o lance não foi encontrado
    }

    public List<Lance> buscarLancesPorProduto(Long produtoId) {
        return lanceRepository.findByProdutoId(produtoId); // Assumindo que este método existe no repositório
    }
}
