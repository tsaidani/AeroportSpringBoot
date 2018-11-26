package aeroportSpringBoot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

	@Query("select l from Login l where l.login=:identifiant")
	Optional<Login> findWithName(@Param("identifiant") String identifiant);
	
	@Query("select l from Login l where l.id=:id")
	Optional<Login> findWithId(@Param("id") Integer id);
}
