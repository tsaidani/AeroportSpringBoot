package aeroportSpringBoot.restController;

import java.util.List;

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
import aeroportSpringBoot.model.Vol;
import aeroportSpringBoot.service.VolService;

@RestController
@RequestMapping("/rest/vol")
public class VolRestController {
//
//	@Autowired
//	VolService volService;	 
//	
//	@GetMapping(path= {"", "/"})
//	@JsonView(JsonViews.Common.class)
//	public ResponseEntity<List<Vol>> findAll() {
//		// Ttes les salles de la bdd sous format Json
//		return new ResponseEntity<>(volService.showAll(),HttpStatus.OK); 
//	}
//	
//
//	@GetMapping(path= {"/vol"})
//	@JsonView(JsonViews.VolsWithReservation.class)
//	public ResponseEntity<List<Vol>> findAllWithReservation() {
//		// Ttes les salles de la bdd sous format Json
//		return new ResponseEntity<>(volService.findAllWithReservation() , HttpStatus.OK); 
//	}
//	@GetMapping(value="/reservations/{id}")
//	@JsonView(JsonViews.VolsWithReservation.class)
//	public ResponseEntity<Vol> findByIdWithReservation(@PathVariable(name="id") Integer id) {
//		Vol opt= volService.findVolWithReservation(id);
//		ResponseEntity<Vol> response = null;
//		if(opt !=null) { 
//			response = new ResponseEntity<Vol> (opt, HttpStatus.OK);
//		} else { 
//			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//			return response;
//	}
//
////	// Un objet validé (@Valid) demande un binding result)
//	@PostMapping(path= {"", "/"})
//	public ResponseEntity<Void> createVol(@Valid @RequestBody Vol vol, BindingResult br, UriComponentsBuilder uCB) {
//		ResponseEntity<Void> response = null;
//		if(br.hasErrors()) {
//			response =new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}else {
//			volService.saveVol(vol);
//			HttpHeaders header = new HttpHeaders(); 
//			header.setLocation(uCB.path("/rest/vol/{id}").buildAndExpand(vol.getIdVol()).toUri() );
//			response = new ResponseEntity<>(header,HttpStatus.CREATED); 
//		} 
//		return response;
//	}
// 
//
//	// Un objet validé (@Valid) demande un binding result)
//	@PostMapping(path= {"", "/"})
//	public ResponseEntity<Void> createSalle(@Valid @RequestBody Vol vol, BindingResult br, UriComponentsBuilder uCB) {
//		ResponseEntity<Void> response = null;
//		if(br.hasErrors()) {
//			response =new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}else {
//			volService.saveVol(vol); 
//			HttpHeaders header = new HttpHeaders(); 
//			header.setLocation(uCB.path("/rest/vol/{id}").buildAndExpand(vol.getIdVol()).toUri() );
//			response = new ResponseEntity<>(header,HttpStatus.CREATED); 
//		} 
//		return response;
//	}
//	@GetMapping(value="/{id}")
//	@JsonView(JsonViews.Common.class)
//	public ResponseEntity<Vol> findById(@PathVariable(name="id") Integer id) {
//		Vol opt= volService.findVolById(id);
//		ResponseEntity<Vol> response = null;
//		if(opt !=null) {
//			response = new ResponseEntity<Vol> (opt, HttpStatus.OK);
//		} else {
//			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//			return response;
//	}
//
//	
//	@JsonView(JsonViews.Common.class)
//	@PutMapping(path= {"","/"})
//	public ResponseEntity<Vol> update(@Valid @RequestBody Vol vol, BindingResult br ){
//		ResponseEntity<Vol> response = null;
//		if(br.hasErrors()|| vol.getIdVol()==null) {
//			response =new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//		}else {
//			Vol opti= volService.findVolWithReservation(vol.getIdVol());
//			if(opti !=null) {
//				Vol volEnBase = opti;
//				volEnBase.setAeroportArrivee(vol.getAeroportArrivee());
//				volEnBase.setAeroportDepart(vol.getAeroportDepart()); 
//				volEnBase.setDateDepart(vol.getDateDepart()); 
//				volEnBase.setDateArrivee(vol.getDateArrivee()); 
//				volEnBase.setHeureDepart(vol.getHeureDepart()); 
//				volEnBase.setHeureArrivee(vol.getHeureArrivee()); 
//				volEnBase.setAeroportArrivee(vol.getAeroportArrivee()); 
//				volService.saveVol(volEnBase);
//				response = new ResponseEntity<>(HttpStatus.OK);
//			} else {
//				response =new ResponseEntity<>(HttpStatus.NOT_MODIFIED); 
//			}
//		}
//		return response; 
//	}
//	
//		@DeleteMapping(value="/{id}")
//		public ResponseEntity<Void> delete(@PathVariable(name="id") Integer id){
//			Vol opt=volService.findVolById(id);
//			ResponseEntity<Void> response=null;
//			if(opt !=null) {
//				volService.deleteVolById(id); 
//				response= new ResponseEntity<>(HttpStatus.OK);
//			} else {
//				response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//			return response;
//		}
		 
}
