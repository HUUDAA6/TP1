import com.project.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class MainTest {

    private final InputStream originalSystemIn = System.in;

    @AfterEach
    void restoreSystemIn() {
        System.setIn(originalSystemIn); // Restauration impérative après chaque test
    }

    @Test
    void testScenarioComplet() {
        // Simulation d'un utilisateur qui :
        // 1. Choisit l'option 1 (MAD -> EUR)
        // 2. Entre 100
        // 3. Choisit l'option 3 (Quitter)
        String input = "1\n100\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Exécution du main (ne doit pas planter)
        Main.main(new String[]{});
    }
}