package iua.edu.ar.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import iua.edu.ar.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
