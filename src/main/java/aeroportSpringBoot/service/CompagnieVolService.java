package aeroportSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Compagnie;
import model.CompagnieVol;
import model.CompagnieVolKey;
import model.Vol;
import repositories.CompagnieVolRepository;

@Service
public class CompagnieVolService {

	@Autowired
	private CompagnieVolRepository compagnieVolRepository;

	public void createCompagnieVol(Compagnie compagnie, Vol vol) {
		CompagnieVolKey compagnieVolKey = new CompagnieVolKey();
		compagnieVolKey.setCompagnie(compagnie);
		compagnieVolKey.setVol(vol);
		CompagnieVol compagnieVol = new CompagnieVol();
		compagnieVol.setKey(compagnieVolKey);
		compagnieVolRepository.save(compagnieVol);
		System.out.println("CompagnieVol a bien �t� cr��");
	}

	public void updateCompagnie(CompagnieVol compagnieVol, Compagnie compagnie) {
		Vol vol = compagnieVol.getKey().getVol();
		CompagnieVolKey compagnieVolKey = new CompagnieVolKey();
		compagnieVolKey.setCompagnie(compagnie);
		compagnieVolKey.setVol(vol);
		compagnieVol.setKey(compagnieVolKey);
		compagnieVolRepository.save(compagnieVol);
		System.out.println("La compagnie a bien �t� mise � jour");
	}

	public void updateVol(CompagnieVol compagnieVol, Vol vol) {
		Compagnie compagnie = compagnieVol.getKey().getCompagnie();
		CompagnieVolKey compagnieVolKey = new CompagnieVolKey();
		compagnieVolKey.setCompagnie(compagnie);
		compagnieVolKey.setVol(vol);
		compagnieVol.setKey(compagnieVolKey);
		compagnieVolRepository.save(compagnieVol);
		System.out.println("Le vol a bien �t� mis � jour");
	}

	public void deleteCompagnieVol(CompagnieVol compagnieVol) {
		compagnieVolRepository.delete(compagnieVol);
		System.out.println("CompagnieVol a bien �t� effac�");
	}

	public void deleteCompagnieVolByKey(CompagnieVolKey compagnieVolKey) {
		compagnieVolRepository.deleteById(compagnieVolKey);
		System.out.println("CompagnieVol a bien �t� effac�");
	}

	public void deleteCompagnieVolByCompagnie(Compagnie compagnie) {
		List<CompagnieVol> compagnieVols = compagnieVolRepository.findAll();
		for (CompagnieVol compagnieVol : compagnieVols) {
			if (compagnieVol.getKey().getCompagnie().equals(compagnie)) {
				compagnieVolRepository.delete(compagnieVol);
			}
		}
	}

	public void deleteCompagnieVolByVol(Vol vol) {
		List<CompagnieVol> compagniesVol = compagnieVolRepository.findAll();
		for (CompagnieVol compagnieVol : compagniesVol) {
			if (compagnieVol.getKey().getVol().equals(vol)) {
				compagnieVolRepository.delete(compagnieVol);
			}
		}
	}

	public List<CompagnieVol> findAllCompagnieVol() {
		return compagnieVolRepository.findAll();
	}
}
