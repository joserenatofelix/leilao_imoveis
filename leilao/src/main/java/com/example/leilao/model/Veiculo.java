package com.example.leilao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O tipo do veículo não pode ser nulo.")
    @Size(min = 1, message = "O tipo do veículo deve ter pelo menos 1 caractere.")
    private String tipo;

    @NotNull(message = "A marca do veículo não pode ser nula.")
    @Size(min = 1, message = "A marca do veículo deve ter pelo menos 1 caractere.")
    private String marca;

    @NotNull(message = "O modelo do veículo não pode ser nulo.")
    @Size(min = 1, message = "O modelo do veículo deve ter pelo menos 1 caractere.")
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "leilao_id", nullable = false)
    private Leilao leilao;

    public Veiculo() {}

    public Veiculo(String tipo, String marca, String modelo, Leilao leilao) {
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.leilao = leilao;
    }

    // Getters e Setters
    // ...

    // hashCode, equals e toString
    // ...
}
