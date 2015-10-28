package visitas.services;

import visitas.model.Familia;

public interface FamiliaService {
	Iterable <Familia> getAllFamilies();
	Familia saveFamilia(Familia f);
	void deleteFamilia(Integer id);
	Familia getFamilia(Integer id);
}
