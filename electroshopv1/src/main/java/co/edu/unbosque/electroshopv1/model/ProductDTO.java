package co.edu.unbosque.electroshopv1.model;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDTO {
	@NotBlank(message = "El producto no tiene identificador")
	private Integer productId;
	
	@NotBlank(message = "El nombre del producto no debe ser vacío")
	private String name;
	
	@Range(min = 0, message = "El producto debe tener un costo")
	private Long value;
	
	@JsonBackReference
	@NotNull(message = "La categoria no deberia ser vacía")
	private ProductCategory category;
	
	@JsonBackReference
	@NotNull(message = "El stock no está referenciado")
	private StockDTO stock;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param productId
	 * @param name
	 * @param value
	 * @param category
	 */
	public ProductDTO(@NotBlank(message = "El producto no tiene identificador") Integer productId,
			@NotBlank(message = "El nombre del producto no debe ser vacío") String name,
			@Range(min = 0, message = "El producto debe tener un costo") Long value,
			@NotNull(message = "La categoria no deberia ser vacía") ProductCategory category) {
		super();
		this.productId = productId;
		this.name = name;
		this.value = value;
		this.category = category;
	}



	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
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
	 * @return the value
	 */
	public Long getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Long value) {
		this.value = value;
	}

	/**
	 * @return the category
	 */
	public ProductCategory getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	
}
