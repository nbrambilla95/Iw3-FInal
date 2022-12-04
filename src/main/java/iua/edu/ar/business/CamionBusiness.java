package iua.edu.ar.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iua.edu.ar.business.exception.BusinessException;
import iua.edu.ar.business.exception.NotFoundException;
import iua.edu.ar.model.Camion;
import iua.edu.ar.model.persistence.CamionRepository;

@Service
public class CamionBusiness implements ICamionBusiness{

	@Autowired
	private CamionRepository camionDAO;
	
	@Override
	public List<Camion> list() throws BusinessException {
		try {
			return camionDAO.findAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}
	
	@Override
	public Camion load(Long id) throws NotFoundException, BusinessException {
		Optional<Camion> op;
		try {
			op = camionDAO.findById(id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		if (!op.isPresent()) {
			throw new NotFoundException("El Camion con el id " + id + " no se encuentra en la BD");
		}
		return op.get();
	}

	
}
