package iua.edu.ar.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import iua.edu.ar.business.IOrdenBusiness;
import iua.edu.ar.business.IOrdenDetalleBusiness;
import iua.edu.ar.business.exception.BusinessException;
import iua.edu.ar.business.exception.NotFoundException;
import iua.edu.ar.business.exception.PasswordException;
import iua.edu.ar.model.DatoCarga;
import iua.edu.ar.model.Orden;
import iua.edu.ar.model.OrdenDetalle;

@RestController
@RequestMapping(value = Constantes.URL_ORDENES_DETALLES)
@Api(value = "Orden-Detalle", description = "Operaciones sobre el detalle de las ordenes", tags = { "Orden-Detalle" })
public class OrdenDetalleRestController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IOrdenDetalleBusiness ordenDetalleBusiness;
	
	@ApiOperation(value="Obtener el detalle de una orden mediante el ID")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrdenDetalle> load(@PathVariable("id") Long id) {

		try {
			return new ResponseEntity<OrdenDetalle>(ordenDetalleBusiness.load(id), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<OrdenDetalle>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<OrdenDetalle>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Obtener una lista de todos los detalles de orden que existen")
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdenDetalle>> list() {
		try {
			log.debug("GetMapping: Una lista de orden detalle ");
			return new ResponseEntity<List<OrdenDetalle>>(ordenDetalleBusiness.list(), HttpStatus.OK);

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<List<OrdenDetalle>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@ApiOperation(value="Guardar un nuevo detalle de orden")
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> add(@RequestBody OrdenDetalle ordenDetalle) {
		try {
			ordenDetalleBusiness.add(ordenDetalle);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("location", Constantes.URL_ORDENES + '/' + ordenDetalle.getId());
			return new ResponseEntity<String>(responseHeaders, HttpStatus.CREATED);
		} catch (BusinessException e) {

			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value="Actualizar el detalle de una orden")
	@PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> update(@RequestBody OrdenDetalle ordenDetalle) {
		try {
			ordenDetalleBusiness.update(ordenDetalle);
		} catch (NotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			// e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			// e.printStackTrace();
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@ApiOperation(value="Borrar el detalle de una orden")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		try {
			ordenDetalleBusiness.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
}
