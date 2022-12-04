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
import iua.edu.ar.business.IChoferBusiness;
import iua.edu.ar.business.exception.BusinessException;
import iua.edu.ar.business.exception.NotFoundException;
import iua.edu.ar.model.Chofer;

@RestController
@RequestMapping(value = Constantes.URL_CHOFERES)
@Api(value = "Choferes", description = "Operaciones relacionadas con los choferes", tags = { "Choferes" })
public class ChoferRestController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IChoferBusiness choferBusiness;

	@ApiOperation(value="Obtener un chofer mediante el ID")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Chofer> load(@ApiParam(value = "El ID del chofer que se desea obtener")@PathVariable("id") Long id) {

		try {
			return new ResponseEntity<Chofer>(choferBusiness.load(id), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<Chofer>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<Chofer>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value="Obtener una lista de camiones")
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Chofer>> list() {
		try {
			log.debug("GetMapping: Una lista de camiones ");
			return new ResponseEntity<List<Chofer>>(choferBusiness.list(), HttpStatus.OK);

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<List<Chofer>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
}
