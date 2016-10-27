package fr.miage.bibaldenis.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
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
    private Usager usagerReservation;

    @ManyToOne
    private Livre livreReservation;

    @ManyToOne
    private Magazine magazineReservation;

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

    public Usager getUsagerReservation() {
        return usagerReservation;
    }

    public Reservation usagerReservation(Usager usager) {
        this.usagerReservation = usager;
        return this;
    }

    public void setUsagerReservation(Usager usager) {
        this.usagerReservation = usager;
    }

    public Livre getLivreReservation() {
        return livreReservation;
    }

    public Reservation livreReservation(Livre livre) {
        if(this.livreReservation != null)
            this.livreReservation.supprimerResa();
        this.livreReservation = livre;
        this.livreReservation.ajouterResa();
        return this;
    }

    public void setLivreReservation(Livre livre) {
        if(this.livreReservation != null)
            this.livreReservation.supprimerResa();
        this.livreReservation = livre;
        this.livreReservation.ajouterResa();
    }

    public Magazine getMagazineReservation() {
        return magazineReservation;
    }

    public Reservation magazineReservation(Magazine magazine) {
        if(this.magazineReservation != null)
            this.magazineReservation.supprimerResa();
        this.magazineReservation = magazine;
        this.magazineReservation.ajouterResa();
        return this;
    }

    public void setMagazineReservation(Magazine magazine) {
        if(this.magazineReservation != null)
            this.magazineReservation.supprimerResa();
        this.magazineReservation = magazine;
        this.magazineReservation.ajouterResa();
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
