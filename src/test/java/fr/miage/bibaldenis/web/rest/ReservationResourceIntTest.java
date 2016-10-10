package fr.miage.bibaldenis.web.rest;

import fr.miage.bibaldenis.BibalDenisApp;

import fr.miage.bibaldenis.domain.Reservation;
import fr.miage.bibaldenis.repository.ReservationRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.hasItem;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the ReservationResource REST controller.
 *
 * @see ReservationResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BibalDenisApp.class)
public class ReservationResourceIntTest {


    private static final LocalDate DEFAULT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_EXPIRATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_EXPIRATION = LocalDate.now(ZoneId.systemDefault());

    @Inject
    private ReservationRepository reservationRepository;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Inject
    private EntityManager em;

    private MockMvc restReservationMockMvc;

    private Reservation reservation;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ReservationResource reservationResource = new ReservationResource();
        ReflectionTestUtils.setField(reservationResource, "reservationRepository", reservationRepository);
        this.restReservationMockMvc = MockMvcBuilders.standaloneSetup(reservationResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Reservation createEntity(EntityManager em) {
        Reservation reservation = new Reservation()
                .date(DEFAULT_DATE)
                .dateExpiration(DEFAULT_DATE_EXPIRATION);
        return reservation;
    }

    @Before
    public void initTest() {
        reservation = createEntity(em);
    }

    @Test
    @Transactional
    public void createReservation() throws Exception {
        int databaseSizeBeforeCreate = reservationRepository.findAll().size();

        // Create the Reservation

        restReservationMockMvc.perform(post("/api/reservations")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(reservation)))
                .andExpect(status().isCreated());

        // Validate the Reservation in the database
        List<Reservation> reservations = reservationRepository.findAll();
        assertThat(reservations).hasSize(databaseSizeBeforeCreate + 1);
        Reservation testReservation = reservations.get(reservations.size() - 1);
        assertThat(testReservation.getDate()).isEqualTo(DEFAULT_DATE);
        assertThat(testReservation.getDateExpiration()).isEqualTo(DEFAULT_DATE_EXPIRATION);
    }

    @Test
    @Transactional
    public void getAllReservations() throws Exception {
        // Initialize the database
        reservationRepository.saveAndFlush(reservation);

        // Get all the reservations
        restReservationMockMvc.perform(get("/api/reservations?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.[*].id").value(hasItem(reservation.getId().intValue())))
                .andExpect(jsonPath("$.[*].date").value(hasItem(DEFAULT_DATE.toString())))
                .andExpect(jsonPath("$.[*].dateExpiration").value(hasItem(DEFAULT_DATE_EXPIRATION.toString())));
    }

    @Test
    @Transactional
    public void getReservation() throws Exception {
        // Initialize the database
        reservationRepository.saveAndFlush(reservation);

        // Get the reservation
        restReservationMockMvc.perform(get("/api/reservations/{id}", reservation.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(reservation.getId().intValue()))
            .andExpect(jsonPath("$.date").value(DEFAULT_DATE.toString()))
            .andExpect(jsonPath("$.dateExpiration").value(DEFAULT_DATE_EXPIRATION.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingReservation() throws Exception {
        // Get the reservation
        restReservationMockMvc.perform(get("/api/reservations/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateReservation() throws Exception {
        // Initialize the database
        reservationRepository.saveAndFlush(reservation);
        int databaseSizeBeforeUpdate = reservationRepository.findAll().size();

        // Update the reservation
        Reservation updatedReservation = reservationRepository.findOne(reservation.getId());
        updatedReservation
                .date(UPDATED_DATE)
                .dateExpiration(UPDATED_DATE_EXPIRATION);

        restReservationMockMvc.perform(put("/api/reservations")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(updatedReservation)))
                .andExpect(status().isOk());

        // Validate the Reservation in the database
        List<Reservation> reservations = reservationRepository.findAll();
        assertThat(reservations).hasSize(databaseSizeBeforeUpdate);
        Reservation testReservation = reservations.get(reservations.size() - 1);
        assertThat(testReservation.getDate()).isEqualTo(UPDATED_DATE);
        assertThat(testReservation.getDateExpiration()).isEqualTo(UPDATED_DATE_EXPIRATION);
    }

    @Test
    @Transactional
    public void deleteReservation() throws Exception {
        // Initialize the database
        reservationRepository.saveAndFlush(reservation);
        int databaseSizeBeforeDelete = reservationRepository.findAll().size();

        // Get the reservation
        restReservationMockMvc.perform(delete("/api/reservations/{id}", reservation.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<Reservation> reservations = reservationRepository.findAll();
        assertThat(reservations).hasSize(databaseSizeBeforeDelete - 1);
    }
}
