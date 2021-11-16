package it.brandonmorques.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import it.brandonmorques.model.Fattura;

@Component
public interface FatturaRepository extends JpaRepository<Fattura, Long> {

	@Query("SELECT c FROM Fattura c WHERE c.cliente.nomeContatto=:cliente")
	public List<Fattura> findByCliente(String cliente, Pageable page);

	@Query("SELECT c FROM Fattura c WHERE c.stato.nome=:stato")
	public List<Fattura> findByStato(String stato,Pageable pageable);

	@Query("SELECT c FROM Fattura c WHERE c.data=:data")
	public List<Fattura> findByData(LocalDate data, Pageable page);

	@Query("SELECT c FROM Fattura c WHERE c.anno=:anno")
	public List<Fattura> findByAnno(Integer anno, Pageable page);

	@Query("SELECT c FROM Fattura c WHERE c.importo BETWEEN :minimo AND :massimo")
	public List<Fattura> findByRangeImporto(Double minimo, Double massimo, Pageable page);

	public Fattura getById(Long id);

}
