package iua.edu.ar.model.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iua.edu.ar.model.Orden;
import iua.edu.ar.model.OrdenDetalle;

@Repository
public interface OrdenDetalleRepository extends JpaRepository<OrdenDetalle, Long> {

	List<OrdenDetalle> findAllOrdenDetalleByOrdenId(Long id);

	OrdenDetalle findFirstByOrdenIdOrderByFecha(Long id);
	
	List<OrdenDetalle> findByOrdenId(Long id);

}
