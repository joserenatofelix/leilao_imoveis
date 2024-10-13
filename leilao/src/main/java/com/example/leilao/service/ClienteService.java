package com.example.leilao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.leilao.model.Cliente;
import com.example.leilao.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Criar ou atualizar um cliente
    public Cliente criarOuAtualizarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Buscar cliente por ID
    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    // Buscar cliente por e-mail
    public Optional<Cliente> buscarClientePorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    // Listar todos os clientes
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    // Excluir cliente por ID
    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
