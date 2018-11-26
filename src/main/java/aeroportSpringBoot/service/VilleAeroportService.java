package aeroportSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Aeroport;
import model.Ville;
import model.VilleAeroport;
import model.VilleAeroportKey;
import repositories.VilleAeroportRepository;

@Service
public class VilleAeroportService {

	@Autowired
	private VilleAeroportRepository villeAeroportRepository;

	public void createVilleAeroport(Ville ville, Aeroport aeroport) {
		VilleAeroportKey villeAeroportKey = new VilleAeroportKey();
		villeAeroportKey.setVille(ville);
		villeAeroportKey.setAeroport(aeroport);
		VilleAeroport villeAeroport = new VilleAeroport();
		villeAeroport.setKey(villeAeroportKey);
		villeAeroportRepository.save(villeAeroport);
		System.out.println("VilleAeroport a bien �t� cr��");
	}

	public void updateVille(VilleAeroport villeAeroport, Ville ville) {
		Aeroport aeroport = villeAeroport.getKey().getAeroport();
		VilleAeroportKey villeAeroportKey = new VilleAeroportKey();
		villeAeroportKey.setVille(ville);
		villeAeroportKey.setAeroport(aeroport);
		villeAeroport.setKey(villeAeroportKey);
		villeAeroportRepository.save(villeAeroport);
		System.out.println("La ville a bien �t� mise � jour");
	}

	public void updateAeroport(VilleAeroport villeAeroport, Aeroport aeroport) {
		Ville ville = villeAeroport.getKey().getVille();
		VilleAeroportKey villeAeroportKey = new VilleAeroportKey();
		villeAeroportKey.setVille(ville);
		villeAeroportKey.setAeroport(aeroport);
		villeAeroport.setKey(villeAeroportKey);
		villeAeroportRepository.save(villeAeroport);
		System.out.println("L'a�roport a bien �t� mis � jour");
	}

	public void deleteVilleAeroport(VilleAeroport villeAeroport) {
		villeAeroportRepository.delete(villeAeroport);
		System.out.println("VilleAeroport a bien �t� effac�");
	}

	public void deleteVilleAeroportByKey(VilleAeroportKey villeAeroportKey) {
		villeAeroportRepository.deleteById(villeAeroportKey);
		System.out.println("VilleAeroport a bien �t� effac�");
	}

	public void deleteVilleAeroportByVille(Ville ville) {
		List<VilleAeroport> villeAeroports = villeAeroportRepository.findAll();
		for (VilleAeroport villeAeroport : villeAeroports) {
			if (villeAeroport.getKey().getVille().equals(ville)) {
				villeAeroportRepository.delete(villeAeroport);
			}
		}
	}

	public void deleteVilleAeroportlByAeroport(Aeroport aeroport) {
		List<VilleAeroport> villesAeroport = villeAeroportRepository.findAll();
		for (VilleAeroport villeAeroport : villesAeroport) {
			if (villeAeroport.getKey().getAeroport().equals(aeroport)) {
				villeAeroportRepository.delete(villeAeroport);
			}
		}
	}

	public List<VilleAeroport> findAllVilleAeroport() {
		return villeAeroportRepository.findAll();
	}
}
