package co.edu.unbosque.electroshopv1.model;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.validation.constraints.NotNull;

public class StockDTO {
	@NotNull(message = "El identificador no debe ser vacio")
	private Integer stockId;
	
	@JsonManagedReference
	@NotNull(message = "Producto no especificado")
	private ProductDTO product;

	@Range(min = 1, message = "Cantidad no aceptada")
	private Integer stock;
	
	public StockDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param stockId
	 * @param product
	 * @param stock
	 */
	public StockDTO(@NotNull(message = "El identificador no debe ser vacio") Integer stockId,
			@NotNull(message = "Producto no especificado") ProductDTO product,
			@Range(min = 1, message = "Cantidad no aceptada") Integer stock) {
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
	public ProductDTO getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(ProductDTO product) {
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
