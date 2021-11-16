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

import it.brandonmorques.model.Cliente;
import it.brandonmorques.service.ClienteService;

@RequestMapping("/cliente")
@RestController
public class ClienteController {

	@Autowired
	ClienteService service;

	@PostMapping("/salvacliente")
	public String save(@RequestBody Cliente c) {
		service.save(c);
		return "Cliente salvato con successo";
	}

	@GetMapping("/eliminacliente/{id}")
	public String eliminaCliente(@PathVariable(required = true) Long id) {
		service.delete(id);
		return "Cliente eliminato con successo";
	}

	@PostMapping("/aggiornacliente/{id}")
	public String aggiornaCliente(@PathVariable(required = true) Long id, @RequestBody Cliente c) {
		service.update(id, c);
		return "Cliente aggiornato";
	}

	@GetMapping(value = "/getorder", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> myGetAllUserPageSizeSort(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "2") Integer size, @RequestParam(defaultValue = "nomeContatto") String sort) {
		List<Cliente> list = service.myFindAllClientePageSizeSort(page, size, sort);
		return new ResponseEntity<List<Cliente>>(list, new HttpHeaders(), HttpStatus.OK);

	}

	@GetMapping(value = "/ricercapernome", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> findByNome(@RequestParam String nome,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size) {
		Pageable pag = PageRequest.of(page, size);
		List<Cliente> list = service.findByParteDelNome(nome, pag);
		return new ResponseEntity<List<Cliente>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(value = "/ricercaperfatturato", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> findByFatturato(@RequestParam Double fatturato,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size) {
		Pageable pag = PageRequest.of(page, size);
		List<Cliente> list = service.findByListaFatturatoAnnuale(fatturato, pag);
		return new ResponseEntity<List<Cliente>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(value = "/ricercaperdatains", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findByDataInserimento(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size) {
		Pageable pag = PageRequest.of(page, size);
		List<Cliente> list = service.findByListaDataInserimento(data, pag);
		return new ResponseEntity<List<Cliente>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(value = "/ricercaperdatault", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> findByDataUltimoContatto(
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size) {
		Pageable pag = PageRequest.of(page, size);
		List<Cliente> list = service.findByListaDataUltimoContatto(data, pag);
		return new ResponseEntity<List<Cliente>>(list, new HttpHeaders(), HttpStatus.OK);
	}
}