package fr.miage.bibaldenis.web.rest;

import com.codahale.metrics.annotation.Timed;
import fr.miage.bibaldenis.domain.Livre;

import fr.miage.bibaldenis.repository.LivreRepository;
import fr.miage.bibaldenis.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Livre.
 */
@RestController
@RequestMapping("/api")
public class LivreResource {

    private final Logger log = LoggerFactory.getLogger(LivreResource.class);
        
    @Inject
    private LivreRepository livreRepository;

    /**
     * POST  /livres : Create a new livre.
     *
     * @param livre the livre to create
     * @return the ResponseEntity with status 201 (Created) and with body the new livre, or with status 400 (Bad Request) if the livre has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/livres",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Livre> createLivre(@RequestBody Livre livre) throws URISyntaxException {
        log.debug("REST request to save Livre : {}", livre);
        if (livre.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("livre", "idexists", "A new livre cannot already have an ID")).body(null);
        }
        Livre result = livreRepository.save(livre);
        return ResponseEntity.created(new URI("/api/livres/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("livre", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /livres : Updates an existing livre.
     *
     * @param livre the livre to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated livre,
     * or with status 400 (Bad Request) if the livre is not valid,
     * or with status 500 (Internal Server Error) if the livre couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/livres",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Livre> updateLivre(@RequestBody Livre livre) throws URISyntaxException {
        log.debug("REST request to update Livre : {}", livre);
        if (livre.getId() == null) {
            return createLivre(livre);
        }
        Livre result = livreRepository.save(livre);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("livre", livre.getId().toString()))
            .body(result);
    }

    /**
     * GET  /livres : get all the livres.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of livres in body
     */
    @RequestMapping(value = "/livres",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<Livre> getAllLivres() {
        log.debug("REST request to get all Livres");
        List<Livre> livres = livreRepository.findAll();
        return livres;
    }

    /**
     * GET  /livres/:id : get the "id" livre.
     *
     * @param id the id of the livre to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the livre, or with status 404 (Not Found)
     */
    @RequestMapping(value = "/livres/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Livre> getLivre(@PathVariable Long id) {
        log.debug("REST request to get Livre : {}", id);
        Livre livre = livreRepository.findOne(id);
        return Optional.ofNullable(livre)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /livres/:id : delete the "id" livre.
     *
     * @param id the id of the livre to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @RequestMapping(value = "/livres/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteLivre(@PathVariable Long id) {
        log.debug("REST request to delete Livre : {}", id);
        livreRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("livre", id.toString())).build();
    }

}
