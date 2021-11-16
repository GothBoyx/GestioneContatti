package it.brandonmorques.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.brandonmorques.model.StatoFattura;
import it.brandonmorques.service.StatoFatturaService;

@RequestMapping("/statofatturacontroller")
@RestController
public class StatoFatturaController {
	@Autowired
	StatoFatturaService service;

	@PostMapping("/salvafattura")
	public String save(@RequestBody StatoFattura c) {
		service.save(c);
		return "Fattura salvata con successo";
	}

	@GetMapping("/eliminafattura/{id}")
	public String eliminaFattura(@PathVariable(required = true) Long id) {
		service.deleteById(id);
		return "Fattura eliminata con successo";
	}

	@PostMapping("/aggiornastato/{id}")
	public String aggiornaStatoFattura(@PathVariable(required = true) Long id, @RequestBody StatoFattura c) {
		service.update(id, c);
		return "Stato fattura aggiornato";
	}
}