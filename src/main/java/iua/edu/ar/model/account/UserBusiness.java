package iua.edu.ar.model.account;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iua.edu.ar.business.exception.BusinessException;
import iua.edu.ar.business.exception.FoundException;
import iua.edu.ar.business.exception.NotFoundException;

@Service
public class UserBusiness implements IUserBusiness {
	
	@Autowired
	private UserRepository userDAO;

	@Override
	public User cargar(int id) throws BusinessException, NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> lista() throws BusinessException {
		try {
			return userDAO.findAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public User add(User user) throws BusinessException, FoundException {
		// TODO Auto-generated method stub
		try {
			return userDAO.save(user);
		} catch (Exception e) {
			throw new BusinessException(e);
		}	
	}

	@Override
	public User modificar(User user) throws BusinessException, FoundException, NotFoundException {
		try {
			return userDAO.save(user);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public User cargarPorNombreOEmail(String nombreOEmail) throws BusinessException, NotFoundException {
		Optional<User> o = null;
		try {
			o = userDAO.findFirstByUsernameOrEmail(nombreOEmail, nombreOEmail);
		} catch (Exception e) {
			throw new BusinessException(e);
		}

		if (!o.isPresent())
			throw new NotFoundException(
					String.format("No se encuentra un user con nombre o email = '%s'", nombreOEmail));
		
		return o.get();
	}
}
