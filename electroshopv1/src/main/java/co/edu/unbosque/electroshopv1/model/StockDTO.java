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
}
