package co.edu.unbosque.electroshopv1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.electroshopv1.model.RequestOrderDTO;
import co.edu.unbosque.electroshopv1.service.CardService;
import co.edu.unbosque.electroshopv1.service.OrderDetailService;
import co.edu.unbosque.electroshopv1.service.OrderService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
@Transactional
public class OrderController {
	@Autowired
	private OrderService orderService;

	@Autowired
	private CardService cardService;

	@Autowired
	private OrderDetailService orderDetailService;

	public OrderController() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/procesar")
	public ResponseEntity<?> processAnOrder(@Valid @RequestBody RequestOrderDTO requestOrderDTO) {
		StringBuilder serverResponse = new StringBuilder();
		if (orderService.createOrder(requestOrderDTO.getOrderDTO())) {
			serverResponse.append("Pedido creado con éxito...\n");
		} else {
			serverResponse.append("Error creando el pedido...\n");
		}

		serverResponse.append(cardService.validateCard(requestOrderDTO.getCardDTO()) + "\n");

		serverResponse.append(orderDetailService.addDetails(requestOrderDTO.getOrderDetails()) + "\n");

		return ResponseEntity.ok(serverResponse.toString());
	}

}
