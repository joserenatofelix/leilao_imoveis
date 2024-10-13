package com.example.leilao.repository;

import com.example.leilao.model.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface de repositório para a entidade Leilao.
 * Extende JpaRepository para fornecer operações CRUD.
 */
@Repository
public interface LeilaoRepository extends JpaRepository<Leilao, Long> {

    /**
     * Encontra todos os leilões ativos.
     *
     * @return Uma lista de leilões que estão ativos.
     */
    List<Leilao> findByAtivoTrue();

    /**
     * Encontra leilões por ID de produto associado.
     *
     * @param produtoId O ID do produto para o qual os leilões são buscados.
     * @return Uma lista de leilões associados ao produto especificado.
     */
    List<Leilao> findByProdutoId(Long produtoId);

    // Você pode considerar adicionar mais métodos de consulta conforme necessário.
}
