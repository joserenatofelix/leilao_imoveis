package com.example.leilao.repository;

import com.example.leilao.model.Lance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanceRepository extends JpaRepository<Lance, Long> {

    List<Lance> findByLeilaoId(Long leilaoId); // Busca lances por ID do leilão
}
