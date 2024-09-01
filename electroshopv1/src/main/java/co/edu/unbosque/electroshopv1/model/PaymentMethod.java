package co.edu.unbosque.electroshopv1.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "metodos_pago")
public class PaymentMethod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_met_pago")
	private Integer methodId;
	
	@Column(name = "nom_metodo_pago", length = 50)
	private String name;
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentMethod", cascade = CascadeType.ALL)
	private Set<Order> orders;

	public PaymentMethod() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 */
	public PaymentMethod(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the methodId
	 */
	public Integer getMethodId() {
		return methodId;
	}

	/**
	 * @param methodId the methodId to set
	 */
	public void setMethodId(Integer methodId) {
		this.methodId = methodId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
