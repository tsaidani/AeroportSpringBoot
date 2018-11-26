package aeroportSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.CompagnieVol;
import model.CompagnieVolKey;

public interface CompagnieVolRepository extends JpaRepository<CompagnieVol,CompagnieVolKey> {

}
