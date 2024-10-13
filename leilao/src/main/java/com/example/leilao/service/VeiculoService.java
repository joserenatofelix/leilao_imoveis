package com.example.leilao.service;

import com.example.leilao.exception.ResourceNotFoundException;
import com.example.leilao.model.Veiculo;
import com.example.leilao.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo criarOuAtualizarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Optional<Veiculo> buscarVeiculoPorId(Long id) {
        return veiculoRepository.findById(id);
    }

    public List<Veiculo> listarVeiculos() {
        return veiculoRepository.findAll();
    }

    public void excluirVeiculo(Long id) {
        if (!veiculoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Veículo com ID " + id + " não encontrado.");
        }
        veiculoRepository.deleteById(id);
    }

    public List<Veiculo> buscarVeiculosPorTipo(String tipo) {
        return veiculoRepository.findByTipo(tipo);
    }
}
