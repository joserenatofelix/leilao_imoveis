package com.example.leilao.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lance")
public class Lance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    @ManyToOne
    @JoinColumn(name = "leilao_id", nullable = false)
    private Leilao leilao;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    // Construtores
    public Lance() {}

    public Lance(Double valor, Leilao leilao, Cliente cliente) {
        this.valor = valor;
        this.leilao = leilao;
        this.cliente = cliente;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Leilao getLeilao() {
        return leilao;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // hashCode e equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lance)) return false;
        Lance lance = (Lance) o;
        return Objects.equals(id, lance.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
