package co.edu.unbosque.electroshopv1.model;

import java.util.List;

import jakarta.validation.constraints.NotNull;

public class RequestOrderDTO {
	@NotNull(message = "El pedido no puede estar vacío")
	private OrderDTO orderDTO;
	
	@NotNull(message = "La tarjeta no puede ser vacía")
	private CardDTO cardDTO;
	
	@NotNull(message = "Se deben incluir productos")
	private List<OrderDetailDTO> orderDetails;
	
	public RequestOrderDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param orderDTO
	 * @param cardDTO
	 * @param orderDetails
	 */
	public RequestOrderDTO(@NotNull(message = "El pedido no puede estar vacío") OrderDTO orderDTO,
			@NotNull(message = "La tarjeta no puede ser vacía") CardDTO cardDTO,
			@NotNull(message = "Se deben incluir productos") List<OrderDetailDTO> orderDetails) {
		super();
		this.orderDTO = orderDTO;
		this.cardDTO = cardDTO;
		this.orderDetails = orderDetails;
	}

	/**
	 * @return the orderDTO
	 */
	public OrderDTO getOrderDTO() {
		return orderDTO;
	}

	/**
	 * @param orderDTO the orderDTO to set
	 */
	public void setOrderDTO(OrderDTO orderDTO) {
		this.orderDTO = orderDTO;
	}

	/**
	 * @return the cardDTO
	 */
	public CardDTO getCardDTO() {
		return cardDTO;
	}

	/**
	 * @param cardDTO the cardDTO to set
	 */
	public void setCardDTO(CardDTO cardDTO) {
		this.cardDTO = cardDTO;
	}

	/**
	 * @return the orderDetails
	 */
	public List<OrderDetailDTO> getOrderDetails() {
		return orderDetails;
	}

	/**
	 * @param orderDetails the orderDetails to set
	 */
	public void setOrderDetails(List<OrderDetailDTO> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
}
