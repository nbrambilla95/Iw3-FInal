package iua.edu.ar.security;

import iua.edu.ar.business.exception.BusinessException;
import iua.edu.ar.business.exception.NotFoundException;

public interface IAuthTokenBusiness {
	public AuthToken save(AuthToken at) throws BusinessException;

	public AuthToken load(String series) throws BusinessException, NotFoundException;

	public void delete(AuthToken at) throws BusinessException;

	public void purgeTokens() throws BusinessException;
	
	public void delete(String token) throws BusinessException ;

}