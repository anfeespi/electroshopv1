package co.edu.unbosque.electroshopv1.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.electroshopv1.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{

}
