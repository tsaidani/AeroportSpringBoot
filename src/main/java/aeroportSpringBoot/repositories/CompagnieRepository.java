package aeroportSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Compagnie;

public interface CompagnieRepository extends JpaRepository<Compagnie, Integer> {

	Compagnie findByNom(String nom);

}
