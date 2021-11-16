package it.brandonmorques;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;

public class StringAttributeConverter implements AttributeConverter<String, String> {

	/*
	 * Cripta con AES-128, modalità ECB, padding PKCS7 - AES (Advanced Encryption
	 * Standard): algoritmo di cifratura - ECB (Electronic CodeBook): algoritmo di
	 * cifratura a blocchi: a differenza degli algoritmi a flusso che cifrano un
	 * singolo elemento alla volta, gli algoritmi a blocco cifrano un blocco di
	 * elementi contemporaneamente. - Padding: riempie i blocchi con byte di
	 * riempimento
	 */
	private static final String ALGORITHM = "AES/ECB/PKCS5Padding";
	private static final byte[] KEY = "MySuperSecretKey".getBytes();

	/*
	 * Converte il valore della proprietà dell'entità nella rappresentazione dei
	 * dati da archiviare nel database
	 */
	@Override
	public String convertToDatabaseColumn(String clearString) {
		Key key = new SecretKeySpec(KEY, "AES");
		try {
			// Cypher fornisce la funzionalità per la crittografia e la decrittografia
			Cipher c = Cipher.getInstance(ALGORITHM);
			c.init(Cipher.ENCRYPT_MODE, key);
			// Codifica
			return Base64.getEncoder().encodeToString((c.doFinal(clearString.getBytes())));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * Converte i dati archiviati nella colonna del database nel valore della
	 * proprietà dell'entità
	 */
	@Override
	public String convertToEntityAttribute(String dbData) {
		Key key = new SecretKeySpec(KEY, "AES");
		try {
			Cipher c = Cipher.getInstance(ALGORITHM);
			c.init(Cipher.DECRYPT_MODE, key);
			// Decodifica
			return new String(c.doFinal(Base64.getDecoder().decode(dbData)));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
