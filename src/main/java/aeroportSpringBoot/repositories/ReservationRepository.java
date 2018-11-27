package aeroportSpringBoot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aeroportSpringBoot.model.Client;
import aeroportSpringBoot.model.Passager;
import aeroportSpringBoot.model.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	
	List<Reservation> findByClient (Client client);
	List<Reservation> findByPassager (Passager passager);
	
	@Query("select distinct r from Reservation r left join fetch r.vol v where v.idVol=:id")
	List<Reservation> findByVolId(@Param("id")Integer id);
	
	@Query("select distinct r from Reservation r left join fetch r.client c where c.clientName=:nom")
	List<Reservation> findByNomClient (@Param("nom")String nom);

	@Query("select distinct r from Reservation r left join fetch r.client c where c.clientId=:id")
	List<Reservation> findByIdClient (@Param("id")Integer id);
	
	@Query("select distinct r from Reservation r left join fetch r.passager p where p.nom=:nom")	
	List<Reservation> findByNomPassager (@Param("nom")String nom);
	
	@Query("select distinct r from Reservation r left join fetch r.passager p where p.idPassager=:id")	
	List<Reservation> findByIdPassager (@Param("id")Integer id);
	

		
}
