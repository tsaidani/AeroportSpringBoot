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
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import aeroportSpringBoot.model.Client;
import aeroportSpringBoot.model.JsonViews;
import aeroportSpringBoot.model.Passager;
import aeroportSpringBoot.model.Reservation;
import aeroportSpringBoot.model.Vol;
import aeroportSpringBoot.repositories.ReservationRepository;

public class ReservationRestController {
	@Autowired
	ReservationRepository reservationRepository;

	@GetMapping(path = { "", "/" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<List<Reservation>> findAll() {
		return new ResponseEntity<>(reservationRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = { "/reservation" })
	@JsonView(JsonViews.ReservationWithClient.class)
	public ResponseEntity<List<Reservation>> findReservationByClient(Client client) {
		return new ResponseEntity<>(reservationRepository.findByClient(client), HttpStatus.OK);
	}
	
	@GetMapping(path = { "/reservation" })
	@JsonView(JsonViews.ReservationWithVol.class)
	public ResponseEntity<List<Reservation>> findReservationByVol(Vol vol) {
		return new ResponseEntity<>(reservationRepository.findByVolId(vol.getIdVol()), HttpStatus.OK);
	}
	
	@GetMapping(path = { "/reservation" })
	@JsonView(JsonViews.ReservationWithPassager.class)
	public ResponseEntity<List<Reservation>> findReservationWithPassager(Passager passager) {
		return new ResponseEntity<>(reservationRepository.findByIdPassager(passager.getIdPassager()), HttpStatus.OK);
	}

	// Un objet validé (@Valid) demande un binding result)
	@PostMapping(path = { "", "/" })
	public ResponseEntity<Void> createReservation(@Valid @RequestBody Reservation reservation, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			reservationRepository.save(reservation);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/reservation/{id}").buildAndExpand(reservation.getNumeroReservation()).toUri());
			response = new ResponseEntity<>(header, HttpStatus.CREATED);
		}
		return response;
	}

	@GetMapping(value = "/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Reservation> findById(@PathVariable(name = "id") Integer id) {
		Optional<Reservation> opt = reservationRepository.findById(id);
		ResponseEntity<Reservation> response = null;
		if (opt.isPresent()) {
			response = new ResponseEntity<Reservation>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@PutMapping(path = { "", "/" })
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Reservation> update(@Valid @RequestBody Reservation reservation, BindingResult br) {
		ResponseEntity<Reservation> response = null;

		if (br.hasErrors() || reservation.getNumeroReservation() == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		} else {
			Optional<Reservation> opt = reservationRepository.findById(reservation.getNumeroReservation());
			if (opt.isPresent()) {
				Reservation reservationEnBase = opt.get();
				reservationEnBase.setNumeroReservation(reservation.getNumeroReservation());
				reservationRepository.save(reservationEnBase);
				response = new ResponseEntity<Reservation>(reservationEnBase, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			}
		}

		return response;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
		Optional<Reservation> opt = reservationRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			reservationRepository.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}


}
