package aeroportSpringBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import aeroportSpringBoot.model.Passager;
import aeroportSpringBoot.service.PassagerService;
import aeroportSpringBoot.service.ReservationService;

@Controller
@RequestMapping("/passager")
public class PassagerController {

	@Autowired
	private PassagerService passagerService;
	
	@Autowired
	private ReservationService reservationService;

	@RequestMapping("")
	public ModelAndView homePassager() {
		return new ModelAndView("redirect:/passager/");
	}

	@GetMapping("/")
	public ModelAndView listPassager() {
		ModelAndView modelAndView = new ModelAndView("passager/listPassager", "passagers",
				passagerService.findAllPassagers());
		return modelAndView;
	}

	@GetMapping("/delete")
	public ModelAndView deletePassager(@RequestParam(name = "idPassager", required = true) Integer idPassager) {
		passagerService.deletePassagerById(idPassager);
		return new ModelAndView("redirect:/passager/");
	}

	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam(name = "idPassager", required = true) Integer idPassager) {
		Passager passager = passagerService.findPassagerById(idPassager);
		return goEditPassager(passager);
	}

	@GetMapping("/addPassager")
	public ModelAndView addPassager() {
		return goEditPassager(new Passager());
	}

	@PostMapping("/savePassager")
	public ModelAndView savePassager(@Valid @ModelAttribute("passager") Passager passager, BindingResult br) {
		return save(passager, br);
	}

	private ModelAndView goEditPassager(Passager passager) {
		ModelAndView modelAndView = new ModelAndView("passager/editPassager", "passager", passager);
		modelAndView.addObject("reservations", reservationService.showReservationByIdPassager(passager.getIdPassager()));
		return modelAndView;
	}

	private ModelAndView save(Passager passager, BindingResult br) {
		if (br.hasErrors()) {
			return goEditPassager(passager);
		}
		passagerService.save(passager);
		return new ModelAndView("redirect:/passager/");
	}

}
