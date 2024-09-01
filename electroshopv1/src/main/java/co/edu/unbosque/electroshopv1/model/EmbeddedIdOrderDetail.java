package co.edu.unbosque.electroshopv1.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class EmbeddedIdOrderDetail {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
	private Order order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
	private Product product;
	
	public EmbeddedIdOrderDetail() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param order
	 * @param product
	 */
	public EmbeddedIdOrderDetail(Order order, Product product) {
		super();
		this.order = order;
		this.product = product;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
