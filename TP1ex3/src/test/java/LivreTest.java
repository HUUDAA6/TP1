import com.project.Livre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class LivreTest {

    // --- Q3: Test unitaire de la nouvelle validation (Valide vs Invalide) ---
    @Test
    @DisplayName("Ex3 Q3: Validation date correcte")
    void testDatePublicationValide() {
        LocalDate dateValide = LocalDate.of(2020, 5, 20);
        Livre livre = new Livre("Java Time", "Dev", dateValide, "ISBN123");
        assertEquals(dateValide, livre.getDatePublication());
    }

    @Test
    @DisplayName("Ex3 Q3/Q7: Validation date invalide (Exception attendue)")
    void testDatePublicationInvalide() {
        // Test année < 1000
        LocalDate dateTropAncienne = LocalDate.of(900, 1, 1);
        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> {
            new Livre("Ancien", "Auteur", dateTropAncienne, "ISBN");
        });
        assertTrue(ex1.getMessage().contains("entre 1000"));

        // Test année > Actuelle
        int futur = Year.now().getValue() + 5;
        LocalDate dateFuture = LocalDate.of(futur, 1, 1);
        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> {
            new Livre("Futur", "Auteur", dateFuture, "ISBN");
        });
        assertTrue(ex2.getMessage().contains("entre 1000"));
    }

    // --- Q4: Test de compatibilité (Ancienne méthode int) ---
    @Test
    @DisplayName("Ex3 Q4: Compatibilité avec l'ancien système (int)")
    void testCompatibiliteAncienSysteme() {
        // Utilisation du constructeur (int)
        Livre livre = new Livre("Legacy", "Old Dev", 1999, "ISBN-OLD");

        // Vérification via getter int
        assertEquals(1999, livre.getAnneePublication());

        // Vérification que la conversion en LocalDate s'est bien faite (1er Janvier)
        assertEquals(LocalDate.of(1999, 1, 1), livre.getDatePublication());
    }

    // --- Q5: Test de performance avec LocalDate ---
    @Test
    @DisplayName("Ex3 Q5: Performance avec LocalDate")
    void testPerformanceDate() {
        assertTimeout(Duration.ofMillis(200), () -> {
            for (int i = 0; i < 10000; i++) {
                // Création massive avec validation de date
                new Livre("Titre", "Auteur", LocalDate.now(), "ISBN");
            }
        });
    }

    // --- Q8: Cas limites (Frontières de la plage 1000 - Année courante) ---
    @Test
    @DisplayName("Ex3 Q8: Cas limites (1000 et Année Actuelle)")
    void testCasLimitesDates() {
        int anneeCourante = Year.now().getValue();

        // Limite basse exacte : An 1000 (Doit passer)
        assertDoesNotThrow(() -> new Livre("Moyen Age", "Moine", LocalDate.of(1000, 1, 1), "ISBN"));

        // Limite basse - 1 : An 999 (Doit échouer)
        assertThrows(IllegalArgumentException.class, () ->
                new Livre("Avant 1000", "X", LocalDate.of(999, 12, 31), "ISBN"));

        // Limite haute exacte : Année actuelle (Doit passer)
        assertDoesNotThrow(() -> new Livre("News", "Journ", LocalDate.of(anneeCourante, 12, 31), "ISBN"));

        // Limite haute + 1 : Année prochaine (Doit échouer)
        assertThrows(IllegalArgumentException.class, () ->
                new Livre("Futur Proche", "X", LocalDate.of(anneeCourante + 1, 1, 1), "ISBN"));
    }
}