package co.edu.unbosque.electroshopv1.service;

import co.edu.unbosque.electroshopv1.model.Client;
import co.edu.unbosque.electroshopv1.model.ClientDTO;
import co.edu.unbosque.electroshopv1.model.Order;
import co.edu.unbosque.electroshopv1.model.OrderDTO;
import co.edu.unbosque.electroshopv1.model.OrderDetail;
import co.edu.unbosque.electroshopv1.model.OrderDetailDTO;
import co.edu.unbosque.electroshopv1.model.Product;
import co.edu.unbosque.electroshopv1.model.ProductDTO;
import co.edu.unbosque.electroshopv1.model.Stock;
import co.edu.unbosque.electroshopv1.model.StockDTO;

public class Transformation {
	
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
		orderDTO.setClientDTO(transformClientToClientDTO(order.getClient()));
		orderDTO.setPaymentMethod(order.getPaymentMethod());
		orderDTO.setTotalValue(order.getTotalValue());
		return orderDTO;
	}
	
	public static Order transformOrderDTOToOrder(OrderDTO orderDTO) {
		Order order = new Order();
		order.setOrderId(orderDTO.getOrderId());
		order.setClient(transformClientDTOToClient(orderDTO.getClientDTO()));
		order.setPaymentMethod(orderDTO.getPaymentMethod());
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
		orderDetailDTO.setOrder(transformOrderToOrderDTO(orderDetail.getOrderDetailId().getOrder()));
		orderDetailDTO.setProduct(transformProductToProductDTO(orderDetail.getOrderDetailId().getProduct()));
		orderDetailDTO.setQuantity(orderDetail.getQuantity());
		return orderDetailDTO;
	}
	
	public static OrderDetail transformOrderDetailDTOToOrderDetail(OrderDetailDTO orderDetailDTO) {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.getOrderDetailId().setOrder(transformOrderDTOToOrder(orderDetailDTO.getOrder()));
		orderDetail.getOrderDetailId().setProduct(transformProductDTOToProduct(orderDetailDTO.getProduct()));
		orderDetail.setQuantity(orderDetailDTO.getQuantity());
		return orderDetail;
	}

}
