package com.example.leilao.repository;

import com.example.leilao.model.Lance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanceRepository extends JpaRepository<Lance, Long> {
    // Encontrar todos os lances de um produto específico
    List<Lance> findByProdutoId(Long produtoId);

    // Encontrar o último lance de um produto
    Lance findTopByProdutoIdOrderByValorDesc(Long produtoId);
}
