package fr.miage.bibaldenis.web.rest;

import com.codahale.metrics.annotation.Timed;
import fr.miage.bibaldenis.domain.Magazine;

import fr.miage.bibaldenis.repository.MagazineRepository;
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
 * REST controller for managing Magazine.
 */
@RestController
@RequestMapping("/api")
public class MagazineResource {

    private final Logger log = LoggerFactory.getLogger(MagazineResource.class);

    @Inject
    private MagazineRepository magazineRepository;

    /**
     * POST  /magazines : Create a new magazine.
     *
     * @param magazine the magazine to create
     * @return the ResponseEntity with status 201 (Created) and with body the new magazine, or with status 400 (Bad Request) if the magazine has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/magazines",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Magazine> createMagazine(@RequestBody Magazine magazine) throws URISyntaxException {
        log.debug("REST request to save Magazine : {}", magazine);
        if (magazine.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("magazine", "idexists", "A new magazine cannot already have an ID")).body(null);
        }

        if(magazine.getNbResa()== null)
            magazine.setNbResa(0);
        Magazine result = magazineRepository.save(magazine);
        return ResponseEntity.created(new URI("/api/magazines/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("magazine", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /magazines : Updates an existing magazine.
     *
     * @param magazine the magazine to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated magazine,
     * or with status 400 (Bad Request) if the magazine is not valid,
     * or with status 500 (Internal Server Error) if the magazine couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/magazines",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Magazine> updateMagazine(@RequestBody Magazine magazine) throws URISyntaxException {
        log.debug("REST request to update Magazine : {}", magazine);
        if (magazine.getId() == null) {
            return createMagazine(magazine);
        }
        if(magazine.getNbResa()== null)
            magazine.setNbResa(0);
        Magazine result = magazineRepository.save(magazine);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("magazine", magazine.getId().toString()))
            .body(result);
    }

    /**
     * GET  /magazines : get all the magazines.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of magazines in body
     */
    @RequestMapping(value = "/magazines",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<Magazine> getAllMagazines() {
        log.debug("REST request to get all Magazines");
        List<Magazine> magazines = magazineRepository.findAll();
        return magazines;
    }

    /**
     * GET  /magazines/:id : get the "id" magazine.
     *
     * @param id the id of the magazine to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the magazine, or with status 404 (Not Found)
     */
    @RequestMapping(value = "/magazines/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Magazine> getMagazine(@PathVariable Long id) {
        log.debug("REST request to get Magazine : {}", id);
        Magazine magazine = magazineRepository.findOne(id);
        return Optional.ofNullable(magazine)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /magazines/:id : delete the "id" magazine.
     *
     * @param id the id of the magazine to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @RequestMapping(value = "/magazines/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> deleteMagazine(@PathVariable Long id) {
        log.debug("REST request to delete Magazine : {}", id);
        magazineRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("magazine", id.toString())).build();
    }

}
