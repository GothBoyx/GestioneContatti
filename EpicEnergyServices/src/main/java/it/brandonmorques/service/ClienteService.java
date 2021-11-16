package it.brandonmorques.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.brandonmorques.model.Cliente;
import it.brandonmorques.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	public void delete(Long id) {
		clienteRepository.deleteById(id);

	}

	public void update(Long id, Cliente c) {
		Cliente ce = clienteRepository.getById(id);
		ce.setEmail(c.getEmail());
		ce.setNomeContatto(c.getNomeContatto());
		ce.setCognomeContatto(c.getCognomeContatto());
		clienteRepository.save(ce);

	}
	 public List<Cliente> findByParteDelNome (String nome,Pageable pageable){
		 return clienteRepository.getByParteDelNome(nome,pageable);
	 }
	public List<Cliente> findByListaFatturatoAnnuale(Double fatturatoAnnuale, Pageable pageable) {
		return clienteRepository.findAllOrderByListaFatturatoAnnuale(fatturatoAnnuale, pageable);

	}

	public List<Cliente> findByListaDataInserimento(LocalDate dataInserimento, Pageable pageable) {
		return clienteRepository.findAllOrderByListaDataInserimento(dataInserimento, pageable);

	}

	public List<Cliente> findByListaDataUltimoContatto(LocalDate dataUltimoContatto, Pageable pageable) {
		return clienteRepository.findAllOrderByListaDataUltimoContatto(dataUltimoContatto, pageable);

	}

	public List<Cliente> myFindAllClientePageSizeSort(Integer page, Integer size, String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		Page<Cliente> pagedResult = clienteRepository.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Cliente>();
		}

	}

}
