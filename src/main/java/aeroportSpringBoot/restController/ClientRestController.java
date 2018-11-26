package aeroportSpringBoot.restController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import aeroportSpringBoot.model.Client;
import aeroportSpringBoot.model.JsonViews;
import aeroportSpringBoot.model.Passager;
import aeroportSpringBoot.model.Reservation;
import aeroportSpringBoot.repositories.ClientRepository;
import aeroportSpringBoot.service.ClientService;

@RestController
@RequestMapping("/rest/client")
public class ClientRestController {
	@Autowired
	ClientRepository clientRepository;
	ClientService clientService;
	@GetMapping(path = { "", "/" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<List<Client>> findAll() {
		return new ResponseEntity<>(clientService.findAllClients(), HttpStatus.OK);
	}
	
	@GetMapping(path= {"/reservation"})
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Client> findClientWithReservation(@PathVariable(name = "id") Integer id) {
		Client client = clientService.findClientWithReservation(id);
		ResponseEntity<Client> response = null;
		if (client!=null) {
			response = new ResponseEntity<Client>(client, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@GetMapping(path = { "/passager" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Map<Reservation, Passager>> findClientsWithPassagers(@PathVariable(name = "id") Integer id) {
		Map<Reservation, Passager> clientMap=clientService.showClientsWithPassagers(id);
		ResponseEntity<Map<Reservation, Passager>> response = null;
		if (clientMap!=null) {
			response = new ResponseEntity<Map<Reservation, Passager>>(clientMap, HttpStatus.OK);
		}else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "", "/" })
	public ResponseEntity<Client> update(@Valid @RequestBody Client client, BindingResult br) {
		ResponseEntity<Client> response = null;

		if (br.hasErrors() || client.getClientId() == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		} else {
			Client clientEnBase = clientService.findClientById(client.getClientId());
			if (clientEnBase!=null) {
				clientEnBase.setClientName(client.getClientName());
				clientEnBase.setMail(client.getMail());
				clientRepository.save(clientEnBase);
				response=new ResponseEntity<Client>(clientEnBase,HttpStatus.OK);
			}else {
				response=new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			}
		}
			return response;
		}
}
