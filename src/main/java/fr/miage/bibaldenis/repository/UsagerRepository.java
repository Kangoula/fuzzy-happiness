package fr.miage.bibaldenis.repository;

import fr.miage.bibaldenis.domain.Usager;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Usager entity.
 */
@SuppressWarnings("unused")
public interface UsagerRepository extends JpaRepository<Usager,Long> {

}
