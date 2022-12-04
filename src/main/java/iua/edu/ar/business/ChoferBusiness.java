package iua.edu.ar.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iua.edu.ar.business.exception.BusinessException;
import iua.edu.ar.business.exception.NotFoundException;
import iua.edu.ar.model.Chofer;
import iua.edu.ar.model.persistence.ChoferRepository;

@Service
public class ChoferBusiness implements IChoferBusiness {
	
	@Autowired
	private ChoferRepository choferDAO;
	
	@Override
	public List<Chofer> list() throws BusinessException {
		try {
			return choferDAO.findAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}
	
	@Override
	public Chofer load(Long id) throws NotFoundException, BusinessException {
		Optional<Chofer> op;
		try {
			op = choferDAO.findById(id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		if (!op.isPresent()) {
			throw new NotFoundException("El Camion con el id " + id + " no se encuentra en la BD");
		}
		return op.get();
	}
}
