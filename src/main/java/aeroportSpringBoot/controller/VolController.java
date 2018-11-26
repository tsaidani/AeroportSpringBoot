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

import aeroportSpringBoot.model.Vol;
import aeroportSpringBoot.repositories.AeroportRepository;
import aeroportSpringBoot.repositories.ReservationRepository;
import aeroportSpringBoot.repositories.VolRepository;
import aeroportSpringBoot.service.AeroportService;
import aeroportSpringBoot.service.VolService;

@Controller
@RequestMapping("/vol")
public class VolController {

	@Autowired
	VolRepository volRepo;

	@Autowired
	AeroportService aeroService;	
	@Autowired
	AeroportRepository aeroRepo;

	@Autowired
	ReservationRepository resaRepo;
	@Autowired
	VolService volservice;

	@RequestMapping("")
	public ModelAndView home() {
		return new ModelAndView("redirect:/vol/");
	}

	@GetMapping("/")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("vol/listVol", "vols", volservice.showAll());
		return modelAndView;
	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name = "id", required = true) Integer id) {
		volservice.deleteVolById(id);
		return new ModelAndView("redirect:/vol/");
	}

	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam(name = "id", required = true) Integer id) {
		Vol vol = volservice.findById(id);
		return goEdit(vol);
	}

	@GetMapping("/addVol")
	public ModelAndView addVol() {
		return goEdit(new Vol());
	}

	
	@GetMapping("/reservations")
	public ModelAndView findResa(Vol vol) {
		ModelAndView modelAndView = new ModelAndView("vol/reservations", "reservations", volservice.showReservationByVol(vol.getIdVol())); 
		return modelAndView;
	}
	
	private ModelAndView goEdit(Vol vol) {
		ModelAndView modelAndView = new ModelAndView("vol/editVol", "vol", vol);
		modelAndView.addObject("aeroports", aeroService.findAllAeroports());
		modelAndView.addObject("reservations", volservice.showReservationByVol(vol.getIdVol()));
		return modelAndView;
	}

	@GetMapping("/saveVol")
	public ModelAndView saveVol(@Valid @ModelAttribute("vol") Vol vol, BindingResult br) {
		return save(vol, br);
	}

	private ModelAndView save(Vol vol, BindingResult br) {
		if (br.hasErrors()) {
			return goEdit(vol);
		}
		if (vol.getAeroportArrivee() != null && vol.getAeroportArrivee().getIdAeroport() == null) {
			vol.setAeroportArrivee(null);
		}
		if (vol.getAeroportDepart() != null && vol.getAeroportDepart().getIdAeroport()  == null) {
			vol.setAeroportDepart(null);
		} 
		volservice.saveVol(vol);

		return new ModelAndView("redirect:/vol/");
	}

}
