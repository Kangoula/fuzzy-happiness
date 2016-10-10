package fr.miage.bibaldenis.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * The Employee entity.                                                        
 * 
 */
@ApiModel(description = ""
    + "The Employee entity.                                                   "
    + "")
@Entity
@Table(name = "auteur")
public class Auteur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @OneToMany(mappedBy = "auteur")
    @JsonIgnore
    private Set<Magazine> auteurMagazines = new HashSet<>();

    @OneToMany(mappedBy = "auteur")
    @JsonIgnore
    private Set<Livre> auteurLivres = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public Auteur nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Auteur prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Set<Magazine> getAuteurMagazines() {
        return auteurMagazines;
    }

    public Auteur auteurMagazines(Set<Magazine> magazines) {
        this.auteurMagazines = magazines;
        return this;
    }

    public Auteur addAuteurMagazine(Magazine magazine) {
        auteurMagazines.add(magazine);
        magazine.setAuteur(this);
        return this;
    }

    public Auteur removeAuteurMagazine(Magazine magazine) {
        auteurMagazines.remove(magazine);
        magazine.setAuteur(null);
        return this;
    }

    public void setAuteurMagazines(Set<Magazine> magazines) {
        this.auteurMagazines = magazines;
    }

    public Set<Livre> getAuteurLivres() {
        return auteurLivres;
    }

    public Auteur auteurLivres(Set<Livre> livres) {
        this.auteurLivres = livres;
        return this;
    }

    public Auteur addAuteurLivre(Livre livre) {
        auteurLivres.add(livre);
        livre.setAuteur(this);
        return this;
    }

    public Auteur removeAuteurLivre(Livre livre) {
        auteurLivres.remove(livre);
        livre.setAuteur(null);
        return this;
    }

    public void setAuteurLivres(Set<Livre> livres) {
        this.auteurLivres = livres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Auteur auteur = (Auteur) o;
        if(auteur.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, auteur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Auteur{" +
            "id=" + id +
            ", nom='" + nom + "'" +
            ", prenom='" + prenom + "'" +
            '}';
    }
}
