package co.edu.unbosque.electroshopv1.model;

import org.hibernate.validator.constraints.Length;

public class CardDTO {
	@Length(min = 16, max = 19, message = "El número de la tarjeta es incorrecto")
	private String number;
	@Length(min = 4, max = 5, message = "La expiración es incorrecta")
	private String expiration;
	@Length(min = 3, max = 3, message = "La clave de seguridad no es correcta")
	private String cvc;
	
	public CardDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param number
	 * @param expiration
	 * @param cvc
	 */
	public CardDTO(String number, String expiration, String cvc) {
		super();
		this.number = number;
		this.expiration = expiration;
		this.cvc = cvc;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the expiration
	 */
	public String getExpiration() {
		return expiration;
	}

	/**
	 * @param expiration the expiration to set
	 */
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	/**
	 * @return the cvc
	 */
	public String getCvc() {
		return cvc;
	}

	/**
	 * @param cvc the cvc to set
	 */
	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
	
	
}
