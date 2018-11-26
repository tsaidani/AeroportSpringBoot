package aeroportSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Ville;
import repositories.VilleRepository;

@Service
public class VilleService {

	@Autowired
	private VilleRepository villeRepository;

	public void createVille(Ville ville) {
		List<Ville> villes = villeRepository.findAll();
		if (!villes.contains(villeRepository.findByNom(ville.getNom()))) {
			villeRepository.save(ville);
		} else {
			System.out.println("la ville existe deja");
		}
	}

	public void deleteVille(Ville ville) {
		List<Ville> villes = villeRepository.findAll();
		if (villes.contains(villeRepository.findByNom(ville.getNom()))) {
			villeRepository.delete(villeRepository.findByNom(ville.getNom()));
		} else {
			System.out.println("la ville n existe pas");
		}
	}

	public void updateVille(Ville ville, String nom) {
		List<Ville> villes = villeRepository.findAll();
		if (villes.contains(villeRepository.findByNom(ville.getNom()))) {
			Ville a = villeRepository.findByNom(ville.getNom());
			a.setNom(nom);
			villeRepository.save(a);
		} else {
			System.out.println("la ville n existe pas");
		}
	}

	public List<Ville> findAllVilles() {
		return villeRepository.findAll();
	}

	public Ville findVilleByName(String nom) {
		return villeRepository.findByNom(nom);
	}

}
