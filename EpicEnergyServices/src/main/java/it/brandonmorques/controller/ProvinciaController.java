package it.brandonmorques.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.brandonmorques.model.Provincia;
import it.brandonmorques.service.ProvinciaService;

@RequestMapping("/provinciacontroller")
@RestController
public class ProvinciaController {

	@Autowired
	ProvinciaService service;

	@PostMapping("/salvaprovincia")
	public String save(@RequestBody Provincia c) {
		service.save(c);
		return "Provincia salvata con successo";
	}

	@GetMapping("/eliminaprovincia/{id}")
	public String eliminaComune(@PathVariable(required = true) Long id) {
		service.deleteById(id);
		return "Provincia eliminata con successo";
	}

	@PostMapping("/aggiornaprovincia/{id}")
	public String aggiornaIndirizzo(@PathVariable(required = true) Long id, @RequestBody Provincia c) {
		service.update(id, c);
		return "Provincia aggiornata";
	}

	@GetMapping("/popola")
	public void popola() {
		File f = new File("src/main/resources/csv/province-italiane.csv");
		try {
			String str = FileUtils.readFileToString(f, "UTF-8");
			List<String> lstCartStr = Arrays.asList(str.split("\n"));
			for (String prov : lstCartStr) {
				String[] p = prov.split(";");
				Provincia pr = new Provincia(p[1], p[0]);
				service.save(pr);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
