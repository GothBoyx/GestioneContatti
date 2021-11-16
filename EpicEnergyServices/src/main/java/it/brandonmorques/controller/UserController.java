package it.brandonmorques.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.brandonmorques.model.User;
import it.brandonmorques.service.UserService;

@RestController
@RequestMapping("/usercontroller")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/save")
	public void save(@RequestParam String username, String nome, String cognome, String email, String password, Boolean active) {
		userService.save(new User(username, nome,cognome,email, password, active));
	}

	@GetMapping("/utenti")
	@ResponseBody
	public List<User> getAll() {
		return userService.getAll();

	}

	// Paginazione
	@GetMapping(value = "/mygetalluserspage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<User>> myGetAllUsersPage(Pageable pageable) {
		Page<User> findAll = userService.myFindAllUsersPageable(pageable);
		if (findAll.hasContent()) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

		}
	}

	@GetMapping(value = "/mygetalluserspagesize", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> myGetAllUsersPageSize(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size) {
		Page<User> users = userService.myFindAllUsersPageSize(page, size);
		Map<String, Object> myResponse = new HashMap<>();
		myResponse.put("users", users);
		return myResponse;
	}

	@GetMapping(value = "/mygetalluserspagesizesort", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> myGetAllUserPageSizeSort(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "2") Integer size, @RequestParam(defaultValue = "id") String sort) {
		List<User> list = userService.myFindAllUsersPageSizeSort(page, size, sort);
		return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	@GetMapping(value = "/mygetalluserssortbyname", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> myGetAllusersSortByName() {
		return userService.myFindAllUsersSorted();
	}
}
