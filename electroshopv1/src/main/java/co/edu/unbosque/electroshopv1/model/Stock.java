package co.edu.unbosque.electroshopv1.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventarios")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_stock")
	private Integer stockId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
	private Product product;
	
	@Column(name = "cantidad_stock")
	private Integer stock;
	
	public Stock() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param stockId
	 * @param product
	 * @param stock
	 */
	public Stock(Integer stockId, Product product, Integer stock) {
		super();
		this.stockId = stockId;
		this.product = product;
		this.stock = stock;
	}

	/**
	 * @return the stockId
	 */
	public Integer getStockId() {
		return stockId;
	}

	/**
	 * @param stockId the stockId to set
	 */
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
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

	/**
	 * @return the stock
	 */
	public Integer getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}
}
