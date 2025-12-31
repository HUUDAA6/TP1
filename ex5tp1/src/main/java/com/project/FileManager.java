package com.project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {

    /**
     * Lit le contenu d'un fichier et le retourne sous forme de chaîne.
     * @param filePath Le chemin vers le fichier.
     * @return Le contenu du fichier.
     * @throws IOException Si le fichier n'existe pas ou ne peut pas être lu.
     */
    public String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);

        // La méthode readString (Java 11+) lève automatiquement 
        // une NoSuchFileException (qui hérite de IOException) si le fichier n'existe pas.
        return Files.readString(path);
    }
}