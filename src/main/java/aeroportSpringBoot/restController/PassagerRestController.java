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

import aeroportSpringBoot.model.JsonViews;
import aeroportSpringBoot.model.Passager;
import aeroportSpringBoot.repositories.PassagerRepository;

@RestController
@RequestMapping("/rest/Passager")
public class PassagerRestController {

	@Autowired
	PassagerRepository passagerRepository;

	@GetMapping(path = { "", "/" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<List<Passager>> findAll() {
		return new ResponseEntity<>(passagerRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(path = { "", "/" })
	public ResponseEntity<Void> createPassager(@Valid @RequestBody Passager passager, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			passagerRepository.save(passager);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(
					uCB.path("/rest/passager/{id}").buildAndExpand(passager.getIdPassager()).toUri());
			response = new ResponseEntity<>(header, HttpStatus.CREATED); // on renvoit l'adresse de ce qu'on a crée
		}
		return response;
	}

	@GetMapping(value = "/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Passager> findById(@PathVariable(name = "id") Integer id) {
		Optional<Passager> opt = passagerRepository.findById(id);
		ResponseEntity<Passager> response = null;
		if (opt.isPresent()) {
			response = new ResponseEntity<Passager>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;

	}

	@PutMapping({ "", "/" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Passager> update(@Valid @RequestBody Passager passager, BindingResult br) {
		ResponseEntity<Passager> response = null;
		if (br.hasErrors() || passager.getIdPassager() == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		} else {
			Optional<Passager> opt = passagerRepository.findById(passager.getIdPassager());
			if (opt.isPresent()) {
				Passager passagerEnBase = opt.get();
				passagerEnBase.setIdPassager(passager.getIdPassager());
				passagerRepository.save(passagerEnBase);
				response = new ResponseEntity<Passager>(passagerEnBase, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			}
		}
		return response;

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
		Optional<Passager> opt = passagerRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			passagerRepository.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
		return response;
	}
}
