package visitas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import visitas.model.Familia;
import visitas.repositories.FamiliaRepository;

@Service
public class FamiliaServiceImpl implements FamiliaService {

	@Autowired
	FamiliaRepository familiaRepository;
	
	public void setFamiliaRepository(FamiliaRepository familiaRepository){
		this.familiaRepository=familiaRepository;
	}
	
	@Override
	public Iterable<Familia> getAllFamilies() {
		return familiaRepository.findAll();
	}

	@Override
	public Familia saveFamilia(Familia familia) {
		return familiaRepository.save(familia);
	}

	@Override
	public void deleteFamilia(Integer id) {
		familiaRepository.delete(id);
	}

	@Override
	public Familia getFamilia(Integer id) {
		return familiaRepository.findOne(id);
	}

}
