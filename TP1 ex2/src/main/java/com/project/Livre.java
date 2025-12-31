package com.project;

import java.time.Year;
import java.util.Objects;

public class Livre {
    private String titre;
    private String auteur;
    private int anneePublication;
    private String isbn;

    public Livre(String titre, String auteur, int anneePublication, String isbn) {
        setTitre(titre);
        setAuteur(auteur);
        setAnneePublication(anneePublication);
        setIsbn(isbn);
    }
    public String getTitre() { return titre; }

    public void setTitre(String titre) {
        if (titre == null || titre.trim().isEmpty()) {
            throw new IllegalArgumentException("Le titre ne peut pas être vide");
        }
        this.titre = titre;
    }

    public String getAuteur() { return auteur; }

    public void setAuteur(String auteur) {
        if (auteur == null || auteur.trim().isEmpty()) {
            throw new IllegalArgumentException("L'auteur ne peut pas être vide");
        }
        this.auteur = auteur;
    }

    public int getAnneePublication() { return anneePublication; }

    public void setAnneePublication(int anneePublication) {
        int currentYear = Year.now().getValue();
        if (anneePublication < 0 || anneePublication > currentYear + 1) {
            throw new IllegalArgumentException("Année de publication invalide");
        }
        this.anneePublication = anneePublication;
    }

    public String getIsbn() { return isbn; }

    public void setIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("L'ISBN ne peut pas être vide");
        }
        this.isbn = isbn;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livre livre = (Livre) o;
        return anneePublication == livre.anneePublication &&
                Objects.equals(titre, livre.titre) &&
                Objects.equals(auteur, livre.auteur) &&
                Objects.equals(isbn, livre.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titre, auteur, anneePublication, isbn);
    }
}