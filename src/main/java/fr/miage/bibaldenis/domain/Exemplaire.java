package fr.miage.bibaldenis.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Exemplaire.
 */
@Entity
@Table(name = "exemplaire")
public class Exemplaire implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "edition")
    private String edition;

    @Column(name = "etat")
    private String etat;

    @ManyToOne
    private Livre livre;

    @ManyToOne
    private Magazine magazine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEdition() {
        return edition;
    }

    public Exemplaire edition(String edition) {
        this.edition = edition;
        return this;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getEtat() {
        return etat;
    }

    public Exemplaire etat(String etat) {
        this.etat = etat;
        return this;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Livre getLivre() {
        return livre;
    }

    public Exemplaire livre(Livre livre) {
        this.livre = livre;
        return this;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public Exemplaire magazine(Magazine magazine) {
        this.magazine = magazine;
        return this;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Exemplaire exemplaire = (Exemplaire) o;
        if(exemplaire.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, exemplaire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Exemplaire{" +
            "id=" + id +
            ", edition='" + edition + "'" +
            ", etat='" + etat + "'" +
            '}';
    }
}
