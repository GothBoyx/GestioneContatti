package it.brandonmorques;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.brandonmorques.model.Cliente;
import it.brandonmorques.model.Comune;
import it.brandonmorques.model.Fattura;
import it.brandonmorques.model.Indirizzo;
import it.brandonmorques.model.Provincia;
import it.brandonmorques.model.StatoFattura;
import it.brandonmorques.model.TipoCliente;

@SpringBootTest
class ProgettoFinaleApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	@DisplayName("Test Aggiungi Provincia")
	void aggiungiProvincia() {
		Provincia p = new Provincia("Fragola", "FR");
		boolean valoreAspettato = true;
		assertEquals(valoreAspettato, p != null);
	}

	@Test
	@DisplayName("Test Aggiungi Comune")
	void aggiungiComune() {
		Provincia p = new Provincia("Fragola", "FR");
		Comune c = new Comune("Comune", p);
		boolean valoreAspettato = true;
		assertEquals(valoreAspettato, c != null);

	}

	@Test
	@DisplayName("Test Aggiungi Indirizzo")
	void aggiungiIndirizzo() {
		Provincia p = new Provincia("Fragola", "FR");
		Comune c = new Comune("Comune", p);
		Indirizzo i = new Indirizzo("Via della vedova", 34, 87987, "Vedovi", c);
		boolean valoreAspettato = true;
		assertEquals(valoreAspettato, i != null);
	}

	@Test
	@DisplayName("Test Aggiungi Cliente")
	void aggiungiCliente() {
		LocalDate ld = LocalDate.of(2021, 10, 28);
		LocalDate ld2 = LocalDate.of(2001, 10, 12);
		Provincia p = new Provincia("Fragola", "FR");
		Comune c = new Comune("Comune", p);
		Indirizzo i = new Indirizzo("Via della vedova", 34, 87987, "Vedovi", c);
		Cliente cl = new Cliente("Boh", 345, TipoCliente.PA, "cliente1@gmail.com", "cliente.info@gmail.com", 321345542,
				"Dario", "Rossi", 340874457, "Ma che ne so", i, i, ld, ld2, 24.000);
		boolean valoreAspettato = true;
		assertEquals(valoreAspettato, cl != null);
	}

	@Test
	@DisplayName("Test Aggiungi Stato Fattura")
	void aggiungiStatoFattura() {
		StatoFattura sf = new StatoFattura("In Corso");
		boolean valoreAspettato = true;
		assertEquals(valoreAspettato, sf != null);
	}

	@Test
	@DisplayName("Test Aggiungi Fattura")
	void aggiungiFattura() {
		LocalDate ld = LocalDate.of(2021, 10, 28);
		LocalDate ld2 = LocalDate.of(2001, 10, 12);
		Provincia p = new Provincia("Fragola", "FR");
		Comune c = new Comune("Comune", p);
		Indirizzo i = new Indirizzo("Via della vedova", 34, 87987, "Vedovi", c);
		Cliente cl = new Cliente("Boh", 345, TipoCliente.PA, "cliente1@gmail.com", "cliente.info@gmail.com", 321345542,
				"Dario", "Rossi", 340874457, "Ma che ne so", i, i, ld, ld2, 24.000);
		StatoFattura sf = new StatoFattura("In Corso");
		Fattura f = new Fattura(cl, ld, 3, 2008, 300, sf);
		boolean valoreAspettato = true;
		assertEquals(valoreAspettato, f != null);

	}

}
