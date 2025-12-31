import com.project.CurrencyConverter;
import com.project.ExchangeRate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CurrencyConverterTest {

    ExchangeRate rate = new ExchangeRate();
    CurrencyConverter converter = new CurrencyConverter(rate);

    @Test
    void testConvertMadToEur_Standard() {
        // Checking 100 MAD * 0.09 = 9 EUR
        assertEquals(9.0, converter.convertMadToEur(100), 0.001);
    }

    @Test
    void testConvertEurToMad_Standard() {
        // Checking 10 EUR * 11.11 = 111.1 MAD
        assertEquals(111.1, converter.convertEurToMad(10), 0.001);
    }

    @Test
    void testZeroAmount() {
        // Requirement: If amount is 0, result is 0 
        assertEquals(0.0, converter.convertMadToEur(0));
    }

    @Test
    void testNegativeAmountThrowsException() {
        // Requirement: Negative amount throws IllegalArgumentException 
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convertMadToEur(-50);
        });
    }

    @Test
    void testSetInvalidExchangeRate() {
        // Requirement: Test exceptions for negative/zero rates [cite: 31]
        assertThrows(IllegalArgumentException.class, () -> rate.setMadToEurRate(-1));
    }
}