package aeroportSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import aeroportSpringBoot.service.ClientService;

@Controller
@RequestMapping("/connexion")
public class loginController {

	
	
		@Autowired
		ClientService clientService;

	@RequestMapping("")
	public ModelAndView home() {
		return new ModelAndView("redirect:/connexion/");
	}

	@GetMapping("/")
	public ModelAndView listClients() {
		ModelAndView modelAndView = new ModelAndView("/connexion/Connexion", "clients", clientService.findAllClients());
		return modelAndView;
	}

//	private boolean verification(Client client) {
//		// Verifier si les infos existent dans la base
//		Client c = clientService.findClientByName(client.getClientName());
//		if ( c && c.getClientId() == client.getClientName() && c.getMdp== client.getMdp  ) {
//			return true;
//		} else {
//			return false;
//		} 	 
//	}
//	  
 
	
	
	 

}
