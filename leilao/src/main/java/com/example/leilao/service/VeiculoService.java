package com.example.leilao.service;

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

    // Criar ou atualizar um veículo
    public Veiculo criarOuAtualizarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    // Buscar veículo por ID
    public Optional<Veiculo> buscarVeiculoPorId(Long id) {
        return veiculoRepository.findById(id);
    }

    // Listar todos os veículos
    public List<Veiculo> listarVeiculos() {
        return veiculoRepository.findAll();
    }

    // Excluir veículo por ID
    public void excluirVeiculo(Long id) {
        veiculoRepository.deleteById(id);
    }
    
    // Buscar veículos por tipo
    public List<Veiculo> buscarVeiculosPorTipo(String tipo) {
        return veiculoRepository.findByTipo(tipo);
    }
}
