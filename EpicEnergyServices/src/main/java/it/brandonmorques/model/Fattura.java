package it.brandonmorques.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fattura")
public class Fattura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	private Cliente cliente;
	private LocalDate data;
	private int numero;
	private int anno;
	private double importo;
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	private StatoFattura stato;

	public Fattura(Cliente cliente, LocalDate data, int numero, int anno, double importo, StatoFattura stato) {
		this.cliente = cliente;
		this.data = data;
		this.numero = numero;
		this.anno = anno;
		this.importo = importo;
		this.stato = stato;
	
		
	}

}
