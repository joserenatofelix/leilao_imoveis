package com.example.leilao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.leilao.exception.ImovelNotFoundException;
import com.example.leilao.model.Cliente;
import com.example.leilao.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> criarOuAtualizarCliente(@RequestBody Cliente cliente) {
        try {
            Optional<Cliente> existingCliente = clienteService.buscarClientePorEmail(cliente.getEmail());
            if (existingCliente.isPresent()) {
                throw new IllegalArgumentException("Cliente com e-mail " + cliente.getEmail() + " já cadastrado.");
            }

            Cliente savedCliente = clienteService.criarOuAtualizarCliente(cliente);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Usuário cadastrado com sucesso!");
            response.put("clienteId", String.valueOf(savedCliente.getId()));
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Erro ao cadastrar o usuário: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.buscarClientePorId(id);
        if (cliente.isEmpty()) {
            throw new ImovelNotFoundException("Cliente com ID " + id + " não encontrado.");
        }
        return ResponseEntity.ok(cliente.get());
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        try {
            clienteService.excluirCliente(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
