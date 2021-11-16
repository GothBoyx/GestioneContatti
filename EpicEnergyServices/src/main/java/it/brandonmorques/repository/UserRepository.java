package it.brandonmorques.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import it.brandonmorques.model.User;

@Component
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT c FROM User c WHERE c.username=:username")
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	public Page<User> findAll(Pageable pageable);

	public List<User> findByOrderByNomeAsc();
}
