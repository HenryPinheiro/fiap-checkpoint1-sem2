package br.com.fiap.checkpoint4.repository;

import br.com.fiap.checkpoint4.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
