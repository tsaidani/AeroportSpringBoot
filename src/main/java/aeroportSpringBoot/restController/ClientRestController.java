package aeroportSpringBoot.restController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import aeroportSpringBoot.model.Client;
import aeroportSpringBoot.model.JsonViews;
import aeroportSpringBoot.repositories.ClientRepository;

@RestController
@RequestMapping("/rest/client")
public class ClientRestController {
	@Autowired
	ClientRepository clientRepository;

	@GetMapping(path = { "", "/" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<List<Client>> findAll() {
		return new ResponseEntity<>(clientRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = { "/reservation" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Client> findClientWithReservation(@PathVariable(name = "id") Integer id) {
		Optional<Client> opt = clientRepository.findClientWithReservation(id);
		ResponseEntity<Client> response = null;
		if (opt.isPresent()) {
			response = new ResponseEntity<Client>(opt.get(), HttpStatus.OK);
		} else {
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
			Optional<Client> opt = clientRepository.findById(client.getClientId());
			if (opt.isPresent()) {
				Client clientEnBase = opt.get();
				clientEnBase.setClientName(client.getClientName());
				clientEnBase.setMail(client.getMail());
				clientRepository.save(clientEnBase);
				response = new ResponseEntity<Client>(clientEnBase, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			}
		}
		return response;
	}

	@PostMapping(path = { "", "/" })
	public ResponseEntity<Void> createClient(@Valid @RequestBody Client client, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			clientRepository.save(client);
			HttpHeaders header = new HttpHeaders();

			header.setLocation(uCB.path("/rest/client/{id}").buildAndExpand(client.getClientId()).toUri());
			response = new ResponseEntity<>(header, HttpStatus.CREATED);

		}
		return response;
	}

	@GetMapping(value = "/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Client> findById(@PathVariable(name = "id") Integer id) {
		Optional<Client> opt = clientRepository.findById(id);
		ResponseEntity<Client> response = null;
		if (opt.isPresent()) {
			response = new ResponseEntity<Client>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
		Optional<Client> opt = clientRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			clientRepository.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
}