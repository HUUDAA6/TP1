package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
Question 4 et 5 (Validation) : Comme le code initial n'incluait aucune logique de validation, les tests auraient échoué immédiatement. La modification de la méthode setAnneePublication pour lever une IllegalArgumentException est cruciale pour que le test assertThrows passe correctement.

Question 6 (Performance) : L'utilisation de assertTimeout permet de vérifier que la création massive d'objets ne ralentit pas le système. Cela simule une charge importante, s'assurant que l'application reste réactive même sous une forte demande.

Question 8 (Encapsulation) : JUnit ne permet pas d'accéder directement aux champs privés, car cela provoquerait une erreur de compilation. Cependant, on peut utiliser la Réflexion (Java Reflection API) pour inspecter la classe à l'exécution et vérifier que les champs sont bien encapsulés avec des modificateurs `private`.

Question 10 (Compatibilité) : JUnit 5 est conçu de manière modulaire. Pour exécuter des tests JUnit 4 (qui utilisent org.junit.Test au lieu de org.junit.jupiter.api.Test), Maven utilise le moteur "Vintage". Le code ci-dessus utilise la syntaxe moderne de JUnit 5, assurant une meilleure compatibilité avec les nouvelles versions.
*/

public class Main {
    public static void main(String[] args) {
        Livre livre1 = new Livre("Harry Potter", "J.K. Rowling", 1997, "123456789");
        Livre livre2 = new Livre("1984", "George Orwell", 1949, "987654321");
        Bibliothèque bibliothèque = new Bibliothèque();
        bibliothèque.ajouterLivre(livre1);
        bibliothèque.ajouterLivre(livre2);
        Livre livreRecherche = bibliothèque.rechercherParTitre("Harry Potter");
        if (livreRecherche != null) {
            System.out.println("Livre trouvé : " + livreRecherche.getTitre());
        } else {
            System.out.println("Livre non trouvé.");
        }
    }
}
