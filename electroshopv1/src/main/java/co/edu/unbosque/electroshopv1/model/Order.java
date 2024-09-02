package co.edu.unbosque.electroshopv1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Integer orderId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
	private Client client;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_met_pago")
	private PaymentMethod paymentMethod;

	@Column(name = "valor_total")
	private Long totalValue;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param client
	 * @param paymentMethod
	 * @param totalValue
	 */
	public Order(Client client, PaymentMethod paymentMethod, Long totalValue) {
		super();
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
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
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
