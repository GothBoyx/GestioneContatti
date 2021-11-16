package it.brandonmorques.controller;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import it.brandonmorques.model.Cliente;
import it.brandonmorques.model.ERole;
import it.brandonmorques.model.Fattura;
import it.brandonmorques.model.Role;
import it.brandonmorques.model.TipoCliente;
import it.brandonmorques.model.User;
import it.brandonmorques.repository.ClienteRepository;
import it.brandonmorques.repository.FatturaRepository;
import it.brandonmorques.repository.IndirizzoRepository;
import it.brandonmorques.repository.RoleRepository;
import it.brandonmorques.repository.StatoFatturaRepository;
import it.brandonmorques.repository.UserRepository;
import it.brandonmorques.request.LoginRequest;
import it.brandonmorques.request.SignupRequest;
import it.brandonmorques.security.JwtUtils;
import it.brandonmorques.service.ClienteService;
import it.brandonmorques.service.FatturaService;

@RestController
@RequestMapping("/html")
public class HtmlController {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserRepository userRepository;
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	FatturaRepository repo;
	@Autowired
	FatturaService service;
	@Autowired
	ClienteRepository c;
	@Autowired
	StatoFatturaRepository sf;
	@Autowired
	IndirizzoRepository ind;
	@Autowired
	ClienteService cs;
	

	@GetMapping("/creafattura")
	public ModelAndView save(@RequestParam String nomeContatto, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data,
			Integer numero, Integer anno, Integer importo, String stato) {
		ModelAndView mv = new ModelAndView();
		repo.save(new Fattura(c.getByNomeContatto(nomeContatto), data, numero, anno, importo, sf.getByNome(stato)));
		mv.addObject("fatture", repo.findAll());
		mv.setViewName("listafatture");
		return mv;
	}

	@RequestMapping("/fatture")
	public ModelAndView fatture() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("fatture");
		return mv;
	}

	@RequestMapping("/listafatture")
	public ModelAndView listaFatture() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("fatture", repo.findAll());
		mv.setViewName("listafatture");
		return mv;
	}

	@GetMapping("/creacliente")
	public ModelAndView saveCliente(@RequestParam String ragioneSociale, Double partitaIva, TipoCliente tipoCliente,
			String email, String pec, Integer telefono, String nomeContatto, String cognomeContatto,
			Integer telefonoContatto, String emailContatto, String indirizzoSedeOperativa, String indirizzoSedeLegale,
			@DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate dataInserimento, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate dataUltimoContatto, Double fatturatoAnnuale) {
		ModelAndView mv = new ModelAndView();
		c.save(new Cliente(ragioneSociale, partitaIva, tipoCliente, email, pec, telefono, nomeContatto, cognomeContatto,
				telefonoContatto, emailContatto, ind.getByVia(indirizzoSedeOperativa),
				ind.getByVia(indirizzoSedeLegale), dataInserimento, dataUltimoContatto, fatturatoAnnuale));
		mv.addObject("creaclienti", c.findAll());
		mv.setViewName("/listaclienti");
		return mv;
	}

	@RequestMapping("/clienti")
	public ModelAndView clienti() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("clienti");
		return mv;
	}

	@RequestMapping("/listaclienti")
	public ModelAndView listaClienti() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("creaclienti", c.findAll());
		mv.setViewName("listaclienti");
		return mv;
	}

	@PostMapping("/loginform")
	public ModelAndView authenticateUserForm(LoginRequest loginRequest) {
		ModelAndView model = new ModelAndView();
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		authentication.getAuthorities();
		SecurityContextHolder.getContext().setAuthentication(authentication);
		model.setViewName("scelte");
		return model;
	}

	@PostMapping(value = "/signupform")
	public ModelAndView registerUserForm(SignupRequest signUpRequest) {
		ModelAndView model = new ModelAndView();
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			model.setViewName("username");
			return model;
		}
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			model.setViewName("email");
			return model;
		}
		User user = new User(null, signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()), signUpRequest.getNome(), signUpRequest.getCognome());
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		// Verifica l'esistenza dei Role
		if (strRoles == null) {
			Role userRole = roleRepository.findByRoleType(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Errore: Role non trovato!"));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByRoleType(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Errore: Role non trovato!"));
					roles.add(adminRole);
					break;
				default:
					Role userRole = roleRepository.findByRoleType(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Errore: Role non trovato!"));
					roles.add(userRole);
				}
			});
		}
		user.setRoles(roles);
		userRepository.save(user);
		authenticateUserForm(new LoginRequest(signUpRequest.getUsername(), signUpRequest.getPassword()));
		model.setViewName("scelte");
		return model;
	}


@GetMapping(value = "/getorder", produces = MediaType.APPLICATION_JSON_VALUE)
public ModelAndView myGetAllUserPageSizeSortModel(@RequestParam(defaultValue = "0") Integer page,
		@RequestParam(defaultValue = "50") Integer size, @RequestParam(defaultValue = "nomeContatto") String sort) {
	ModelAndView myModel=new ModelAndView();
	List<Cliente> list = cs.myFindAllClientePageSizeSort(page, size, sort);
	myModel.addObject("creaclienti", list);
	myModel.setViewName("listaclienti");
	return myModel;
}

@GetMapping("/getbyfatturato")
public ModelAndView getByfatturato(@RequestParam Double fatturato,
		@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "50") Integer size) {
	Pageable pageable = PageRequest.of(page, size);
	ModelAndView myModel=new ModelAndView();
	List<Cliente> list = cs.findByListaFatturatoAnnuale(fatturato, pageable);
	myModel.addObject("creaclienti", list);
	myModel.setViewName("listaclienti");
	return myModel;
}

@GetMapping("/getbydataultimocontatto")
public ModelAndView getBydataContatto(
		@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataUltimoContatto,
		@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "50") Integer size) {
	ModelAndView myModel=new ModelAndView();
	Pageable pageable = PageRequest.of(page, size);
	List<Cliente> list = cs.findByListaDataUltimoContatto(dataUltimoContatto, pageable);
	myModel.addObject("creaclienti", list);
	myModel.setViewName("listaclienti");
	return myModel;
}

@GetMapping("/getbydatainserimento")
public ModelAndView getClientiByDataInserimento(
		@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInserimento,
		@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "50") Integer size) {
	ModelAndView myModel=new ModelAndView();
	Pageable pag = PageRequest.of(page, size);
	List<Cliente> list = cs.findByListaDataInserimento(dataInserimento, pag);
	myModel.addObject("creaclienti", list);
	myModel.setViewName("listaclienti");
	return myModel;
}

@GetMapping("/getbypartedelnome")
public ModelAndView getClientiByParteDelNome(@RequestParam String nome,
		@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "50") Integer size) {
	ModelAndView myModel=new ModelAndView();
	Pageable pag = PageRequest.of(page, size);
	List<Cliente> list = cs.findByParteDelNome(nome, pag);
	myModel.addObject("creaclienti", list);
	myModel.setViewName("listaclienti");
	return myModel;
	
	}
@GetMapping("/getbycliente")
public ModelAndView getfatturabyclienteviewadmin(@RequestParam String cliente,
		@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "50") Integer size) {
	ModelAndView myModel = new ModelAndView();
	Pageable pag = PageRequest.of(page, size);
	List<Fattura> list = service.findByCliente(cliente, pag);
	myModel.addObject("fatture", list);
	myModel.setViewName("listafatture");
	return myModel;
}

@GetMapping("/getbystato")
public ModelAndView getfatturabystato(@RequestParam String stato, @RequestParam(defaultValue = "0") Integer page,
		@RequestParam(defaultValue = "50") Integer size) {
	ModelAndView myModel = new ModelAndView();
	Pageable pag = PageRequest.of(page, size);
	List<Fattura> list = service.findByStato(stato, pag);
	myModel.addObject("fatture", list);
	myModel.setViewName("listafatture");
	return myModel;
}
@GetMapping("/getbydata")
public ModelAndView getfatturabydata(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data,
		@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "50") Integer size) {
	ModelAndView myModel=new ModelAndView();
	Pageable pag = PageRequest.of(page, size);
	List<Fattura> list = service.findByData(data, pag);
	myModel.addObject("fatture", list);
	myModel.setViewName("listafatture");
	return myModel;
}

@GetMapping("/getbyanno")
public ModelAndView getfatturabydata(@RequestParam Integer anno, @RequestParam(defaultValue = "0") Integer page,
		@RequestParam(defaultValue = "50") Integer size) {
	ModelAndView myModel=new ModelAndView();
	Pageable pag = PageRequest.of(page, size);
	List<Fattura> list = service.findByAnno(anno, pag);
	myModel.addObject("fatture", list);
	myModel.setViewName("listafatture");
	return myModel;
}

@GetMapping("/getbyrangeimporto")
public ModelAndView getfatturabyrangeimportoviewadmin(@RequestParam(defaultValue = "0") Double minimo,
		@RequestParam(defaultValue = "10000000") Double massimo, @RequestParam(defaultValue = "0") Integer page,
		@RequestParam(defaultValue = "50") Integer size) {
	ModelAndView myModel=new ModelAndView();
	Pageable pag = PageRequest.of(page, size);
	List<Fattura> list = service.findByRangeImporto(minimo, massimo, pag);
	myModel.addObject("fatture", list);
	myModel.setViewName("listafatture");
	return myModel;

	}

}



