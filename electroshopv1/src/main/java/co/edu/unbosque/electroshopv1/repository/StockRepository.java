package co.edu.unbosque.electroshopv1.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.electroshopv1.model.Stock;

public interface StockRepository extends CrudRepository<Stock, Integer>{

}
