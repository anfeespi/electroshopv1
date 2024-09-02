package co.edu.unbosque.electroshopv1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.edu.unbosque.electroshopv1.exception.NotContentException;
import co.edu.unbosque.electroshopv1.exception.NotCreateException;
import co.edu.unbosque.electroshopv1.exception.NotFoundException;
import co.edu.unbosque.electroshopv1.model.Product;
import co.edu.unbosque.electroshopv1.model.ProductDTO;
import co.edu.unbosque.electroshopv1.repository.ProductRepository;

@Service
public class ProductService {


	private ProductRepository productRepository;

	public ProductService() {

	}

	public boolean createProduct(ProductDTO productDTO) {
		productRepository.save(Transformation.transformProductDTOToProduct(productDTO));
		return true;
	}

	public List<ProductDTO> showAllProducts() {
		List<Product> productList = (List<Product>)productRepository.findAll();
		List<ProductDTO> productDTOList = new ArrayList<ProductDTO>(); 
		for (int i = 0; i < productList.size(); i++) {
			productDTOList.add(Transformation.transformProductToProductDTO(productList.get(i)));
		}
		return productDTOList;
	}

	public boolean existProductById(Integer id) {
		return productRepository.existsById(id);
	}

	public ProductDTO getProductById(Integer id) {		
		return Transformation.transformProductToProductDTO(productRepository.findById(id).get());
	}
	
	
	public ResponseEntity<String> validateCreateProduct(ProductDTO productDTO) {
		if(createProduct(productDTO)){
			throw new NotCreateException("Producto creado con éxito");
		}
		return ResponseEntity.ok("El código del producto está duplicado");
	}
	
	public ResponseEntity<List<Product>> validateShowAllProducts(){
		List<ProductDTO> productDTOList = showAllProducts();
		if (productDTOList.size() == 0) {
			throw new NotContentException(null);
		}else {
			List<Product> productList = new ArrayList<Product>(); 
			for (int i = 0; i < productDTOList.size(); i++) {
				productList.add(Transformation.transformProductDTOToProduct(productDTOList.get(i)));
			}
			return ResponseEntity.ok(productList);
		}
	}
	
	public ResponseEntity<String> validateExistingProduct(Integer id){
		if(!existProductById(id)) {
			throw new NotFoundException("El producto solicitado no está registrado");
		}
		return ResponseEntity.ok("El producto solicitado está registrado");
	}
	
	
	
}
