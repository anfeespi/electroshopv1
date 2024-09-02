package co.edu.unbosque.electroshopv1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.electroshopv1.service.ClientService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "*")
@Transactional
public class TestController {
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/showClients")
	public ResponseEntity<?> showClients(){
		return ResponseEntity.ok(clientService.showAllClients());
	}
}
