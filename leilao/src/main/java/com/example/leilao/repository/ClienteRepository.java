package com.example.leilao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.leilao.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Encontrar um cliente pelo e-mail
    Optional<Cliente> findByEmail(String email);

    // Encontrar todos os clientes
    List<Cliente> findAll();
}
