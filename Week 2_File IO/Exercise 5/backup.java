
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class BackupApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileCopy fileCopy = new FileCopy();
        DirectoryCopy directoryCopy = new DirectoryCopy();

        System.out.print("Enter the source directory path: ");
        Path sourceDir = Paths.get(scanner.nextLine());

        System.out.print("Enter the target directory path: ");
        Path targetDir = Paths.get(scanner.nextLine());

        directoryCopy.copyDirectory(sourceDir, targetDir);

        System.out.println("\nDemonstrating error handling by attempting to copy to a non-existent directory:");
        Path nonExistentDir = Paths.get("non_existent_directory");
        directoryCopy.copyDirectory(sourceDir, nonExistentDir);
    }
}
