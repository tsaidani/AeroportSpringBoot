package aeroportSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Adresse;
import model.Passager;
import repositories.PassagerRepository;

@Service
public class PassagerService {

	@Autowired
	private PassagerRepository passagerRepository;

	public void createPassager(Passager passager) {
		if (passager != null) {
			passagerRepository.save(passager);
		}
	}

	public void deletePassager(Passager passager) {
		if (passager != null) {
			passagerRepository.delete(passager);
		}
	}

	public void deletePassagerByName(String name) {
		passagerRepository.delete(passagerRepository.findByNom(name));
	}

	public void deletePassagerById(Integer id) {
		List<Passager> passagers = passagerRepository.findAll();
		if (passagers.contains(passagerRepository.findById(id).get())) {
			passagerRepository.delete(passagerRepository.findById(id).get());
		} else {
			System.out.println("le passager n existe pas");
		}
	}

	public void modifyPassagerName(Passager passager, String name) {
		if (name != null) {
			passager.setNom(name);
			passagerRepository.save(passager);
		}
	}

	public void modifyPassagerFirstname(Passager passager, String firstname) {
		if (firstname != null) {
			passager.setPrenom(firstname);
			passagerRepository.save(passager);
		}
	}

	public void modifyPassagerAdress(Passager passager, Adresse adress) {
		if (adress != null) {
			passager.setAdresse(adress);
			passagerRepository.save(passager);
		}
	}

	public void updatePassager(Passager passager) {
		List<Passager> passagers = passagerRepository.findAll();
		if (passagers.contains(passagerRepository.findById(passager.getIdPassager()).get())) {
			Passager p = passagerRepository.findById(passager.getIdPassager()).get();
			save(passager);;
		} else {
			System.out.println("le passager n existe pas");
		}
	}

	public void save(Passager passager) {
		passagerRepository.save(passager);
		}

	public List<Passager> findAllPassagers() {
		return passagerRepository.findAll();
	}

	public Passager findPassagerById(Integer idPassger) {
		return passagerRepository.findById(idPassger).get();
	}

}
