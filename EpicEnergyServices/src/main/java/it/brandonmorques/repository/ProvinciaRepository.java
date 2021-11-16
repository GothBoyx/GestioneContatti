package it.brandonmorques.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import it.brandonmorques.model.Provincia;

@Component
public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

	@Query("SELECT c FROM Provincia c WHERE c.nome=:nome")
	public Provincia findByNome(String nome);

	public Provincia getById(Long id);

}
