package aeroportSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Passager;

public interface PassagerRepository extends JpaRepository<Passager, Integer>{

	Passager findByNom(String name);

}
