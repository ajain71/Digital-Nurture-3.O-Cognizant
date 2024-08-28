
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class DirectoryCopy {
    public void copyDirectory(Path sourceDir, Path targetDir) {
        try (Stream<Path> paths = Files.walk(sourceDir)) {
            paths.forEach(sourcePath -> {
                Path targetPath = targetDir.resolve(sourceDir.relativize(sourcePath));
                try {
                    Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.out.println("An error occurred while copying directory: " + e.getMessage());
                }
            });
            System.out.println("Directory copied from " + sourceDir + " to " + targetDir);
        } catch (IOException e) {
            System.out.println("An error occurred while walking the file tree: " + e.getMessage());
        }
    }
}
