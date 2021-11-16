package it.brandonmorques.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.brandonmorques.model.Fattura;
import it.brandonmorques.service.FatturaService;

@RequestMapping("/fatturacontroller")
@RestController
public class FatturaController {

	@Autowired
	FatturaService service;

	@PostMapping("/salvafattura")
	public String save(@RequestBody Fattura c) {
		service.save(c);
		return "Fattura salvata con successo";
	}

	@GetMapping("/eliminafattura/{id}")
	public String eliminaFattura(@PathVariable(required = true) Long id) {
		service.deleteById(id);
		return "Fattura eliminata con successo";

	}

	@PostMapping("/aggiornafattura/{id}")
	public String aggiornaCliente(@PathVariable(required = true) Long id, @RequestBody Fattura c) {
		service.update(id, c);
		return "Fattura aggiornata";
	}

	@GetMapping(value = "/ricercapercliente", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Fattura>> findByCliente(@RequestParam String cliente,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "4") Integer size) {
		Pageable pag = PageRequest.of(page, size);
		List<Fattura> list = service.findByCliente(cliente, pag);
		return new ResponseEntity<List<Fattura>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(value = "/ricercaperstato", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Fattura>> findByStato(@RequestParam String stato,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "4") Integer size) {
		Pageable pag = PageRequest.of(page, size);
		List<Fattura> list = service.findByStato(stato, pag);
		return new ResponseEntity<List<Fattura>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(value = "/ricercaperanno", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Fattura>> findByAnno(@RequestParam Integer anno,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "4") Integer size) {
		Pageable pag = PageRequest.of(page, size);
		List<Fattura> list = service.findByAnno(anno, pag);
		return new ResponseEntity<List<Fattura>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(value = "/ricercaperdata", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Fattura>> findByData(
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "4") Integer size) {
		Pageable pag = PageRequest.of(page, size);
		List<Fattura> list = service.findByData(data, pag);
		return new ResponseEntity<List<Fattura>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(value = "/ricercaperrange", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Fattura>> findByRange(@RequestParam Double minimo, @RequestParam Double massimo,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "4") Integer size) {
		Pageable pag = PageRequest.of(page, size);
		List<Fattura> list = service.findByRangeImporto(minimo, massimo, pag);
		return new ResponseEntity<List<Fattura>>(list, new HttpHeaders(), HttpStatus.OK);

	}

}