package co.edu.unbosque.electroshopv1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.electroshopv1.model.ProductDTO;
import co.edu.unbosque.electroshopv1.model.StockDTO;
import co.edu.unbosque.electroshopv1.service.ProductService;
import co.edu.unbosque.electroshopv1.service.StockService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
@Transactional
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private StockService stockService;
	
	public ProductController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/showAll")
	public ResponseEntity<List<ProductDTO>> showAll(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.showAllProducts());
	}
	
	@GetMapping("/showAllStock")
	public ResponseEntity<List<StockDTO>> showAllStock(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(stockService.showAllStock());
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createProduct( @Valid @RequestBody ProductDTO productDTO){
		productService.createProduct(productDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body("Creao");
	}
	
	@GetMapping("/getById")
	public ResponseEntity<ProductDTO> getById(@RequestParam Integer id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.getProductById(id));
	}
}
