package aeroportSpringBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import aeroportSpringBoot.model.Reservation;
import aeroportSpringBoot.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

//	@Autowired
//	private PassagerService passagerService;
//
//	@Autowired
//	private ClientService clientService;

	@RequestMapping("")
	public ModelAndView home() {
		return new ModelAndView("redirect:/reservation/");
	}

	@GetMapping("/")
	public ModelAndView listReservation() {
		ModelAndView modelAndView = new ModelAndView("reservations/listReservation", "reservations",
				reservationService.showAll());
		return modelAndView;
	}

	@GetMapping("/deleteReservation")
	public ModelAndView deleteReservation(
			@RequestParam(name = "numeroReservation", required = true) Integer numeroReservation) {
		reservationService.deleteReservation(numeroReservation);
		return new ModelAndView("redirect:/reservation/");
	}

	@GetMapping("/editReservation")
	public ModelAndView editReservation(
			@RequestParam(name = "numeroReservation", required = true) Integer numeroReservation) {
		
		Reservation reservation = reservationService.showReservation(numeroReservation);
		return goEditReservation(reservation);
	}

	@GetMapping("/addReservation")
	public ModelAndView addReservation() {
		return goEditReservation(new Reservation());
	}

	private ModelAndView goEditReservation(Reservation reservation) {
			ModelAndView modelAndView = new ModelAndView("reservations/editReservation", "reservation", reservation);
//			modelAndView.addObject("passager", passagerService.findPassagerById(idPassager));
//			modelAndView.addObject("client", clientService.);
			return modelAndView;
		}

	@GetMapping("/saveReservation")
	public ModelAndView saveReservation(@Valid @ModelAttribute("reservation") Reservation reservation,
			BindingResult result) {
		if (result.hasErrors()) {
			return goEditReservation(reservation);
		}
		reservationService.createReservation(reservation);
		return new ModelAndView("redirect:/reservation/");
	}
}
