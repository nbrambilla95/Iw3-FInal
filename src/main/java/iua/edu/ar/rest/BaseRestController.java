package iua.edu.ar.rest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;

import iua.edu.ar.business.exception.BusinessException;
import iua.edu.ar.model.account.User;
import iua.edu.ar.security.AuthToken;
import iua.edu.ar.security.IAuthTokenBusiness;

public class BaseRestController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IAuthTokenBusiness authTokenBusiness;

	protected User getUserLogged() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		return user;
	}

	protected JSONObject userToJson(User u) {
		// AuthToken token = new AuthToken(sessionTimeout, u.getUsername());
		// AuthToken token = new AuthToken(u.getSessionTimeout(), u.getUsername());
		AuthToken token = new AuthToken(u.getDuracionToken() == 0 ? 300 : u.getDuracionToken(), u.getUsername());
		String tokenValue = null;
		try {
			authTokenBusiness.save(token);
			tokenValue = token.encodeCookieValue();
		} catch (BusinessException e) {
			log.error(e.getMessage(), e);

		}
		JSONObject o = new JSONObject();

		o.put("username", u.getUsername());
		o.put("fullname", u.getNombreCompleto());
		o.put("idUser", u.getId());
		o.put("email", u.getEmail());

		JSONArray r = new JSONArray();
		for (GrantedAuthority g : u.getAuthorities()) {
			r.put(g.getAuthority());
		}
		o.put("roles", r);
		o.put("authtoken", tokenValue);
		return o;
	}

}