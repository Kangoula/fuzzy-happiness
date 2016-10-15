package fr.miage.bibaldenis.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Usager.
 */
@Entity
@Table(name = "usager")
public class Usager implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "adresse")
    private String adresse;

    @OneToMany(mappedBy = "usager")
    @JsonIgnore
    private Set<Emprunt> usagerEmprunts = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public Usager nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Usager prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public Usager adresse(String adresse) {
        this.adresse = adresse;
        return this;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Set<Emprunt> getUsagerEmprunts() {
        return usagerEmprunts;
    }

    public Usager usagerEmprunts(Set<Emprunt> emprunts) {
        this.usagerEmprunts = emprunts;
        return this;
    }

    public Usager addUsagerEmprunt(Emprunt emprunt) {
        usagerEmprunts.add(emprunt);
        emprunt.setUsager(this);
        return this;
    }

    public Usager removeUsagerEmprunt(Emprunt emprunt) {
        usagerEmprunts.remove(emprunt);
        emprunt.setUsager(null);
        return this;
    }

    public void setUsagerEmprunts(Set<Emprunt> emprunts) {
        this.usagerEmprunts = emprunts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Usager usager = (Usager) o;
        if(usager.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, usager.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Usager{" +
            "id=" + id +
            ", nom='" + nom + "'" +
            ", prenom='" + prenom + "'" +
            ", adresse='" + adresse + "'" +
            '}';
    }
}
