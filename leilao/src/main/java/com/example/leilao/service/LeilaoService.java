package com.example.leilao.service;

import com.example.leilao.model.Leilao;
import com.example.leilao.repository.LeilaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeilaoService {

    @Autowired
    private LeilaoRepository leilaoRepository;

    // Criar ou atualizar um leilão
    public Leilao criarOuAtualizarLeilao(Leilao leilao) {
        return leilaoRepository.save(leilao);
    }

    // Buscar leilão por ID
    public Optional<Leilao> buscarLeilaoPorId(Long id) {
        return leilaoRepository.findById(id);
    }

    // Listar todos os leilões
    public List<Leilao> listarLeiloes() {
        return leilaoRepository.findAll();
    }

    // Excluir leilão por ID
    public void excluirLeilao(Long id) {
        leilaoRepository.deleteById(id);
    }

    // Buscar leilões ativos
    public List<Leilao> buscarLeiloesAtivos() {
        return leilaoRepository.findByAtivoTrue();
    }
}
