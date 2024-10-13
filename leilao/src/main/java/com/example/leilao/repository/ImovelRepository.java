package com.example.leilao.repository;

import com.example.leilao.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {

    List<Imovel> findByStatus(String status);
    
    List<Imovel> findByLocalizacao(String localizacao);
}
