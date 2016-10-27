package fr.miage.bibaldenis.repository;

import fr.miage.bibaldenis.domain.Livre;
import fr.miage.bibaldenis.domain.Magazine;
import fr.miage.bibaldenis.domain.Reservation;

import fr.miage.bibaldenis.domain.Usager;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Reservation entity.
 */
@SuppressWarnings("unused")
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query("select r from Reservation r where r.usagerReservation = ?1 and r.livreReservation = ?2")
    List<Reservation> findByUsagerAndLivre(Usager usager, Livre livre);

    @Query("select r from Reservation r where r.usagerReservation = ?1 and r.magazineReservation = ?2")
    List<Reservation> findByUsagerAndLMagazine(Usager usager, Magazine magazine);

}
