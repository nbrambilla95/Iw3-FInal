package iua.edu.ar.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import iua.edu.ar.business.exception.BusinessException;
import iua.edu.ar.business.exception.FoundException;
import iua.edu.ar.business.exception.NotFoundException;
import iua.edu.ar.model.account.IUserBusiness;
import iua.edu.ar.model.account.User;

@RestController
@RequestMapping(value = Constantes.URL_LOGIN)
@Api(value = "Login", description = "Operaciones relacionadas con el login", tags = { "Login" })
public class LoginRestController extends BaseRestController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUserBusiness userBusiness;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping(value = "")
	public ResponseEntity<String> loginToken(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		try {
			User u = userBusiness.cargarPorNombreOEmail(username);
			String msg = u.checkAccount(passwordEncoder, password);
			if (msg != null) {
				u.agregaIntentoFallido();
				try {
					userBusiness.modificar(u);
				} catch (FoundException e) {
					log.error(e.getMessage());
					return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
				return new ResponseEntity<String>(msg, HttpStatus.UNAUTHORIZED);
			} else {
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(u, null,
						u.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(auth);
				return new ResponseEntity<String>(userToJson(getUserLogged()).get("authtoken").toString(),
						HttpStatus.OK);
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotFoundException e) {
			return new ResponseEntity<String>("BAD_ACCOUNT_NAME", HttpStatus.UNAUTHORIZED);
		}

	}

	@PostMapping(value = "/login-json")
	public ResponseEntity<String> loginTokenFullJson(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		try {
			User u = userBusiness.cargarPorNombreOEmail(username);
			String msg = u.checkAccount(passwordEncoder, password);
			if (msg != null) {
				u.agregaIntentoFallido();
				try {
					userBusiness.modificar(u);
				} catch (FoundException e) {
					log.error(e.getMessage());
					return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
				return new ResponseEntity<String>(msg, HttpStatus.UNAUTHORIZED);
			} else {
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(u, null,
						u.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(auth);
				return new ResponseEntity<String>(userToJson(getUserLogged()).toString(), HttpStatus.OK);
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotFoundException e) {
			return new ResponseEntity<String>("BAD_ACCOUNT_NAME", HttpStatus.UNAUTHORIZED);
		}

	}

	@GetMapping(value = "/auth-info")
	public ResponseEntity<String> authInfo() {
		return new ResponseEntity<String>(userToJson(getUserLogged()).toString(), HttpStatus.OK);
	}

}
