package aeroportSpringBoot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Client;
import model.Reservation;
import model.Vol;

public interface ClientRepository extends JpaRepository<Client, Integer>{

	Client findByClientName(String name);
	
	@Query("select c from Client c left join fetch c.reservations where c.clientId=:id") //permet de recup�rer le vol avec la liste des reservations
	Optional<Client> findClientWithReservation(@Param("id")Integer clientId); // car le findById standard n'embarque pas les listes dans les objets !

}
