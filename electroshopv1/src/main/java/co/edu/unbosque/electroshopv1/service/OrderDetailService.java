package co.edu.unbosque.electroshopv1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.edu.unbosque.electroshopv1.exception.NoEnoughStockException;
import co.edu.unbosque.electroshopv1.exception.NotCreateException;
import co.edu.unbosque.electroshopv1.exception.NotFoundException;
import co.edu.unbosque.electroshopv1.model.EmbeddedIdOrderDetail;
import co.edu.unbosque.electroshopv1.model.Order;
import co.edu.unbosque.electroshopv1.model.OrderDetail;
import co.edu.unbosque.electroshopv1.model.OrderDetailDTO;
import co.edu.unbosque.electroshopv1.model.Product;
import co.edu.unbosque.electroshopv1.repository.OrderDetailRepository;
import co.edu.unbosque.electroshopv1.repository.OrderRepository;
import co.edu.unbosque.electroshopv1.repository.ProductRepository;
import co.edu.unbosque.electroshopv1.repository.StockRepository;

@Service
public class OrderDetailService {
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StockRepository stockRepository;
	
	public OrderDetailService() {

	}

	public boolean createOrderDetail(OrderDetailDTO orderDetail) {
		List<Order> orders = (List<Order>) orderRepository.findAll();
		Order order = orders.get(orders.size()-1);
		Product product = productRepository.findById(orderDetail.getProduct()).get();
		
		if(stockRepository.findById(orderDetail.getProduct()).get().getStock() < orderDetail.getQuantity())
			throw new NoEnoughStockException("No hay suficientes " + stockRepository.findById(orderDetail.getProduct()).get().getProduct().getName());
		
		stockRepository.findById(orderDetail.getProduct()).get().setStock(stockRepository.findById(orderDetail.getProduct()).get().getStock() - orderDetail.getQuantity());
		
		orderDetailRepository.save(DataMapper.transformOrderDetailDTOToOrderDetail(orderDetail, order, product));
		return true;
	}

	public List<OrderDetailDTO> showAllOrderDetails() {
		List<OrderDetail> orderDetailtList = (List<OrderDetail>)orderDetailRepository.findAll();
		List<OrderDetailDTO> orderDetailDTOList = new ArrayList<OrderDetailDTO>(); 
		for (int i = 0; i < orderDetailtList.size(); i++) {
			orderDetailDTOList.add(DataMapper.transformOrderDetailToOrderTailDTO(orderDetailtList.get(i)));
		}
		return orderDetailDTOList;
	}
	
	public boolean existOrderDetailById(EmbeddedIdOrderDetail id) {
		return orderDetailRepository.existsById(id);
	}

	public OrderDetailDTO getOrderDetailById(EmbeddedIdOrderDetail id) {		
		return DataMapper.transformOrderDetailToOrderTailDTO(orderDetailRepository.findById(id).get());
	}
	
	public ResponseEntity<String> validateCreateOrderDetail(OrderDetailDTO orderDTO) {
		if(!createOrderDetail(orderDTO)) {
			throw new NotCreateException("El código de la orden está duplicado");
		}
		return ResponseEntity.ok("Orden creada con éxito");
	}
	
//	public ResponseEntity<List<OrderDetail>> validateShowAllOrderDetails(){
//		List<OrderDetailDTO> orderDetailDTOList = showAllOrderDetails();
//		if (orderDetailDTOList.size() == 0) {
//			throw new NotContentException(null);
//		}else {
//			List<OrderDetail> ordertDetailList = new ArrayList<OrderDetail>(); 
//			for (int i = 0; i < orderDetailDTOList.size(); i++) {
//				ordertDetailList.add(DataMapper.transformOrderDetailDTOToOrderDetail(orderDetailDTOList.get(i)));
//			}
//			return ResponseEntity.ok(ordertDetailList);		
//		}
//	}
	
	public ResponseEntity<String> validateExistingOrderDetail(EmbeddedIdOrderDetail id){
		if(!existOrderDetailById(id)) {
			throw new NotFoundException("El detalle de la orden proporcionada no está registrada");
		}
		return ResponseEntity.ok("El detalle de la orden proporcionada está registrada");
	}
	
	public String addDetails(List<OrderDetailDTO> orderDetails){
		for(OrderDetailDTO od : orderDetails) {
			createOrderDetail(od);
		}
		return orderDetails.size() + " detalles agregados con éxito";
	}
	
}
