package it.brandonmorques.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.brandonmorques.model.Indirizzo;
import it.brandonmorques.repository.IndirizzoRepository;

@Service
public class IndirizzoService {

	@Autowired
	IndirizzoRepository indirizzo;

	public void save(Indirizzo c) {
		indirizzo.save(c);
	}

	public void deleteById(Long id) {
		indirizzo.deleteById(id);
	}

	public void update(Long id, Indirizzo ind) {
		Indirizzo ce = indirizzo.getById(id);
		ce.setCap(ind.getCap());
		ce.setCivico(ind.getCivico());
		ce.setVia(ind.getVia());
		ce.setLocalita(ind.getLocalita());
		indirizzo.save(ce);
	}
}
