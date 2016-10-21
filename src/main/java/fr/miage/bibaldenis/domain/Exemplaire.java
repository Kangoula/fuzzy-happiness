package fr.miage.bibaldenis.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
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
    private Magazine magazine;

    @ManyToOne
    private Livre livre;

    @OneToMany(mappedBy = "exemplaire")
    @JsonIgnore
    private Set<Emprunt> exemplaireEmprunts = new HashSet<>();

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

    public Set<Emprunt> getExemplaireEmprunts() {
        return exemplaireEmprunts;
    }

    public Exemplaire exemplaireEmprunts(Set<Emprunt> emprunts) {
        this.exemplaireEmprunts = emprunts;
        return this;
    }

    public Exemplaire addExemplaireEmprunt(Emprunt emprunt) {
        exemplaireEmprunts.add(emprunt);
        emprunt.setExemplaire(this);
        return this;
    }

    public Exemplaire removeExemplaireEmprunt(Emprunt emprunt) {
        exemplaireEmprunts.remove(emprunt);
        emprunt.setExemplaire(null);
        return this;
    }

    public void setExemplaireEmprunts(Set<Emprunt> emprunts) {
        this.exemplaireEmprunts = emprunts;
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
