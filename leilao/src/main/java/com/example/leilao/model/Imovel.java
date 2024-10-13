package com.example.leilao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "imovel")
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tipo não pode ser vazio.")
    private String tipo;

    @NotBlank(message = "Endereço não pode ser vazio.")
    private String endereco;

    private String status;

    @NotBlank(message = "Localização não pode ser vazia.")
    private String localizacao;

    @ManyToOne
    @JoinColumn(name = "leilao_id", nullable = false)
    private Leilao leilao;

    // Construtores, Getters, Setters, hashCode e equals
    public Imovel() {}

    public Imovel(String tipo, String endereco, Leilao leilao, String status, String localizacao) {
        this.tipo = tipo;
        this.endereco = endereco;
        this.leilao = leilao;
        this.status = status;
        this.localizacao = localizacao;
    }

    // Getters e Setters...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Imovel)) return false;
        Imovel imovel = (Imovel) o;
        return Objects.equals(id, imovel.id) &&
               Objects.equals(status, imovel.status) &&
               Objects.equals(localizacao, imovel.localizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, localizacao);
    }
}
