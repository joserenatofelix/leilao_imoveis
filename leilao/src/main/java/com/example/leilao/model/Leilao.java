package com.example.leilao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "leilao")
public class Leilao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome do leilão não pode ser nulo.")
    @Size(min = 1, message = "O nome do leilão deve ter pelo menos 1 caractere.")
    private String nome;

    @OneToMany(mappedBy = "leilao", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Imovel> imoveis = new HashSet<>();

    @OneToMany(mappedBy = "leilao", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Veiculo> veiculos = new HashSet<>();

    @OneToMany(mappedBy = "leilao", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Lance> lances = new HashSet<>();

    // Construtores, Getters e Setters...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Leilao)) return false;
        Leilao leilao = (Leilao) o;
        return Objects.equals(id, leilao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Leilao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", imoveis=" + imoveis.size() +
                ", veiculos=" + veiculos.size() +
                ", lances=" + lances.size() +
                '}';
    }
}
