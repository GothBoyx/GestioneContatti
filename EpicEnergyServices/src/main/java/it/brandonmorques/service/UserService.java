package it.brandonmorques.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.brandonmorques.model.User;
import it.brandonmorques.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	

	public User getById(long id) {
		return userRepository.getById(id);
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public void save(User e) {
		userRepository.save(e);
	}

	public Page<User> myFindAllUsersPageable(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public Page<User> myFindAllUsersPageSize(Integer page, Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<User> pagedResult = userRepository.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult;
		} else {
			return null;
		}
	}

	// Paginazione e Ordinamento
	public List<User> myFindAllUsersPageSizeSort(Integer page, Integer size, String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		Page<User> pagedResult = userRepository.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<User>();
		}
	}

	// Ordinamento
	public List<User> myFindAllUsersSorted() {
		return userRepository.findByOrderByNomeAsc();
	}

}
