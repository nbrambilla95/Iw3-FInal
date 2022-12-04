package iua.edu.ar.business;

import java.util.List;

import iua.edu.ar.business.exception.BusinessException;
import iua.edu.ar.business.exception.NotFoundException;
import iua.edu.ar.model.Chofer;

public interface IChoferBusiness {

	public List<Chofer> list() throws BusinessException;

	public Chofer load(Long id) throws NotFoundException, BusinessException;

}
