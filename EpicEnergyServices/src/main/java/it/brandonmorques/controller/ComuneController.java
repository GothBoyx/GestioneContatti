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

import it.brandonmorques.model.Comune;
import it.brandonmorques.service.ComuneService;
import it.brandonmorques.service.ProvinciaService;

@RequestMapping("/comune")
@RestController
public class ComuneController {
	@Autowired
	ComuneService service;

	@Autowired
	ProvinciaService proService;

	@PostMapping("/salvacomune")
	public String save(@RequestBody Comune c) {
		service.save(c);
		return "Comune salvato con successo";
	}

	@GetMapping("/eliminacomune/{id}")
	public String eliminaComune(@PathVariable(required = true) Long id) {
		service.deleteById(id);
		return "Comune eliminato con successo";
	}

	@GetMapping("/popola")
	public void popola() {
		File f = new File("src/main/resources/csv/comuni-italiani.csv");
		try {
			String str = FileUtils.readFileToString(f, "UTF-8");
			List<String> lstCartStr = Arrays.asList(str.split("\\r?\\n"));
			for (String com : lstCartStr) {
				String[] c = com.split(";");
				Comune comune = new Comune(c[2], proService.getByNome(c[3]));
				service.save(comune);

			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@PostMapping("/aggiornacomune/{id}")
	public String aggiornaCliente(@PathVariable(required = true) Long id, @RequestBody Comune c) {
		service.update(id, c);
		return "Comune aggiornato";
	}
}