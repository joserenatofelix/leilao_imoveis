package com.example.leilao.controller;

import com.example.leilao.model.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        // Exemplo de autenticação simples (substitua isso pela lógica real)
        boolean authenticated = "admin".equals(username) && "admin123".equals(password);

        Map<String, Object> response = new HashMap<>();
        if (authenticated) {
            response.put("success", true);
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
