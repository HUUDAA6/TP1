import com.project.ExchangeRate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExchangeRateTest {

    private final ExchangeRate exchangeRate = new ExchangeRate();

    @Test
    void testGettersInitialValues() {
        // Vérifie que les taux par défaut sont corrects au démarrage
        assertEquals(0.09, exchangeRate.getMadToEurRate(), "Le taux initial MAD->EUR devrait être 0.09");
        assertEquals(11.11, exchangeRate.getEurToMadRate(), "Le taux initial EUR->MAD devrait être 11.11");
    }

    @Test
    void testSetMadToEurRateValide() {
        // Vérifie la mise à jour correcte avec une valeur valide
        exchangeRate.setMadToEurRate(0.12);
        assertEquals(0.12, exchangeRate.getMadToEurRate());
    }

    @Test
    void testSetMadToEurRateInvalide() {
        // Vérifie que l'application lève une exception pour un taux négatif
        Exception exceptionNegative = assertThrows(IllegalArgumentException.class, () -> {
            exchangeRate.setMadToEurRate(-0.5);
        });
        assertEquals("Rate must be positive", exceptionNegative.getMessage());

        // Vérifie que l'application lève une exception pour un taux nul (0)
        Exception exceptionZero = assertThrows(IllegalArgumentException.class, () -> {
            exchangeRate.setMadToEurRate(0);
        });
        assertEquals("Rate must be positive", exceptionZero.getMessage());
    }
}