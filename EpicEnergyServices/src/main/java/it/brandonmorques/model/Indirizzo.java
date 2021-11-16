package it.brandonmorques.model;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "indirizzo")
public class Indirizzo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String via;
	private int civico;
	private int cap;
	private String localita;
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	private Comune comune;

	public Indirizzo(String via, int civico, int cap, String localita, Comune comune) {
		this.via = via;
		this.civico = civico;
		this.cap = cap;
		this.localita = localita;
		this.comune = comune;
	}

}
