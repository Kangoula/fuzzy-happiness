package fr.miage.bibaldenis.repository;

import fr.miage.bibaldenis.domain.Emprunt;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Emprunt entity.
 */
@SuppressWarnings("unused")
public interface EmpruntRepository extends JpaRepository<Emprunt,Long> {

}
