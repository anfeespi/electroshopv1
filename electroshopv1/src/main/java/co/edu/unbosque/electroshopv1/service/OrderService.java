package co.edu.unbosque.electroshopv1.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.edu.unbosque.electroshopv1.exception.NotContentException;
import co.edu.unbosque.electroshopv1.exception.NotCreateException;
import co.edu.unbosque.electroshopv1.exception.NotFoundException;
import co.edu.unbosque.electroshopv1.model.Order;
import co.edu.unbosque.electroshopv1.model.OrderDTO;
import co.edu.unbosque.electroshopv1.repository.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepository;
	
	
	public OrderService() {

	}

	public boolean createOrder(OrderDTO order) {
		orderRepository.save(Transformation.transformOrderDTOToOrder(order));
		return true;
	}

	public List<OrderDTO> showAllOrders() {
		List<Order> ordertList = (List<Order>)orderRepository.findAll();
		List<OrderDTO> orderDTOList = new ArrayList<OrderDTO>(); 
		for (int i = 0; i < ordertList.size(); i++) {
			orderDTOList.add(Transformation.transformOrderToOrderDTO(ordertList.get(i)));
		}
		return orderDTOList;
	}
	
	public boolean existOrderById(Integer id) {
		return orderRepository.existsById(id);
	}

	public OrderDTO getOrderById(Integer id) {		
		return Transformation.transformOrderToOrderDTO(orderRepository.findById(id).get());
	}
	
	
	public ResponseEntity<String> validateCreateOrder(OrderDTO orderDTO) {
		if(!createOrder(orderDTO)) {
			throw new NotCreateException("El código de la orden está duplicado");
		}
		return ResponseEntity.ok("Orden creada con éxito");
	}
	
	public ResponseEntity<List<Order>> validateShowAllOrders(){
		List<OrderDTO> orderDTOList = showAllOrders();
		if (orderDTOList.size() == 0) {
			throw new NotContentException(null);
		}else {
			List<Order> ordertList = new ArrayList<Order>(); 
			for (int i = 0; i < orderDTOList.size(); i++) {
				ordertList.add(Transformation.transformOrderDTOToOrder(orderDTOList.get(i)));
			}
			return ResponseEntity.ok(ordertList);		}
	}
	
	public ResponseEntity<String> validateExistingOrder(Integer id){
		if(!existOrderById(id)) {
			throw new NotFoundException("La orden proporcionada no está registrada");
		}
		return ResponseEntity.ok("La orden proporcionada está registrada");
	}
}
