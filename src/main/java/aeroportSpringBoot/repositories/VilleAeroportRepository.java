package aeroportSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import aeroportSpringBoot.model.VilleAeroport;
import aeroportSpringBoot.model.VilleAeroportKey;

public interface VilleAeroportRepository extends JpaRepository<VilleAeroport,VilleAeroportKey> {

}
