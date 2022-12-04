package iua.edu.ar.model.account;

import java.util.List;

import iua.edu.ar.business.exception.BusinessException;
import iua.edu.ar.business.exception.FoundException;
import iua.edu.ar.business.exception.NotFoundException;

public interface IUserBusiness {
	
	public User cargar(int id) throws BusinessException, NotFoundException;
	public List<User> lista() throws BusinessException;
	public User add(User user) throws BusinessException, FoundException;
	public User modificar(User user) throws BusinessException, FoundException, NotFoundException;
	public User cargarPorNombreOEmail(String nombreOEmail) throws BusinessException, NotFoundException;
}
