package it.brandonmorques.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import it.brandonmorques.model.Cliente;

@Component
public interface ClienteRepository extends JpaRepository<Cliente, Long> {



	@Query("SELECT c FROM Cliente c WHERE c.ragioneSociale LIKE %:nome%")
	public List<Cliente> getByParteDelNome (String nome,Pageable pageable);
	public Cliente getByRagioneSociale(String cliente);
	
	@Query("SELECT c FROM Cliente c WHERE c.fatturatoAnnuale=:fatturatoAnnuale")
	public List<Cliente> findAllOrderByListaFatturatoAnnuale(double fatturatoAnnuale, Pageable pageable);

	@Query("SELECT c FROM Cliente c WHERE c.dataInserimento=:dataInserimento")
	public List<Cliente> findAllOrderByListaDataInserimento(LocalDate dataInserimento, Pageable pageable);

	@Query("SELECT c FROM Cliente c WHERE c.dataUltimoContatto=:dataUltimoContatto")
	public List<Cliente> findAllOrderByListaDataUltimoContatto(LocalDate dataUltimoContatto, Pageable pageable);

	// update
	public Cliente getById(Long id);
	public Cliente getByNomeContatto(String nomeContatto);

}
