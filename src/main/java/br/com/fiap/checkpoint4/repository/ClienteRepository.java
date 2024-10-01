package br.com.fiap.checkpoint4.repository;

import br.com.fiap.checkpoint4.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
