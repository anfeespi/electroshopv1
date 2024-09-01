package co.edu.unbosque.electroshopv1.model;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.validation.constraints.NotBlank;

public class OrderDTO {
	@NotBlank(message = "El pedido no tiene identificador")
	private Integer orderId;
	
	@JsonBackReference
	@NotBlank(message = "El cliente no está asociado")
	private ClientDTO client;
	
	@JsonBackReference
	@NotBlank(message = "Se debe asociar un método de pago")
	private PaymentMethod paymentMethod;
	
	@Range(min = 0, message = "El valor de la compra no debe ser 0")
	private Long totalValue;
	
	public OrderDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param orderId
	 * @param client
	 * @param paymentMethod
	 * @param totalValue
	 */
	public OrderDTO(@NotBlank(message = "El pedido no tiene identificador") Integer orderId,
			@NotBlank(message = "El cliente no está asociado") ClientDTO client,
			@NotBlank(message = "Se debe asociar un método de pago") PaymentMethod paymentMethod,
			@Range(min = 0, message = "El valor de la compra no debe ser 0") Long totalValue) {
		super();
		this.orderId = orderId;
		this.client = client;
		this.paymentMethod = paymentMethod;
		this.totalValue = totalValue;
	}

	/**
	 * @return the orderId
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the client
	 */
	public ClientDTO getClientDTO() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClientDTO(ClientDTO client) {
		this.client = client;
	}

	/**
	 * @return the paymentMethod
	 */
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * @return the totalValue
	 */
	public Long getTotalValue() {
		return totalValue;
	}

	/**
	 * @param totalValue the totalValue to set
	 */
	public void setTotalValue(Long totalValue) {
		this.totalValue = totalValue;
	}
	
}
