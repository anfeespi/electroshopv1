package co.edu.unbosque.electroshopv1.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import co.edu.unbosque.electroshopv1.exception.CardNotValidException;
import co.edu.unbosque.electroshopv1.model.CardDTO;
import jakarta.validation.Valid;

@Service
public class CardService {

	public String validateCard(@Valid CardDTO card) {
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

		StringBuilder response = new StringBuilder();

		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		response.append("Creando compra a las: " + dateFormat.format(date) + "\n");

		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			date = new Date();
			response.append("Compra rechazada: " + dateFormat.format(date) + "\n");
			e.printStackTrace();
		}

		date = new Date();
		response.append("Compra aprobada: " + dateFormat.format(date) + "\n");

		return response.toString();
	}
}
