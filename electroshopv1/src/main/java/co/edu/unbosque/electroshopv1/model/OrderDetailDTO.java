package co.edu.unbosque.electroshopv1.model;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;

public class OrderDetailDTO {
	@NotNull(message = "El pedido no está especificado")
	private Integer order;
	
	@NotNull(message = "El producto no está especificado")
	private Integer product;
	
	@Range(min = 1, message = "La cantidad no es la minima")
	private Integer quantity;
	
	public OrderDetailDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param order
	 * @param product
	 * @param quantity
	 */
	public OrderDetailDTO(@NotNull(message = "El pedido no está especificado") Integer order,
			@NotNull(message = "El producto no está especificado") Integer product,
			@Range(min = 1, message = "La cantidad no es la minima") Integer quantity) {
		super();
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}

	/**
	 * @return the order
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}

	/**
	 * @return the product
	 */
	public Integer getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Integer product) {
		this.product = product;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
