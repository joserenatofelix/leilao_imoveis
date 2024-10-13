package com.example.leilao.repository;

import com.example.leilao.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {
    // Encontrar todos os imóveis por status
    List<Imovel> findByStatus(String status);

    // Encontrar imóvel por localização
    List<Imovel> findByLocalizacao(String localizacao);
}
