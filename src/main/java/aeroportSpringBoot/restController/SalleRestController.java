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

import com.example.demo.model.JsonViews;
import com.example.demo.model.Salle;
import com.example.demo.repositories.SalleRepository;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/rest/salle")
public class SalleRestController {

	@Autowired
	SalleRepository salleRepository;

	@GetMapping(path = { "", "/" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<List<Salle>> findAll() {
		return new ResponseEntity<>(salleRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = { "/personne" })
	@JsonView(JsonViews.SalleWithPersonnes.class)
	public ResponseEntity<List<Salle>> findAllListPersonne() {
		return new ResponseEntity<>(salleRepository.findAlldWithPersonnes(), HttpStatus.OK);
	}

	// Un objet validé (@Valid) demande un binding result)
	@PostMapping(path = { "", "/" })
	public ResponseEntity<Void> createSalle(@Valid @RequestBody Salle salle, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			salleRepository.save(salle);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/salle/{id}").buildAndExpand(salle.getNumero()).toUri());
			response = new ResponseEntity<>(header, HttpStatus.CREATED);
		}
		return response;
	}

	@GetMapping(value = "/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Salle> findById(@PathVariable(name = "id") Integer id) {
		Optional<Salle> opt = salleRepository.findById(id);
		ResponseEntity<Salle> response = null;
		if (opt.isPresent()) {
			response = new ResponseEntity<Salle>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@PutMapping(path = { "", "/" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Salle> update(@Valid @RequestBody Salle salle, BindingResult br) {
		ResponseEntity<Salle> response = null;

		if (br.hasErrors() || salle.getNumero() == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		} else {
			Optional<Salle> opt = salleRepository.findById(salle.getNumero());
			if (opt.isPresent()) {
				Salle salleEnBase = opt.get();
				salleEnBase.setNom(salle.getNom());
				salleRepository.save(salleEnBase);
				response = new ResponseEntity<Salle>(salleEnBase, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			}
		}

		return response;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
		Optional<Salle> opt = salleRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			salleRepository.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

}
