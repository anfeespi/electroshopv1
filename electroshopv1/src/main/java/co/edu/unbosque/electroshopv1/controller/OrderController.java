package co.edu.unbosque.electroshopv1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.electroshopv1.exception.CardNotValidException;
import co.edu.unbosque.electroshopv1.model.CardDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
@Transactional
public class OrderController {

	public OrderController() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/validateCard")
	public ResponseEntity<String> validateCard(@Valid @RequestBody CardDTO card) {
		/**
		 * Validar el numero
		 */
		if (!card.getNumber().replace("-", "").replace(".", "").replace(" ", "").replace("/", "").replace("\\", "")
				.matches("\\d+"))
			throw new CardNotValidException("Hay caracteres en la tarjeta");

		if (card.getNumber().replace("-", "").replace(".", "").replace(" ", "").replace("/", "").replace("\\", "")
				.length() != 16)
			throw new CardNotValidException("Número de tarjeta no válido");

		/**
		 * Validar la fecha de expiracion
		 */
		if (!card.getExpiration().replace("-", "").replace(".", "").replace(" ", "").replace("/", "").replace("\\", "")
				.matches("\\d+"))
			throw new CardNotValidException("Hay caracteres en la expiración");
		;

		/**
		 * Validar el cvc
		 */
		if (!card.getCvc().matches("[0-9]+"))
			throw new CardNotValidException("Hay caracteres en el cvc");
		;

		return ResponseEntity.ok("La tarjeta es válida");
	}
}
