package iua.edu.ar.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import iua.edu.ar.business.ICamionBusiness;
import iua.edu.ar.business.exception.BusinessException;
import iua.edu.ar.business.exception.FoundException;
import iua.edu.ar.model.Producto;
import iua.edu.ar.model.account.IUserBusiness;
import iua.edu.ar.model.account.User;

@RestController
@RequestMapping(value = Constantes.URL_REGISTRAR)
@Api(value = "Usuarios", description = "Operaciones relacionadas con los usuarios", tags = { "Usuarios" })
public class UserRestController {


	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserBusiness userBusiness;
	
	/*
	 * @ApiOperation(value="Registrar usuario")
	 * 
	 * @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE) public
	 * ResponseEntity<String> add(@RequestBody User user) { try {
	 * userBusiness.add(user); HttpHeaders responseHeaders = new HttpHeaders();
	 * responseHeaders.set("location", Constantes.URL_REGISTRAR + '/' +
	 * user.getId()); return new ResponseEntity<String>(responseHeaders,
	 * HttpStatus.CREATED); } catch (BusinessException e) {
	 * 
	 * return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */
	
}
