package aeroportSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeroportSpringBoot.model.Aeroport;
import aeroportSpringBoot.model.Escale;
import aeroportSpringBoot.model.EscaleKey;
import aeroportSpringBoot.model.Vol;
import aeroportSpringBoot.repositories.EscaleRepository;

@Service
public class EscaleService {

	@Autowired
	private EscaleRepository escaleRepository;

	public void createEscale(Vol vol, Aeroport aeroport) {
		EscaleKey escalelKey = new EscaleKey();
		escalelKey.setVol(vol);
		escalelKey.setAeroport(aeroport);
		Escale escale = new Escale();
		escale.setKey(escalelKey);
		escaleRepository.save(escale);
		System.out.println("Escale a bien �t� cr��");
	}

	public void updateVol(Escale escale, Vol vol) {
		Aeroport aeroport = escale.getKey().getAeroport();
		EscaleKey escaleKey = new EscaleKey();
		escaleKey.setVol(vol);
		escaleKey.setAeroport(aeroport);
		escale.setKey(escaleKey);
		escaleRepository.save(escale);
		System.out.println("Le vol a bien �t� mis � jour");
	}

	public void updateAeroport(Escale escale, Aeroport aeroport) {
		Vol vol = escale.getKey().getVol();
		EscaleKey escaleKey = new EscaleKey();
		escaleKey.setVol(vol);
		escaleKey.setAeroport(aeroport);
		escale.setKey(escaleKey);
		escaleRepository.save(escale);
		System.out.println("L'a�roport a bien �t� mis � jour");
	}

	public void deleteEscale(Escale escale) {
		escaleRepository.delete(escale);
		System.out.println("Escale a bien �t� effac�");
	}

	public void deleteEscaleByKey(EscaleKey escaleKey) {
		escaleRepository.deleteById(escaleKey);
		System.out.println("Escale a bien �t� effac�");
	}

	public void deleteEscaleByVol(Vol vol) {
		List<Escale> escales = escaleRepository.findAll();
		for (Escale escale : escales) {
			if (escale.getKey().getVol().equals(vol)) {
				escaleRepository.delete(escale);
			}
		}
	}

	public void deleteEscaleByAeroport(Aeroport aeroport) {
		List<Escale> escales = escaleRepository.findAll();
		for (Escale escale : escales) {
			if (escale.getKey().getAeroport().equals(aeroport)) {
				escaleRepository.delete(escale);
			}
		}
	}

	public List<Escale> findAllEscale() {
		return escaleRepository.findAll();
	}
}
