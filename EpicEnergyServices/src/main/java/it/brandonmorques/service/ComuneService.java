package it.brandonmorques.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.brandonmorques.model.Comune;
import it.brandonmorques.repository.ComuneRepository;

@Service
public class ComuneService {

	@Autowired
	ComuneRepository comune;
	
	public Comune getByNome(String nome) {
	return comune.getFirstByNome(nome);
	}

	public void save(Comune c) {
		comune.save(c);
	}

	public void deleteById(Long id) {
		comune.deleteById(id);

	}

	public void update(Long id, Comune com) {
		Comune comune1 = comune.getById(id);
		comune1.setNome(com.getNome());
		comune.save(comune1);

	}
}