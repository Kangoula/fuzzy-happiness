package fr.miage.bibaldenis.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Reservation.
 */
@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "date_expiration")
    private LocalDate dateExpiration;

    @ManyToOne
    private Usager usager;

    @OneToMany(mappedBy = "reservation")
    @JsonIgnore
    private Set<Exemplaire> reservationExemplaires = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Reservation date(LocalDate date) {
        this.date = date;
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public Reservation dateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
        return this;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Usager getUsager() {
        return usager;
    }

    public Reservation usager(Usager usager) {
        this.usager = usager;
        return this;
    }

    public void setUsager(Usager usager) {
        this.usager = usager;
    }

    public Set<Exemplaire> getReservationExemplaires() {
        return reservationExemplaires;
    }

    public Reservation reservationExemplaires(Set<Exemplaire> exemplaires) {
        this.reservationExemplaires = exemplaires;
        return this;
    }

    public Reservation addReservationExemplaire(Exemplaire exemplaire) {
        reservationExemplaires.add(exemplaire);
        exemplaire.setReservation(this);
        return this;
    }

    public Reservation removeReservationExemplaire(Exemplaire exemplaire) {
        reservationExemplaires.remove(exemplaire);
        exemplaire.setReservation(null);
        return this;
    }

    public void setReservationExemplaires(Set<Exemplaire> exemplaires) {
        this.reservationExemplaires = exemplaires;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reservation reservation = (Reservation) o;
        if(reservation.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, reservation.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Reservation{" +
            "id=" + id +
            ", date='" + date + "'" +
            ", dateExpiration='" + dateExpiration + "'" +
            '}';
    }
}
