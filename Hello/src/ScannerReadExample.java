import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerReadExample {
    public static void main(String[] args) {
        File file = new File("input.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("ファイルが見つかりません: " + e.getMessage());
        }
    }
}