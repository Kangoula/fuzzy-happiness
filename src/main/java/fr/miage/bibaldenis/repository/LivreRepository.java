package fr.miage.bibaldenis.repository;

import fr.miage.bibaldenis.domain.Livre;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Livre entity.
 */
@SuppressWarnings("unused")
public interface LivreRepository extends JpaRepository<Livre,Long> {

}
