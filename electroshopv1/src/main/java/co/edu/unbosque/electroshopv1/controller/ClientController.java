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
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.electroshopv1.model.ClientDTO;
import co.edu.unbosque.electroshopv1.service.ClientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*")
@Transactional
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	public ClientController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/show")
	public ResponseEntity<List<ClientDTO>> showClients(){
		return ResponseEntity.ok(clientService.showAllClients());
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createClient(@Valid @RequestBody ClientDTO clientDTO){
		clientService.createClient(clientDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body("Creado con éxito");
	}
}
