package aeroportSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Compagnie;
import repositories.CompagnieRepository;

@Service
public class CompagnieService {

	@Autowired
	private CompagnieRepository compagnieRepository;

	public void createCompagnie(Compagnie compagnie) {
		List<Compagnie> compagnies = compagnieRepository.findAll();
		if (!compagnies.contains(compagnieRepository.findByNom(compagnie.getNom()))) {
			compagnieRepository.save(compagnie);
		} else {
			System.out.println("la compagnie existe deja");
		}
	}

	public void deleteCompagnie(Compagnie compagnie) {
		List<Compagnie> compagnies = compagnieRepository.findAll();
		if (compagnies.contains(compagnieRepository.findByNom(compagnie.getNom()))) {
			compagnieRepository.delete(compagnieRepository.findByNom(compagnie.getNom()));
		} else {
			System.out.println("la compagnie n existe pas");
		}
	}

	public void updateCompagnieName(Compagnie compagnie, String nom) {
		List<Compagnie> compagnies = compagnieRepository.findAll();
		if (compagnies.contains(compagnieRepository.findByNom(compagnie.getNom()))) {
			Compagnie c = compagnieRepository.findByNom(compagnie.getNom());
			c.setNom(nom);
			compagnieRepository.save(c);
		} else {
			System.out.println("la compagnie n'existe pas");
		}
	}

	public List<Compagnie> findAllCompagnies() {
		return compagnieRepository.findAll();
	}

	public Compagnie findCompagnieByName(String nom) {
		return compagnieRepository.findByNom(nom);
	}

}
