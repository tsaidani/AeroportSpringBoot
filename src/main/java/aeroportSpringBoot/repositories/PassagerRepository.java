package aeroportSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import aeroportSpringBoot.model.Passager;

public interface PassagerRepository extends JpaRepository<Passager, Integer>{

	Passager findByNom(String name);

}
