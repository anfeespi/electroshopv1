package co.edu.unbosque.electroshopv1.model;

import java.util.Set;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;

public class ClientDTO {
	@Length(min = 7, max = 10, message = "Formato incorrecto de la cédula")
	@NotBlank(message = "La cédula no puede estar en blanco")
	private String clientId;
	
	@Length(max = 50, message = "El nombre es demasiado largo")
	@NotBlank(message = "Ups! ese nombre es del hombre invisible")
	private String name;

	@Range(min = 18, max = 150, message = "La edad no es adecuada para hacer compras")
	@NotBlank(message = "La edad no puede ser vacía")
	private Integer age;
	
	@NotBlank(message = "La direecion no debe ser vacia")
	private String address;
	
	private Set<Integer> orders;
	
	public ClientDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param name
	 * @param age
	 * @param address
	 * @param orders
	 */
	public ClientDTO(
			@Length(min = 7, max = 10, message = "Formato incorrecto de la cédula") @NotBlank(message = "La cédula no puede estar en blanco") String clientId,
			@Length(max = 50, message = "El nombre es demasiado largo") @NotBlank(message = "Ups! ese nombre es del hombre invisible") String name,
			@Range(min = 18, max = 150, message = "La edad no es adecuada para hacer compras") @NotBlank(message = "La edad no puede ser vacía") Integer age,
			@NotBlank(message = "La direecion no debe ser vacia") String address, Set<Integer> orders) {
		super();
		this.clientId = clientId;
		this.name = name;
		this.age = age;
		this.address = address;
		this.orders = orders;
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the orders
	 */
	public Set<Integer> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Set<Integer> orders) {
		this.orders = orders;
	}
	
}
