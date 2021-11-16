package it.brandonmorques.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.brandonmorques.model.Provincia;
import it.brandonmorques.repository.ProvinciaRepository;

@Service
public class ProvinciaService {

	@Autowired
	ProvinciaRepository provincia;

	public void save(Provincia c) {
		provincia.save(c);
	}

	public void deleteById(Long id) {
		provincia.deleteById(id);
	}

	public Provincia getByNome(String string) {
		return provincia.findByNome(string);
	}

	public void update(Long id, Provincia pro) {
		Provincia ce = provincia.getById(id);
		ce.setNome(pro.getNome());
		ce.setSigla(pro.getSigla());
		provincia.save(ce);
	}
}
