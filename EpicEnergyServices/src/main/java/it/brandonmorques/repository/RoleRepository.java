package it.brandonmorques.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.brandonmorques.model.ERole;
import it.brandonmorques.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByRoleType(ERole roletype);

}
