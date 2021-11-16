package it.brandonmorques.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.brandonmorques.model.Fattura;
import it.brandonmorques.repository.FatturaRepository;

@Service
public class FatturaService {

	@Autowired
	FatturaRepository fatturaRepository;

	public void update(Long id, Fattura fattura) {
		Fattura ce = fatturaRepository.getById(id);
		ce.setAnno(fattura.getAnno());
		ce.setData(fattura.getData());
		ce.setImporto(fattura.getImporto());
		ce.setNumero(fattura.getNumero());
		ce.setStato(fattura.getStato());
		fatturaRepository.save(ce);
	}

	public void save(Fattura fattura) {
		fatturaRepository.save(fattura);
	}

	public void deleteById(Long Id) {
		fatturaRepository.deleteById(Id);
	}

	public List<Fattura> findByCliente(String cliente, Pageable page) {
		return fatturaRepository.findByCliente(cliente, page);

	}

	public List<Fattura> findByStato(String nome, Pageable page) {
		return fatturaRepository.findByStato(nome, page);

	}

	public List<Fattura> findByData(LocalDate data, Pageable page) {
		return fatturaRepository.findByData(data, page);

	}

	public List<Fattura> findByAnno(Integer anno, Pageable page) {
		return fatturaRepository.findByAnno(anno, page);
	}

	public List<Fattura> findByRangeImporto(Double minimo, Double massimo, Pageable page) {
		return fatturaRepository.findByRangeImporto(minimo, massimo, page);
	}

}
