package aeroportSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Aeroport;
import repositories.AeroportRepository;

@Service
public class AeroportService {

	@Autowired
	private AeroportRepository aeroportRepository;

	public void createAeroport(Aeroport aeroport) {
		List<Aeroport> aeroports = aeroportRepository.findAll();
		if (!aeroports.contains(aeroportRepository.findByNom(aeroport.getNom()))) {
			aeroportRepository.save(aeroport);
		} else {
			System.out.println("l aeroport existe deja");
		}
	}

	public void deleteAeroport(Aeroport aeroport) {
		List<Aeroport> aeroports = aeroportRepository.findAll();
		if (aeroports.contains(aeroportRepository.findByNom(aeroport.getNom()))) {
			aeroportRepository.delete(aeroportRepository.findByNom(aeroport.getNom()));
		} else {
			System.out.println("l aeroport n existe pas");
		}
	}

	public void updateAeroport(Aeroport aeroport, String nom) {
		List<Aeroport> aeroports = aeroportRepository.findAll();
		if (aeroports.contains(aeroportRepository.findByNom(aeroport.getNom()))) {
			Aeroport a = aeroportRepository.findByNom(aeroport.getNom());
			a.setNom(nom);
			aeroportRepository.save(a);
		} else {
			System.out.println("l aeroport n existe pas");
		}
	}

	public List<Aeroport> findAllAeroports() {
		return aeroportRepository.findAll();
	}

	public Aeroport findAeroportByName(String nom) {
		return aeroportRepository.findByNom(nom);
	}

}
