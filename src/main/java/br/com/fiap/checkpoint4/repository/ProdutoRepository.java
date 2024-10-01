package br.com.fiap.checkpoint4.repository;

import br.com.fiap.checkpoint4.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
