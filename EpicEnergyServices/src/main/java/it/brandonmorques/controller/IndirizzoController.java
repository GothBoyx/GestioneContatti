package it.brandonmorques.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.brandonmorques.model.Indirizzo;
import it.brandonmorques.service.IndirizzoService;

@RequestMapping("/indirizzocontroller")
@RestController
public class IndirizzoController {

	@Autowired
	IndirizzoService service;

	@PostMapping("/salvaindirizzo")
	public String save(@RequestBody Indirizzo c) {
		service.save(c);
		return "Indirizzo salvato con successo";

	}

	@GetMapping("/eliminaindirizzo/{id}")
	public String eliminaIndirizzo(@PathVariable(required = true) Long id) {
		service.deleteById(id);
		return "Indirizzo eliminato con successo";
	}

	@PostMapping("/aggiornaindirizzo/{id}")
	public String aggiornaIndirizzo(@PathVariable(required = true) Long id, @RequestBody Indirizzo c) {
		service.update(id, c);
		return "Indirizzo aggiornato";
	}
}