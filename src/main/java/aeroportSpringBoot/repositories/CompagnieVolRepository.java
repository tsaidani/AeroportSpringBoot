package aeroportSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import aeroportSpringBoot.model.CompagnieVol;
import aeroportSpringBoot.model.CompagnieVolKey;

public interface CompagnieVolRepository extends JpaRepository<CompagnieVol,CompagnieVolKey> {

}
