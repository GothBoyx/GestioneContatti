package it.brandonmorques.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import it.brandonmorques.model.Comune;

@Component
public interface ComuneRepository extends JpaRepository<Comune, Long> {

	public Comune getById(Long id);
	
	public Comune getFirstByNome(String nome);

	
}
