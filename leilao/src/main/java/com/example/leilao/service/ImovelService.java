package com.example.leilao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.leilao.exception.ImovelNotFoundException;
import com.example.leilao.model.Imovel;
import com.example.leilao.repository.ImovelRepository;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    public Imovel criarOuAtualizarImovel(Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    public Optional<Imovel> buscarImovelPorId(Long id) {
        return imovelRepository.findById(id);
    }

    public List<Imovel> listarImoveis() {
        return imovelRepository.findAll();
    }

    public void excluirImovel(Long id) {
        if (!imovelRepository.existsById(id)) {
            throw new ImovelNotFoundException("Imóvel com ID " + id + " não encontrado.");
        }
        imovelRepository.deleteById(id);
    }

    public List<Imovel> buscarImoveisPorStatus(String status) {
        return imovelRepository.findByStatus(status);
    }
}
