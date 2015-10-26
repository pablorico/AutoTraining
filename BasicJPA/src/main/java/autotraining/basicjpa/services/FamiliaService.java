package autotraining.basicjpa.services;

import autotraining.basicjpa.model.Familia;

public interface FamiliaService {
	Iterable <Familia> getAllFamilies();
	Familia saveFamilia(Familia f);
	void deleteFamilia(Integer id);
	Familia getFamilia(Integer id);
}
