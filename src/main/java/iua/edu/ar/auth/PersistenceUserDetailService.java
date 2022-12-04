package iua.edu.ar.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import iua.edu.ar.business.exception.BusinessException;
import iua.edu.ar.business.exception.NotFoundException;
import iua.edu.ar.model.account.IUserBusiness;
import iua.edu.ar.model.account.User;

@Service
public class PersistenceUserDetailService implements UserDetailsService {
	
	@Autowired
	private IUserBusiness userBusiness;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=null;
		
		try {
			user=userBusiness.cargarPorNombreOEmail(username);
		} catch (BusinessException e) {
		
			e.printStackTrace();
		} catch (NotFoundException e) {
			throw new UsernameNotFoundException(e.getMessage());
		}
		
		return user;
	}
}
