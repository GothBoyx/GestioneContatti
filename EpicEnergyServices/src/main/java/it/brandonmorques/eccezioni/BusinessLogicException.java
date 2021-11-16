package it.brandonmorques.eccezioni;

public class BusinessLogicException extends Exception {
	private static final long serialVersionUID = 1L;
	String message;

	public BusinessLogicException(String message) {
		this.message = message;
	}
}
