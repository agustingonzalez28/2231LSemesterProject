package textReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The FileMover class moves files from an input directory to another specified directory.
 */
public class FileMover {
    /**
     * This method moves file with String filePath file path to "src/DataSets/NewArticles".
     *
     * @param filePath A String that is the file path of the file to be moved
     */
    public static void fileMover (String filePath) {
        // Source file path
        Path sourcePath = Paths.get(filePath);

        // Target directory path
        Path targetDirectory = Paths.get("src/DataSets/NewArticles");

        // Ensure the target directory exists
        try {
            if (!Files.exists(targetDirectory)) {
                Files.createDirectories(targetDirectory); // create the folder
            }

            // Move the file
            Files.move(sourcePath, targetDirectory.resolve(sourcePath.getFileName()));
            System.out.println("File moved successfully!");
        } catch (IOException e) {
            System.err.println("An error occurred while moving the file: " + e.getMessage());
        }
    }
}
