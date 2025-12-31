package com.project;

import java.time.LocalDate;

public class Livre {
    private String titre;
    private String auteur;
    private LocalDate datePublication; // Changed from int to LocalDate

    // Constructor
    public Livre(String titre, String auteur, LocalDate datePublication) {
        this.titre = titre;
        this.auteur = auteur;
        // We validate immediately upon creation to prevent invalid objects
        validerDatePublication(datePublication);
        this.datePublication = datePublication;
    }

    // Validation Method (Functionality from Exercise 3.2 & 3.6)
    public void validerDatePublication(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("La date de publication ne peut pas être nulle.");
        }

        int annee = date.getYear();
        int anneeActuelle = LocalDate.now().getYear();

        // Rule: Year must be between 1000 and Current Year
        if (annee < 1000 || annee > anneeActuelle) {
            throw new IllegalArgumentException("L'année de publication doit être comprise entre 1000 et " + anneeActuelle);
        }
    }

    // Getters and Setters
    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        validerDatePublication(datePublication);
        this.datePublication = datePublication;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", datePublication=" + datePublication +
                '}';
    }
}