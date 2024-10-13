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

    /**
     * Cria ou atualiza um cliente.
     *
     * @param cliente O cliente a ser criado ou atualizado.
     * @return O cliente salvo.
     */
    public Cliente criarOuAtualizarCliente(Cliente cliente) {
        // Aqui você pode adicionar validações do cliente se necessário
        return clienteRepository.save(cliente);
    }

    /**
     * Busca um cliente pelo ID.
     *
     * @param id O ID do cliente.
     * @return Um Optional com o cliente se encontrado, ou vazio.
     */
    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    /**
     * Busca um cliente pelo e-mail.
     *
     * @param email O e-mail do cliente.
     * @return Um Optional com o cliente se encontrado, ou vazio.
     */
    public Optional<Cliente> buscarClientePorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    /**
     * Lista todos os clientes.
     *
     * @return Uma lista de todos os clientes.
     */
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    /**
     * Exclui um cliente pelo ID.
     *
     * @param id O ID do cliente a ser excluído.
     */
    public void excluirCliente(Long id) {
        // Verifica se o cliente existe antes de tentar excluir
        if (!clienteRepository.existsById(id)) {
            throw new IllegalArgumentException("Cliente com ID " + id + " não encontrado.");
        }
        clienteRepository.deleteById(id);
    }
}
