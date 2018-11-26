package aeroportSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import aeroportSpringBoot.model.Aeroport;

public interface AeroportRepository extends JpaRepository<Aeroport, Integer> {

	Aeroport findByNom(String nom);

}
