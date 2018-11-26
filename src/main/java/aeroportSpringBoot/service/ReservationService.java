package aeroportSpringBoot.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeroportSpringBoot.model.Client;
import aeroportSpringBoot.model.Passager;
import aeroportSpringBoot.model.Reservation;
import aeroportSpringBoot.model.Vol;
import aeroportSpringBoot.repositories.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	public void createReservation(Client client, Passager passager, Vol vol) {
		if ((client != null) & (passager != null) & (vol != null)) {
			Reservation reservation = new Reservation();
			Date now = new Date();
			reservation.setDateReservation(now);
			reservation.setClient(client);
			reservation.setPassager(passager);
			reservation.setVol(vol);
			reservationRepository.save(reservation);
		}

	}

	public void deleteReservation(Integer numeroReservation) {
		reservationRepository.deleteById(numeroReservation);
	}

	public void deleteReservationByVol(Integer idVol) {
		List<Reservation> list = reservationRepository.findByVolId(idVol);
		for (Reservation r : list) {
			System.out.println(r);
			reservationRepository.deleteById(r.getNumeroReservation());

		}
	}

	public List<Reservation> showAll() {
		List<Reservation> reservations = reservationRepository.findAll();
		return reservations;
	}

	public void modifyReservation(Integer numeroReservation) {
		Optional<Reservation> opt = reservationRepository.findById(numeroReservation);
		Reservation reservation = null;
		if (opt.isPresent()) {
			reservation = opt.get();
			reservationRepository.save(reservation);
		}
	}

	public Reservation showReservation(Integer numeroReservation) {
		Optional<Reservation> opt = reservationRepository.findById(numeroReservation);
		Reservation reservation = null;
		if (opt.isPresent()) {
			reservation = opt.get();
		}
		return reservation;
	}

	public List<Reservation> showReservationByVol(Integer idVol) {
		List<Reservation> list = reservationRepository.findByVolId(idVol);
		return list;
	}

	public List<Reservation> showReservationByClient(Client client) {
		List<Reservation> reservation = reservationRepository.findByClient(client);
		return reservation;
	}

	public List<Reservation> showReservationByNomClient(String nom) {
		List<Reservation> reservations = reservationRepository.findByNomClient(nom);
		return reservations;
	}

	public List<Reservation> showReservationByNomPassager(String nom) {
		List<Reservation> reservations = reservationRepository.findByNomPassager(nom);
		return reservations;
	}
	

	public List<Reservation> showReservationByIdPassager(Integer id) {
		List<Reservation> reservations = reservationRepository.findByIdPassager(id);
		return reservations;
	}

	public List<Reservation> showReservationByPassager(Passager passager) {
		List<Reservation> reservation = reservationRepository.findByPassager(passager);
		return reservation;
	}

	public void createReservation(Reservation reservation) {
		if (reservation != null) {
		reservationRepository.save(reservation);
		}
	}

}
