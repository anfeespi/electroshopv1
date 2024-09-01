package co.edu.unbosque.electroshopv1.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.electroshopv1.model.EmbeddedIdOrderDetail;
import co.edu.unbosque.electroshopv1.model.OrderDetail;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, EmbeddedIdOrderDetail>{

}
