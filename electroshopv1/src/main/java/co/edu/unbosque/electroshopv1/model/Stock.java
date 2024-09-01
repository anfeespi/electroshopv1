package co.edu.unbosque.electroshopv1.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventarios")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_stock")
	private Integer stockId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
	private Product product;
	
	@Column(name = "cantidad_stock")
	private Integer stock;
}
