package co.edu.unbosque.electroshopv1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.edu.unbosque.electroshopv1.exception.NotContentException;
import co.edu.unbosque.electroshopv1.exception.NotCreateException;
import co.edu.unbosque.electroshopv1.exception.NotFoundException;
import co.edu.unbosque.electroshopv1.model.Client;
import co.edu.unbosque.electroshopv1.model.ClientDTO;

import co.edu.unbosque.electroshopv1.repository.ClientRepository;

@Service
public class ClientService {

	private ClientRepository clientRepository;
	

	public ClientService() {
	}
	
	public boolean createClient(ClientDTO clientDTO) {
		clientRepository.save(Transformation.transformClientDTOToClient(clientDTO));
		return true;
	}
	
	public List<ClientDTO> showAllClients() {
		List<Client> clientList = (List<Client>)clientRepository.findAll();
		List<ClientDTO> clientDTOList = new ArrayList<ClientDTO>(); 
		for (int i = 0; i < clientList.size(); i++) {
			clientDTOList.add(Transformation.transformClientToClientDTO(clientList.get(i)));
		}
		return clientDTOList;
	}


	public boolean existClientById(String id) {
		return clientRepository.existsById(id);
	}

	public ClientDTO getClientById(String id) {
		return Transformation.transformClientToClientDTO(clientRepository.findById(id).get());
	}
	
	
	
	
	
	public ResponseEntity<String> validateCreateClient(ClientDTO clientDTO) {
		if(createClient(clientDTO)){
			throw new NotCreateException("Cliente creado con éxito");
		}
		return ResponseEntity.ok("El cliente está duplicado");
	}
	
	public ResponseEntity<List<Client>> validateShowAllClients(){
		List<ClientDTO> clientDTOList = showAllClients();
		if (clientDTOList.size() == 0) {
			throw new NotContentException(null);
		}else {
			List<Client> clientList = new ArrayList<Client>(); 
			for (int i = 0; i < clientDTOList.size(); i++) {
				clientList.add(Transformation.transformClientDTOToClient(clientDTOList.get(i)));
			}
			return ResponseEntity.ok(clientList);
		}
	}
	
	public ResponseEntity<String> validateExistingClient(String id){
		if(!existClientById(id)) {
			throw new NotFoundException("El cliente solicitado no está registrado");
		}
		return ResponseEntity.ok("El cliente solicitado está registrado");
	}
	
}
