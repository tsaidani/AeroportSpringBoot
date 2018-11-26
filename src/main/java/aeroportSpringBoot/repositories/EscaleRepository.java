package aeroportSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import aeroportSpringBoot.model.Escale;
import aeroportSpringBoot.model.EscaleKey;

public interface EscaleRepository extends JpaRepository<Escale,EscaleKey> {

}
