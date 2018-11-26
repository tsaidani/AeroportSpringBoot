package aeroportSpringBoot.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aeroportSpringBoot.model.Vol;

public interface VolRepository extends JpaRepository<Vol, Integer> {

	List<Vol> findByDateDepart(Date dateDepart);

	List<Vol> findByDateArrivee(Date dateArrivee);

	List<Vol> findByHeureDepartBetween(Date heureDepart1, Date heureDepart2);

	List<Vol> findByHeureArriveeBetween(Date heureArivee1, Date heureArrivee2);

	@Query("select v from Vol v left join fetch v.reservations where v.idVol=:id") // permet de recup�rer le vol avec la
																					// liste des reservations
	Optional<Vol> findVolWithReservation(@Param("id") Integer idVol); // car le findById standard n'embarque pas les
																		// listes dans les objets !

	@Query("select v from Vol v left join fetch v.compagniesVol where v.idVol=:id")
	Optional<Vol> findVolWithCompagniesVol(@Param("id") Integer idVol);
	
	@Query("select v from Vol v left join fetch v.reservations")
	List<Vol> findAllWithReservation();

	
	@Query("select v from Vol v left join fetch v.reservations")
	List<Vol> findAllWithReservation();
}
