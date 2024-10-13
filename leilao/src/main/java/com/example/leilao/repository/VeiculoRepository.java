package com.example.leilao.repository;

import com.example.leilao.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByTipo(String tipo);

    List<Veiculo> findByMarca(String marca);
}
