package com.example.leilao.service;

import com.example.leilao.model.Imovel;
import com.example.leilao.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    // Criar ou atualizar um imóvel
    public Imovel criarOuAtualizarImovel(Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    // Buscar imóvel por ID
    public Optional<Imovel> buscarImovelPorId(Long id) {
        return imovelRepository.findById(id);
    }

    // Listar todos os imóveis
    public List<Imovel> listarImoveis() {
        return imovelRepository.findAll();
    }

    // Excluir imóvel por ID
    public void excluirImovel(Long id) {
        imovelRepository.deleteById(id);
    }
    
    // Buscar imóveis por status
    public List<Imovel> buscarImoveisPorStatus(String status) {
        return imovelRepository.findByStatus(status);
    }
}
