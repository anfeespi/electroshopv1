package co.edu.unbosque.electroshopv1.model;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;

public class OrderDetailDTO {
	@NotNull(message = "El pedido no está especificado")
	private OrderDTO order;
	
	@NotNull(message = "El producto no está especificado")
	private ProductDTO product;
	
	@Range(min = 1, message = "La cantidad no es la minima")
	private Integer quantity;
}
