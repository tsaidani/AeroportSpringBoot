package aeroportSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/accueil")
public class AccueilController {

	@RequestMapping("")
	public ModelAndView home() {
		return new ModelAndView("redirect:/accueil/");
	}
	
	@GetMapping("/")
	public String pageAccueil() {
		return "accueil/accueil";
	}
	@GetMapping("/NavBar") 
	public String navBar() { 
	return "redirect:/static/NavBar.html"; 
	}
//	public String loadImg() {
//		return "accueil/boeing-avion.jpg";
//	}
}
