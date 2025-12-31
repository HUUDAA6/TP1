package com.project;

import java.time.LocalDate;
import java.time.Year;
import java.util.Objects;

public class Livre {
    private String titre;
    private String auteur;
    private LocalDate datePublication; // Changement de int à LocalDate (Q1)
    private String isbn;

    // Constructeur principal avec LocalDate
    public Livre(String titre, String auteur, LocalDate datePublication, String isbn) {
        setTitre(titre);
        setAuteur(auteur);
        setDatePublication(datePublication);
        setIsbn(isbn);
    }

    // Surcharge du constructeur pour maintenir la compatibilité avec l'ancien code (int)
    public Livre(String titre, String auteur, int annee, String isbn) {
        this(titre, auteur, LocalDate.of(annee, 1, 1), isbn);
    }

    public String getTitre() { return titre; }
    public void setTitre(String titre) {
        if (titre == null || titre.trim().isEmpty()) throw new IllegalArgumentException("Titre vide");
        this.titre = titre;
    }

    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) {
        if (auteur == null || auteur.trim().isEmpty()) throw new IllegalArgumentException("Auteur vide");
        this.auteur = auteur;
    }

    // --- Nouvelle Gestion de la Date (Q1, Q2, Q6) ---

    public LocalDate getDatePublication() { return datePublication; }

    public void setDatePublication(LocalDate datePublication) {
        if (datePublication == null) {
            throw new IllegalArgumentException("La date de publication ne peut pas être null");
        }
        validerDate(datePublication); // Appel de la validation
        this.datePublication = datePublication;
    }

    // Méthode de validation privée (Q2)
    private void validerDate(LocalDate date) {
        int annee = date.getYear();
        int anneeCourante = Year.now().getValue();

        // Règle : entre l'an 1000 et l'année actuelle
        if (annee < 1000 || annee > anneeCourante) {
            throw new IllegalArgumentException("Date de publication invalide : doit être entre 1000 et " + anneeCourante);
        }
    }

    // --- Méthodes de compatibilité (Q4) ---
    // Permet aux anciens tests qui utilisent 'int' de continuer à fonctionner
    public int getAnneePublication() {
        return datePublication.getYear();
    }

    public void setAnneePublication(int annee) {
        // On fixe arbitrairement au 1er janvier de l'année donnée
        setDatePublication(LocalDate.of(annee, 1, 1));
    }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) throw new IllegalArgumentException("ISBN vide");
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livre livre = (Livre) o;
        return Objects.equals(titre, livre.titre) &&
                Objects.equals(auteur, livre.auteur) &&
                Objects.equals(datePublication, livre.datePublication) &&
                Objects.equals(isbn, livre.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titre, auteur, datePublication, isbn);
    }
}