import com.project.Livre;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class LivreTest {

    // Test 1: Valid Date (Standard Case)
    @Test
    void testDatePublicationValide() {
        LocalDate dateValide = LocalDate.of(2020, 1, 1);
        Livre livre = new Livre("Java Programming", "John Doe", dateValide);
        assertEquals(dateValide, livre.getDatePublication());
    }

    // Test 2: Invalid Date - Future Year (Exception Expected)
    @Test
    void testDatePublicationFutur() {
        LocalDate dateFutur = LocalDate.now().plusYears(1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Livre("Future Book", "Jane Doe", dateFutur);
        });
        // We check the message to be sure it's the right error
        assertTrue(exception.getMessage().contains("L'année de publication doit être comprise"));
    }

    // Test 3: Invalid Date - Too Old (Before 1000)
    @Test
    void testDatePublicationTropAncienne() {
        LocalDate dateAncienne = LocalDate.of(999, 12, 31);
        assertThrows(IllegalArgumentException.class, () -> {
            new Livre("Ancient Book", "Old Author", dateAncienne);
        });
    }

    // Test 4: Boundary Condition - Year 1000 (Should be Valid)
    @Test
    void testDateLimiteBasse() {
        LocalDate dateLimite = LocalDate.of(1000, 1, 1);
        assertDoesNotThrow(() -> new Livre("Limit Book", "Author", dateLimite));
    }

    // Test 5: Boundary Condition - Current Year (Should be Valid)
    @Test
    void testDateLimiteHaute() {
        LocalDate dateActuelle = LocalDate.now();
        assertDoesNotThrow(() -> new Livre("New Release", "Author", dateActuelle));
    }

    // Test 6: Null Date
    @Test
    void testDateNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Livre("Null Book", "Author", null);
        });
    }
}