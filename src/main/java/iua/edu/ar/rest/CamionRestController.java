package iua.edu.ar.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiKeyAuthDefinition;

import iua.edu.ar.business.ICamionBusiness;
import iua.edu.ar.business.exception.BusinessException;
import iua.edu.ar.business.exception.NotFoundException;
import iua.edu.ar.model.Camion;
import iua.edu.ar.model.Producto;

@RestController
@RequestMapping(value = Constantes.URL_CAMIONES)
//@ApiKeyAuth(name = "Authorization", in = ApiKeyLocation.HEADER)
@Api(value = "Camiones", description = "Operaciones relacionadas con los camiones", tags = { "Camiones" })
public class CamionRestController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ICamionBusiness camionBusiness;

	@ApiOperation(value="Obtener un camion mediante el ID")
	@ApiKeyAuthDefinition(name = "Authorization", key = "Bearer", in = "headers")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Camion> load(@ApiParam(value = "El ID del camion que se desea obtener")@PathVariable("id") Long id) {

		try {
			return new ResponseEntity<Camion>(camionBusiness.load(id), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<Camion>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Camion>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Obtener una lista de camiones")
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Camion>> list() {
		try {
			log.debug("GetMapping: Una lista de camiones ");
			return new ResponseEntity<List<Camion>>(camionBusiness.list(), HttpStatus.OK);

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<List<Camion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
