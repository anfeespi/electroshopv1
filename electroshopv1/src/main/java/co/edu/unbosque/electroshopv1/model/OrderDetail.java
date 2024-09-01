package co.edu.unbosque.electroshopv1.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalles_pedido")
public class OrderDetail {
	@EmbeddedId
	private EmbeddedIdOrderDetail orderDetailId;
	
	@Column(name = "cantidad_producto_pedido")
	private Integer quantity;
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param orderDetailId
	 * @param quantity
	 */
	public OrderDetail(EmbeddedIdOrderDetail orderDetailId, Integer quantity) {
		super();
		this.orderDetailId = orderDetailId;
		this.quantity = quantity;
	}

	/**
	 * @return the orderDetailId
	 */
	public EmbeddedIdOrderDetail getOrderDetailId() {
		return orderDetailId;
	}

	/**
	 * @param orderDetailId the orderDetailId to set
	 */
	public void setOrderDetailId(EmbeddedIdOrderDetail orderDetailId) {
		this.orderDetailId = orderDetailId;
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
