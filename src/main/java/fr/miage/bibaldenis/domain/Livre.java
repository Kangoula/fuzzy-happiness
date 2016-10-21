package fr.miage.bibaldenis.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Livre.
 */
@Entity
@Table(name = "livre")
public class Livre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "nb_resa")
    private Integer nbResa;

    @Column(name = "date_edition")
    private LocalDate dateEdition;

    @Column(name = "resume")
    private String resume;

    @Column(name = "date_ajout")
    private LocalDate dateAjout;

    @OneToMany(mappedBy = "livre")
    @JsonIgnore
    private Set<Exemplaire> livreExemplaires = new HashSet<>();

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

    public Livre titre(String titre) {
        this.titre = titre;
        return this;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getNbResa() {
        return nbResa;
    }

    public Livre nbResa(Integer nbResa) {
        this.nbResa = nbResa;
        return this;
    }

    public void setNbResa(Integer nbResa) {
        this.nbResa = nbResa;
    }

    public LocalDate getDateEdition() {
        return dateEdition;
    }

    public Livre dateEdition(LocalDate dateEdition) {
        this.dateEdition = dateEdition;
        return this;
    }

    public void setDateEdition(LocalDate dateEdition) {
        this.dateEdition = dateEdition;
    }

    public String getResume() {
        return resume;
    }

    public Livre resume(String resume) {
        this.resume = resume;
        return this;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public LocalDate getDateAjout() {
        return dateAjout;
    }

    public Livre dateAjout(LocalDate dateAjout) {
        this.dateAjout = dateAjout;
        return this;
    }

    public void setDateAjout(LocalDate dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Set<Exemplaire> getLivreExemplaires() {
        return livreExemplaires;
    }

    public Livre livreExemplaires(Set<Exemplaire> exemplaires) {
        this.livreExemplaires = exemplaires;
        return this;
    }

    public Livre addLivreExemplaire(Exemplaire exemplaire) {
        livreExemplaires.add(exemplaire);
        exemplaire.setLivre(this);
        return this;
    }

    public Livre removeLivreExemplaire(Exemplaire exemplaire) {
        livreExemplaires.remove(exemplaire);
        exemplaire.setLivre(null);
        return this;
    }

    public void setLivreExemplaires(Set<Exemplaire> exemplaires) {
        this.livreExemplaires = exemplaires;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public Livre auteur(Auteur auteur) {
        this.auteur = auteur;
        return this;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Livre livre = (Livre) o;
        if(livre.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, livre.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Livre{" +
            "id=" + id +
            ", titre='" + titre + "'" +
            ", nbResa='" + nbResa + "'" +
            ", dateEdition='" + dateEdition + "'" +
            ", resume='" + resume + "'" +
            ", dateAjout='" + dateAjout + "'" +
            '}';
    }
}
