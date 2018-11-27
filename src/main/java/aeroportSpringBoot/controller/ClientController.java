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

import aeroportSpringBoot.model.Client;
import aeroportSpringBoot.model.ClientEl;
import aeroportSpringBoot.model.ClientMoral;
import aeroportSpringBoot.model.ClientPhysique;
import aeroportSpringBoot.service.ClientService;
import aeroportSpringBoot.service.ReservationService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("")
	public ModelAndView home() {
		return new ModelAndView("redirect:/client/");
	}

	@GetMapping("/")
	public ModelAndView listClients() {
		ModelAndView modelAndView = new ModelAndView("/client/listClient", "clients", clientService.findAllClients());
		return modelAndView;

	}
	
	@GetMapping("/reservations")
	public ModelAndView reservations(@RequestParam(name = "clientId", required = true) Integer clientId) {
		ModelAndView modelAndView = new ModelAndView("reservations/listReservation", "reservations", reservationService.showReservationByIdClient(clientId)); 
		return modelAndView;
	}
;
	
	@GetMapping("/deleteClient")
	public ModelAndView delete(@RequestParam(name = "clientId", required = true) Integer clientId) {
		clientService.deleteClientById(clientId);
		return new ModelAndView("redirect:/client/");
	}
	
	@GetMapping("/addClientPhy")
	public ModelAndView addPhy() {
		return goEdit(new ClientPhysique());
		
	}
	
	@GetMapping("/addClientMoral")
	public ModelAndView addMoral() {
			return goEdit(new ClientMoral());
		
	}
	@GetMapping("/addClientEl")
	public ModelAndView addEl(Client client) {
			return goEdit(new ClientEl());
		
	}
	@GetMapping("/editClient")
	public ModelAndView edit(@RequestParam(name = "clientId", required = true) Integer clientId) {
		Client c= clientService.findClientWithReservation(clientId);
		return goEdit(c);

	}
	@GetMapping("/saveClientPhy")
	public ModelAndView saveClient(@Valid @ModelAttribute("client") ClientPhysique client, BindingResult br) {
		return save(client,br);
	}
	@GetMapping("/saveClientMoral")
	public ModelAndView saveClient(@Valid @ModelAttribute("client") ClientMoral client, BindingResult br) {
		return save(client,br);
	}
	@GetMapping("/saveClientEl")
	public ModelAndView saveClient(@Valid @ModelAttribute("client") ClientEl client, BindingResult br) {
		return save(client,br);
	}
	
	private ModelAndView goEdit(Client c) {
		ModelAndView modelAndView = new ModelAndView("client/editClient", "client", c);
		modelAndView.addObject("reservations",reservationService.showAll());
		return modelAndView;
	}
	
	private ModelAndView save(Client c,BindingResult br) {
		if (br.hasErrors()) {
			return goEdit(c);
		}
		if(c.getReservations()!=null && c.getReservations().isEmpty()) {
			c.setReservations(null);
		}
		clientService.createClient(c);
		return new ModelAndView("redirect:/client/");
	}
}
