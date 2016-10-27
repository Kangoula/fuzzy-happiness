package fr.miage.bibaldenis.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Magazine.
 */
@Entity
@Table(name = "magazine")
public class Magazine implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "nb_resa")
    private Integer nbResa;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "date_ajout")
    private LocalDate dateAjout;

    @OneToMany(mappedBy = "magazine")
    @JsonIgnore
    private Set<Exemplaire> magazineExemplaires = new HashSet<>();

    @ManyToOne
    private Auteur auteur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public Magazine titre(String titre) {
        this.titre = titre;
        return this;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getNbResa() {
        return nbResa;
    }

    public Magazine nbResa(Integer nbResa) {
        this.nbResa = nbResa;
        return this;
    }

    public void setNbResa(Integer nbResa) {
        this.nbResa = nbResa;
    }

    public Integer getNumero() {
        return numero;
    }

    public Magazine numero(Integer numero) {
        this.numero = numero;
        return this;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public LocalDate getDateAjout() {
        return dateAjout;
    }

    public Magazine dateAjout(LocalDate dateAjout) {
        this.dateAjout = dateAjout;
        return this;
    }

    public void setDateAjout(LocalDate dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Set<Exemplaire> getMagazineExemplaires() {
        return magazineExemplaires;
    }

    public Magazine magazineExemplaires(Set<Exemplaire> exemplaires) {
        this.magazineExemplaires = exemplaires;
        return this;
    }

    public Magazine addMagazineExemplaire(Exemplaire exemplaire) {
        magazineExemplaires.add(exemplaire);
        exemplaire.setMagazine(this);
        return this;
    }

    public Magazine removeMagazineExemplaire(Exemplaire exemplaire) {
        magazineExemplaires.remove(exemplaire);
        exemplaire.setMagazine(null);
        return this;
    }

    public void setMagazineExemplaires(Set<Exemplaire> exemplaires) {
        this.magazineExemplaires = exemplaires;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public Magazine auteur(Auteur auteur) {
        this.auteur = auteur;
        return this;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }


    public void ajouterResa(){
        this.nbResa++;
    }

    public void supprimerResa(){
        this.nbResa = Math.max(0, this.nbResa-1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Magazine magazine = (Magazine) o;
        if(magazine.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, magazine.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Magazine{" +
            "id=" + id +
            ", titre='" + titre + "'" +
            ", nbResa='" + nbResa + "'" +
            ", numero='" + numero + "'" +
            ", dateAjout='" + dateAjout + "'" +
            '}';
    }
}
