package com.example.leilao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.leilao.model.Leilao;
import com.example.leilao.repository.LeilaoRepository;

@Service
public class LeilaoService {

    @Autowired
    private LeilaoRepository leilaoRepository;

    /**
     * Cria ou atualiza um leilão.
     *
     * @param leilao O leilão a ser criado ou atualizado.
     * @return O leilão salvo.
     */
    public Leilao criarOuAtualizarLeilao(Leilao leilao) {
        // Aqui você pode adicionar validações do leilão se necessário
        return leilaoRepository.save(leilao);
    }

    /**
     * Busca um leilão pelo ID.
     *
     * @param id O ID do leilão.
     * @return Um Optional com o leilão se encontrado, ou vazio.
     */
    public Optional<Leilao> buscarLeilaoPorId(Long id) {
        return leilaoRepository.findById(id);
    }

    /**
     * Lista todos os leilões.
     *
     * @return Uma lista de todos os leilões.
     */
    public List<Leilao> listarLeiloes() {
        return leilaoRepository.findAll();
    }

    /**
     * Exclui um leilão pelo ID.
     *
     * @param id O ID do leilão a ser excluído.
     * @throws IllegalArgumentException se o leilão não for encontrado.
     */
    public void excluirLeilao(Long id) {
        if (!leilaoRepository.existsById(id)) {
            throw new IllegalArgumentException("Leilão com ID " + id + " não encontrado.");
        }
        leilaoRepository.deleteById(id);
    }

    /**
     * Busca leilões que estão ativos.
     *
     * @return Uma lista de leilões ativos.
     */
    public List<Leilao> buscarLeiloesAtivos() {
        return leilaoRepository.findByAtivoTrue();
    }
}
