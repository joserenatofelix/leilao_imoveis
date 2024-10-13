package com.example.leilao.repository;

import com.example.leilao.model.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeilaoRepository extends JpaRepository<Leilao, Long> {
    // Encontrar leilões ativos
    List<Leilao> findByAtivoTrue();

    // Encontrar leilões por produto
    List<Leilao> findByProdutoId(Long produtoId);
}
