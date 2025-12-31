import com.project.FileManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class FileManagerTest {

    private final FileManager fileManager = new FileManager();

    @Test
    void testReadFile_Success(@TempDir Path tempDir) throws IOException {
        // 1. Préparation : Créer un fichier réel dans un dossier temporaire
        Path tempFile = tempDir.resolve("monFichierTest.txt");
        String contenuAttendu = "Ceci est un test de lecture.";
        Files.writeString(tempFile, contenuAttendu);

        // 2. Exécution
        String resultat = fileManager.readFile(tempFile.toString());

        // 3. Vérification
        Assertions.assertEquals(contenuAttendu, resultat, "Le contenu lu doit correspondre au contenu écrit.");
    }

    @Test
    void testReadFile_FileNotFound() {
        // 1. Préparation : Définir un chemin qui n'existe pas
        String cheminInexistant = "chemin/qui/n/existe/pas/fichier.txt";

        // 2. Exécution & Vérification
        // On s'attend à ce que l'appel lève une IOException
        Assertions.assertThrows(IOException.class, () -> {
            fileManager.readFile(cheminInexistant);
        }, "Une IOException doit être levée si le fichier n'existe pas.");
    }
}