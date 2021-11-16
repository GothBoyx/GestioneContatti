package it.brandonmorques.request;

import java.util.Set;

//import javax.validation.constraints.Email;
public class SignupRequest {
	private String username;
//	    @Email
	private String email;
	private Set<String> role;
	private String password;
	private String nome;
	private String cognome;

	 public String getUsername() {
			return username;
		}
		public SignupRequest setUsername(String username) {
			this.username = username;
			return this;
		}
		public String getEmail() {
			return email;
		}
		public SignupRequest setEmail(String email) {
			this.email = email;
			return this;
		}
		public Set<String> getRole() {
			return role;
		}
		public SignupRequest setRole(Set<String> role) {
			this.role = role;
			return this;
		}
		public SignupRequest(String username, String email, Set<String> role, String password, String nome,
				String cognome) {
			this.username = username;
			this.email = email;
			this.role = role;
			this.password = password;
			this.nome = nome;
			this.cognome = cognome;
		}

		public String getPassword() {
			return password;
		}
		public SignupRequest setPassword(String password) {
			this.password = password;
			return this;
		}
		public String getNome() {
			return nome;
		}
		public SignupRequest setNome(String nome) {
			this.nome = nome;
			return this;
		}
		public String getCognome() {
			return cognome;
		}
		public SignupRequest setCognome(String cognome) {
			this.cognome = cognome;
			return this;
		}
	}
	


