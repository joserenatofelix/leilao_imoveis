package com.example.leilao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/login.html")
    public String loginPage() {
        return "login";  // Refere-se ao arquivo login.html na pasta de templates
    }

    @GetMapping("/cadastro.html")
    public String cadastroPage() {
        return "cadastro";  // Refere-se ao arquivo cadastro.html
    }

    // Adicione mapeamentos para as outras páginas
}
