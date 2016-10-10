package fr.miage.bibaldenis.repository;

import fr.miage.bibaldenis.domain.Auteur;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Auteur entity.
 */
@SuppressWarnings("unused")
public interface AuteurRepository extends JpaRepository<Auteur,Long> {

}
