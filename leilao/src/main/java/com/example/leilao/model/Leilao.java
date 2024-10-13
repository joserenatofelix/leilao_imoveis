package com.example.leilao.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "leilao")
public class Leilao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "leilao", cascade = CascadeType.ALL)
    private List<Imovel> imoveis;

    @OneToMany(mappedBy = "leilao", cascade = CascadeType.ALL)
    private List<Veiculo> veiculos;

    @OneToMany(mappedBy = "leilao", cascade = CascadeType.ALL)
    private List<Lance> lances;

    // Construtores, Getters, Setters, hashCode e equals

    public Leilao() {}

    public Leilao(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Imovel> getImoveis() {
        return imoveis;
    }

    public void setImoveis(List<Imovel> imoveis) {
        this.imoveis = imoveis;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public List<Lance> getLances() {
        return lances;
    }

    public void setLances(List<Lance> lances) {
        this.lances = lances;
    }

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
}
