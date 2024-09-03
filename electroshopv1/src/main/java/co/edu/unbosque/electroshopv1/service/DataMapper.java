package co.edu.unbosque.electroshopv1.service;

import co.edu.unbosque.electroshopv1.model.Client;
import co.edu.unbosque.electroshopv1.model.ClientDTO;
import co.edu.unbosque.electroshopv1.model.EmbeddedIdOrderDetail;
import co.edu.unbosque.electroshopv1.model.Order;
import co.edu.unbosque.electroshopv1.model.OrderDTO;
import co.edu.unbosque.electroshopv1.model.OrderDetail;
import co.edu.unbosque.electroshopv1.model.OrderDetailDTO;
import co.edu.unbosque.electroshopv1.model.PaymentMethod;
import co.edu.unbosque.electroshopv1.model.Product;
import co.edu.unbosque.electroshopv1.model.ProductDTO;
import co.edu.unbosque.electroshopv1.model.Stock;
import co.edu.unbosque.electroshopv1.model.StockDTO;

public class DataMapper {	
	public static ClientDTO transformClientToClientDTO(Client client) {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setClientId(client.getClientId());
		clientDTO.setName(client.getName());
		clientDTO.setAge(client.getAge());
		clientDTO.setAddress(client.getAddress());
		return clientDTO;
	}
	
	public static Client transformClientDTOToClient(ClientDTO clienteDTO) {
		Client client = new Client();
		client.setClientId(clienteDTO.getClientId());
		client.setName(clienteDTO.getName());
		client.setAge(clienteDTO.getAge());
		client.setAddress(clienteDTO.getAddress());
		return client;
	}
	
	public static OrderDTO transformOrderToOrderDTO(Order order) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderId(order.getOrderId());
		orderDTO.setClientDTO(order.getClient().getClientId());
		orderDTO.setPaymentMethod(order.getPaymentMethod());
		orderDTO.setTotalValue(order.getTotalValue());
		return orderDTO;
	}
	
	public static Order transformOrderDTOToOrder(OrderDTO orderDTO, Client client, PaymentMethod paymentMethod) {
		Order order = new Order();
		order.setOrderId(orderDTO.getOrderId());
		order.setClient(client);
		order.setPaymentMethod(paymentMethod);
		order.setTotalValue(orderDTO.getTotalValue());
		return order;
	}
	 
	public static ProductDTO transformProductToProductDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(product.getProductId());
		productDTO.setName(product.getName());
		productDTO.setValue(product.getValue());
		productDTO.setCategory(product.getCategory());
		return productDTO;
	}
	
	public static Product transformProductDTOToProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setProductId(productDTO.getProductId());
		product.setName(productDTO.getName());
		product.setValue(productDTO.getValue());
		product.setCategory(productDTO.getCategory());
		return product;
	}
	
	public static StockDTO transformStockToStockDTO(Stock stock) {
		StockDTO stockDTO = new StockDTO();
		stockDTO.setStockId(stock.getStockId());
		stockDTO.setProduct(transformProductToProductDTO(stock.getProduct()));
		stockDTO.setStock(stock.getStock());
		return stockDTO;
	}
	
	public static Stock transformStockDTOToStock(StockDTO stockDTO) {
		Stock stock = new Stock();
		stock.setStockId(stockDTO.getStockId());
		stock.setProduct(transformProductDTOToProduct(stockDTO.getProduct()));
		stock.setStock(stockDTO.getStock());
		return stock;
	}
	
	public static OrderDetailDTO transformOrderDetailToOrderTailDTO(OrderDetail orderDetail) {
		OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
		orderDetailDTO.setOrder(orderDetail.getOrderDetailId().getOrder().getOrderId());
		orderDetailDTO.setProduct(orderDetail.getOrderDetailId().getProduct().getProductId());
		orderDetailDTO.setQuantity(orderDetail.getQuantity());
		return orderDetailDTO;
	}
	
	public static OrderDetail transformOrderDetailDTOToOrderDetail(OrderDetailDTO orderDetailDTO, Order order, Product product) {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderDetailId(new EmbeddedIdOrderDetail());
		orderDetail.getOrderDetailId().setOrder(order);
		orderDetail.getOrderDetailId().setProduct(product);
		orderDetail.setQuantity(orderDetailDTO.getQuantity());
		return orderDetail;
	}

}
