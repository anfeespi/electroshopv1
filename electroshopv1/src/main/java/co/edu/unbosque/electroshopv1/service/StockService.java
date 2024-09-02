package co.edu.unbosque.electroshopv1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.edu.unbosque.electroshopv1.exception.NotContentException;
import co.edu.unbosque.electroshopv1.exception.NotCreateException;
import co.edu.unbosque.electroshopv1.exception.NotFoundException;
import co.edu.unbosque.electroshopv1.model.Stock;
import co.edu.unbosque.electroshopv1.model.StockDTO;
import co.edu.unbosque.electroshopv1.repository.StockRepository;

@Service
public class StockService {
	@Autowired
	private StockRepository stockRepository;

	public StockService() {
	}
	
	public boolean createStock(StockDTO stockDTO) {
		stockRepository.save(DataMapper.transformStockDTOToStock(stockDTO));
		return true;
	}

	public List<StockDTO> showAllStock() {
		List<Stock> stockList = (List<Stock>)stockRepository.findAll();
		List<StockDTO> stockDTOList = new ArrayList<StockDTO>(); 
		for (int i = 0; i < stockList.size(); i++) {
			stockDTOList.add(DataMapper.transformStockToStockDTO(stockList.get(i)));
		}
		return stockDTOList;
	}

	public boolean existStockById(Integer id) {
		return stockRepository.existsById(id);
	}

	public StockDTO getStockById(Integer id) {
		return DataMapper.transformStockToStockDTO(stockRepository.findById(id).get());
	}
	
	
	public ResponseEntity<String> validateCreateStock(StockDTO stockDTO) {
		if(createStock(stockDTO)){
			throw new NotCreateException("Stock creado con éxito");
		}
		return ResponseEntity.ok("El código del stock está duplicado");
	}
	
	public ResponseEntity<List<Stock>> validateShowAllProducts(){
		List<StockDTO> stockDTOList = showAllStock();
		if (stockDTOList.size() == 0) {
			throw new NotContentException(null);
		}else {
			List<Stock> stockList = new ArrayList<Stock>(); 
			for (int i = 0; i < stockDTOList.size(); i++) {
				stockList.add(DataMapper.transformStockDTOToStock(stockDTOList.get(i)));
			}
			return ResponseEntity.ok(stockList);
		}
	}
	
	public ResponseEntity<String> validateExistingStock(Integer id){
		if(!existStockById(id)) {
			throw new NotFoundException("El stock solicitado no está registrado");
		}
		return ResponseEntity.ok("El stock solicitado está registrado");
	}
}
