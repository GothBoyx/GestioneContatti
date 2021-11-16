package it.brandonmorques;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.brandonmorques.controller.AuthController;
import it.brandonmorques.controller.ComuneController;
import it.brandonmorques.controller.ProvinciaController;
import it.brandonmorques.model.Cliente;
import it.brandonmorques.model.ERole;
import it.brandonmorques.model.Fattura;
import it.brandonmorques.model.Indirizzo;
import it.brandonmorques.model.Role;
import it.brandonmorques.model.StatoFattura;
import it.brandonmorques.model.TipoCliente;
import it.brandonmorques.repository.ProvinciaRepository;
import it.brandonmorques.repository.RoleRepository;
import it.brandonmorques.request.SignupRequest;
import it.brandonmorques.service.ClienteService;
import it.brandonmorques.service.ComuneService;
import it.brandonmorques.service.FatturaService;
import it.brandonmorques.service.IndirizzoService;
import it.brandonmorques.service.StatoFatturaService;
import it.brandonmorques.service.UserService;

@Component
public class MyCRUD implements CommandLineRunner {

	@Autowired
	ClienteService cliente;
	@Autowired
	ComuneService comune;
	@Autowired
	FatturaService fattura;
	@Autowired
	IndirizzoService indirizzo;
	@Autowired
	ProvinciaRepository provincia;
	@Autowired
	StatoFatturaService statoFattura;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserService us;
	@Autowired
	ComuneController cc;
	@Autowired
	ProvinciaController pc;
	@Autowired
	AuthController ac;

	@Override
	public void run(String... args) throws Exception {

//		pc.popola();
//		cc.popola();
//		
//		Role r = new Role(ERole.ROLE_ADMIN);
//		Role r1 = new Role(ERole.ROLE_USER);
//		roleRepository.save(r);
//		roleRepository.save(r1);
//		Set<String> roles = new HashSet<String>();
//		roles.add("ROLE_ADMIN");
//		ac.registerUser(new SignupRequest("admin", "admin@gmail.com", roles, "admin", "admin", "admin"));
//		
//		
//		Indirizzo i1 = new Indirizzo("Via Milano", 29, 98134, "Periferia", comune.getByNome("Cusano"));
//		Indirizzo i2 = new Indirizzo("Via Catania", 28, 98345, "Periferia", comune.getByNome("Pigra"));
//		Indirizzo i3 = new Indirizzo("Via Primavera", 19, 95682, "Periferia", comune.getByNome("Lipomo"));
//		Indirizzo i4 = new Indirizzo("Via Autunno", 17, 87233, "Centro", comune.getByNome("Livo"));
//		Indirizzo i5 = new Indirizzo("Via Inverno", 110, 20050, "Periferia", comune.getByNome("Correzzana"));
//		Indirizzo i6 = new Indirizzo("Via Duomo", 135, 57020, "Centro", comune.getByNome("Pelago"));
//		Indirizzo i7 = new Indirizzo("Via Antonio da Legnago", 37, 89010, "Marittima", comune.getByNome("Cannara"));
//		Indirizzo i8 = new Indirizzo("Via Nazario Sauro", 156, 20012, "Centro", comune.getByNome("Cornaredo"));
//		Indirizzo i9 = new Indirizzo("Via Croce Rossa", 176, 19070, "Centro", comune.getByNome("Narbolia"));
//		Indirizzo i10 = new Indirizzo("Via Giovanni Amendola", 84, 26010, "Periferia",comune.getByNome("Ripalta Guerina"));
//		Indirizzo i11 = new Indirizzo("Via Santa Maria di Costantinopoli", 135, 46040, "Marittima",comune.getByNome("Rodigo"));
//		Indirizzo i12 = new Indirizzo("Via Francesco Del Giudice", 161, 35586, "Montagna",comune.getByNome("Pancarana"));
//		Indirizzo i13 = new Indirizzo("Via Giallo", 78, 35797, "Periferia",comune.getByNome("Ghilarza"));
//		Indirizzo i14 = new Indirizzo("Via Arancione", 32, 29664, "Lungomare",comune.getByNome("Narbolia"));
//		Indirizzo i15 = new Indirizzo("Via Rosso", 765, 35608, "Centro",comune.getByNome("Norbello"));
//		Indirizzo i16 = new Indirizzo("Via Blu", 98, 22047, "Periferia",comune.getByNome("Segariu"));
//		Indirizzo i17 = new Indirizzo("Via Rosa", 23, 22996, "Campagna",comune.getByNome("Bortigali"));
//		Indirizzo i18 = new Indirizzo("Via Azzurro", 74, 74234, "Centro",comune.getByNome("Gela"));
//		Indirizzo i19 = new Indirizzo("Via Verde", 92, 73086, "Montagna",comune.getByNome("Lipari"));
//		Indirizzo i20 = new Indirizzo("Via Lilla", 29, 16679, "Periferia",comune.getByNome("Monreale"));
//		indirizzo.save(i1);
//		indirizzo.save(i2);
//		indirizzo.save(i3);
//		indirizzo.save(i4);
//		indirizzo.save(i5);
//		indirizzo.save(i6);
//		indirizzo.save(i7);
//		indirizzo.save(i8);
//		indirizzo.save(i9);
//		indirizzo.save(i10);
//		indirizzo.save(i11);
//		indirizzo.save(i12);
//		indirizzo.save(i13);
//		indirizzo.save(i14);
//		indirizzo.save(i15);
//		indirizzo.save(i16);
//		indirizzo.save(i17);
//		indirizzo.save(i18);
//		indirizzo.save(i19);
//		indirizzo.save(i20);
//		
//		
//		Cliente c1 = new Cliente("Daewoo", 2762583, TipoCliente.SPA, "daewoo@gmail.com", "daewoo@pec.com", 16369, "Emma", "Pisano", 37125785, "emma@gmail.com", i1, i1,	LocalDate.of(2008, 11, 02),LocalDate.of(2021, 11, 27), 33.000);
//		Cliente c2 = new Cliente("Genoveffa", 4267293, TipoCliente.PA, "genoveffa@gmail.com", "genoveffa@pec.com", 94678, "Genoveffa", "Nord", 3734690, "genoveffa@gmail.com", i2, i2,	LocalDate.of(2011, 12, 17),LocalDate.of(2023, 2, 1), 450.000);
//		Cliente c3 = new Cliente("Dario", 2762583, TipoCliente.SRL, "dario@gmail.com", "dario@pec.com", 35965, "Dario", "Di Marco", 337125785, "dario@gmail.com", i3, i3,	LocalDate.of(2000, 11, 27),LocalDate.of(2020, 6, 7), 21.000);
//		Cliente c4 = new Cliente("Marco", 848724, TipoCliente.SAS, "marco@gmail.com", "marco@pec.com", 16369, "Marco", "Rossi", 32685543, "marco@gmail.com", i4, i4,	LocalDate.of(2009, 2, 12),LocalDate.of(2018, 4, 21), 500.000);
//		Cliente c5 = new Cliente("Noemi", 215789, TipoCliente.SPA, "noemi@gmail.com", "noemi@pec.com", 74732, "Noemi", "Ambra", 38455379, "noemi@gmail.com", i5, i5,	LocalDate.of(2007, 11, 27),LocalDate.of(2015, 11, 27), 300.0);
//		Cliente c6 = new Cliente("Francesco", 1578904, TipoCliente.PA, "francesco@gmail.com", "francesco@pec.com", 43226, "Francesco", "Oll", 39583829, "francesco@gmail.com", i6, i6,	LocalDate.of(2004, 3, 25),LocalDate.of(2014, 4, 21), 150.000);
//		Cliente c7 = new Cliente("Peppe", 824689, TipoCliente.SRL, "peppe@gmail.com", "peppe@pec.com", 84335, "Peppe", "Bianco", 6327884, "peppe@gmail.com", i7, i7,	LocalDate.of(2002, 6, 17),LocalDate.of(2006, 1, 3), 67.000);
//		Cliente c8 = new Cliente("Carmen", 173577, TipoCliente.SAS, "carmen@gmail.com", "carmen@pec.com", 24789, "Carmen", "Di Pietro", 39864357, "carmen@gmail.com", i8, i8,	LocalDate.of(2009, 7, 7),LocalDate.of(2016, 11, 27),10.000);
//		Cliente c9 = new Cliente("Natasha", 4367843, TipoCliente.PA, "natasha@gmail.com", "natasha@pec.com", 16369, "Natasha", "Viola", 37125785, "natasha@gmail.com", i9, i9,	LocalDate.of(2004, 4, 17),LocalDate.of(2007, 8, 22), 40.000);
//		Cliente c10 = new Cliente("Katiusha", 657853, TipoCliente.PA, "katiusha@gmail.com", "katiusha@pec.com", 96534, "Katiusha", "Blu", 312356906, "katiusha@gmail.com", i10, i10,	LocalDate.of(2001, 1, 3),LocalDate.of(2009, 12, 23), 70.000);
//		Cliente c11 = new Cliente("Filippa", 9534679, TipoCliente.SPA, "filippa@gmail.com", "filippa@pec.com", 433225, "Filippa", "Mollica", 3456754, "filippa@gmail.com", i11, i11,	LocalDate.of(2021, 11, 27),LocalDate.of(2021, 11, 27), 450.000);
//		Cliente c12 = new Cliente("Maria", 246796, TipoCliente.SAS, "maria@gmail.com", "maria@pec.com", 125664, "Maria", "Arancia", 312468975, "maria@gmail.com", i12, i12,	LocalDate.of(2001, 9, 11),LocalDate.of(2018, 4, 28), 133.000);
//		Cliente c13 = new Cliente("Wanda", 963678, TipoCliente.SRL, "wanda@gmail.com", "wanda@pec.com", 16369, "Wanda", "Maximoff", 396543675, "wanda@gmail.com", i13, i13,	LocalDate.of(2011, 5, 14),LocalDate.of(2012, 1, 21), 28.000);
//		Cliente c14 = new Cliente("Shantal", 683689, TipoCliente.SRL, "shantal@gmail.com", "shantal@pec.com", 16369, "Shantal", "Pera", 37125785, "shantal@gmail.com", i14, i14,	LocalDate.of(2002, 4,19),LocalDate.of(2001, 5, 24), 11.000);
//		Cliente c15 = new Cliente("Ilenia", 2358945, TipoCliente.PA, "ilenia@gmail.com", "ilenia@pec.com", 16369, "Ilenia", "Mela", 371743555, "ilenia@gmail.com", i15, i15,	LocalDate.of(2004, 12, 11),LocalDate.of(2021, 2, 13), 18.000);
//		Cliente c16 = new Cliente("Gabriella", 246997, TipoCliente.SPA, "gabriella@gmail.com", "gabriella@pec.com", 16369, "Gabriella", "Banana", 371356665, "gabriella@gmail.com", i16, i16,	LocalDate.of(2005, 7, 22),LocalDate.of(2020, 10, 5), 49.000);
//		Cliente c17 = new Cliente("Osvalda", 876433, TipoCliente.SPA, "osvalda@gmail.com", "osvalda@pec.com", 16369, "Osvalda", "Ananas", 37567785, "osvalda@gmail.com", i17, i17,	LocalDate.of(2002, 8, 11),LocalDate.of(2019, 12, 22), 12.000);
//		Cliente c18 = new Cliente("Edna", 6378996, TipoCliente.SRL, "edna@gmail.com", "edna@pec.com", 16369, "Edna", "Mode", 37125785, "edna@gmail.com", i18, i18,	LocalDate.of(2006, 3, 6),LocalDate.of(2019, 2, 17), 98.000);
//		Cliente c19 = new Cliente("Vittorio", 2762583, TipoCliente.SPA, "vittorio@gmail.com", "vittorio@pec.com", 16369, "Vittorio", "Canapa", 37125785, "vittorio@gmail.com", i19, i19,LocalDate.of(2003, 9, 8),LocalDate.of(2011, 9, 12), 27.700);
//		Cliente c20 = new Cliente("Sebastiano", 2598764, TipoCliente.PA, "sebastiano@gmail.com", "sebastiano@pec.com", 16369, "Sebastiano", "Troisi", 371224585, "sebastiano@gmail.com", i20, i20,	LocalDate.of(2017, 3, 4),LocalDate.of(2018, 1, 26), 56.000);
//		cliente.save(c1);
//		cliente.save(c2);
//		cliente.save(c3);
//		cliente.save(c4);
//		cliente.save(c5);
//		cliente.save(c6);
//		cliente.save(c7);
//		cliente.save(c8);
//		cliente.save(c9);
//		cliente.save(c10);
//		cliente.save(c11);
//		cliente.save(c12);
//		cliente.save(c13);
//		cliente.save(c14);
//		cliente.save(c15);
//		cliente.save(c16);
//		cliente.save(c17);
//		cliente.save(c18);
//		cliente.save(c19);
//		cliente.save(c20);
//		
//		
//	
//		StatoFattura s1 = new StatoFattura("Non Pagata");
//		StatoFattura s2 = new StatoFattura("Pagata");
//		StatoFattura s3 = new StatoFattura("Pagata in ritardo");
//		StatoFattura s4 = new StatoFattura("Non Gestita");
//		statoFattura.save(s1);
//		statoFattura.save(s2);
//		statoFattura.save(s3);
//		statoFattura.save(s4);
//
//		Fattura f1 = new Fattura(c1, LocalDate.of(2020, 2, 12), 146, 2020, 830.50, s1 );
//		Fattura f2 = new Fattura(c2, LocalDate.of(2019, 3, 21), 28, 2020, 100.50, s2 );
//		Fattura f3= new Fattura(c3, LocalDate.of(2007, 6, 11), 13, 2020, 23.50, s2 );
//		Fattura f4 = new Fattura(c4, LocalDate.of(2011, 2, 13), 125, 2020, 900.50, s1 );
//		Fattura f5 = new Fattura(c5, LocalDate.of(2000, 1,19), 196, 2020, 3356.50, s4 );
//		Fattura f6 = new Fattura(c6, LocalDate.of(2012, 2, 23), 137, 2020, 8632.50, s3 );
//		Fattura f7 = new Fattura(c7, LocalDate.of(2015, 9, 17), 104, 2020, 8765.50, s3 );
//		Fattura f8 = new Fattura(c8, LocalDate.of(2019, 4, 19), 127, 2020, 1358.50, s1 );
//		Fattura f9 = new Fattura(c9, LocalDate.of(2010, 6, 20), 104, 2020, 8643.50, s1 );
//		Fattura f10 = new Fattura(c10, LocalDate.of(2019, 11, 21), 134, 2020,3676.50, s1 );
//		Fattura f11 = new Fattura(c11, LocalDate.of(2011, 10, 23), 61, 2020, 1367.50, s2 );
//		Fattura f12 = new Fattura(c12, LocalDate.of(2012, 7, 26), 135, 2020, 25.50, s2 );
//		Fattura f13 = new Fattura(c13, LocalDate.of(2014, 1, 29), 169, 2020, 1954.50, s1 );
//		Fattura f14= new Fattura(c14, LocalDate.of(2010, 9, 16), 12, 2020, 1936.50, s3 );
//		Fattura f15 = new Fattura(c15, LocalDate.of(2006, 6, 7), 11, 2020, 4587.50, s3 );
//		Fattura f16 = new Fattura(c16, LocalDate.of(2007, 8, 5), 19, 2020, 6424.50, s1 );
//		Fattura f17= new Fattura(c17, LocalDate.of(2004, 5, 11), 154, 2020, 56.50, s1 );
//		Fattura f18 = new Fattura(c18, LocalDate.of(2001, 3, 9), 185, 2020, 97.50, s1 );
//		Fattura f19 = new Fattura(c19, LocalDate.of(2014, 10, 28), 117, 2020, 11.50, s2 );
//		Fattura f20 = new Fattura(c20, LocalDate.of(2017, 10, 30), 914, 2020, 78.50, s1 );
//		fattura.save(f1);
//		fattura.save(f2);
//		fattura.save(f3);
//		fattura.save(f4);
//		fattura.save(f5);
//		fattura.save(f6);
//		fattura.save(f7);
//		fattura.save(f8);
//		fattura.save(f9);
//		fattura.save(f10);
//		fattura.save(f11);
//		fattura.save(f12);
//		fattura.save(f13);
//		fattura.save(f14);
//		fattura.save(f15);
//		fattura.save(f16);
//		fattura.save(f17);
//		fattura.save(f18);
//		fattura.save(f19);
//		fattura.save(f20);

		
		




	}

}
