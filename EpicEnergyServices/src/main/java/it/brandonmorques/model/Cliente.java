package it.brandonmorques.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ragioneSociale;
	private double partitaIva;
	@Enumerated(EnumType.STRING)
	private TipoCliente tipoCliente;
	private String email;
	private String pec;
	private int telefono;
	private String nomeContatto;
	private String cognomeContatto;
	private int telefonoContatto;
	private String emailContatto;
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	private Indirizzo indirizzoSedeOperativa;
	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	private Indirizzo indirizzoSedeLegale;
	LocalDate dataInserimento;
	LocalDate dataUltimoContatto;
	private double fatturatoAnnuale;

	public Cliente(String ragioneSociale, double partitaIva, TipoCliente tipoCliente, String email, String pec,
			int telefono, String nomeContatto, String cognomeContatto, int telefonoContatto, String emailContatto,
			Indirizzo indirizzoSedeOperativa, Indirizzo indirizzoSedeLegale, LocalDate dataInserimento,
			LocalDate dataUltimoContatto, double fatturatoAnnuale) {
		this.ragioneSociale = ragioneSociale;
		this.partitaIva = partitaIva;
		this.tipoCliente = tipoCliente;
		this.email = email;
		this.pec = pec;
		this.telefono = telefono;
		this.nomeContatto = nomeContatto;
		this.cognomeContatto = cognomeContatto;
		this.telefonoContatto = telefonoContatto;
		this.emailContatto = emailContatto;
		this.indirizzoSedeOperativa = indirizzoSedeOperativa;
		this.indirizzoSedeLegale = indirizzoSedeLegale;
		this.dataInserimento = dataInserimento;
		this.dataUltimoContatto = dataUltimoContatto;
		this.fatturatoAnnuale = fatturatoAnnuale;
	}

}
