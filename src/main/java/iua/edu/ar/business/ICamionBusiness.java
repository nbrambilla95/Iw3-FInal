package iua.edu.ar.business;

import java.util.List;

import iua.edu.ar.business.exception.BusinessException;
import iua.edu.ar.business.exception.NotFoundException;
import iua.edu.ar.model.Camion;

public interface ICamionBusiness {

	public List<Camion> list() throws BusinessException;

	public Camion load(Long id) throws NotFoundException, BusinessException;


}
