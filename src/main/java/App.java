import java.util.Scanner;
import java.io.*;
import java.nio.charset.StandardCharsets;
import main_dict.dbToManager;
import main_dict.WordsManager;
import java.util.List;

public class App {

    /**
     * main.
     */

    public static void main(String[] args) {
        // Scanner FNScanner = new Scanner(System.in);
        // String path = FNScanner.nextLine();
        String path = "Eng.txt"; //delimiter : ~
        dbToManager.scan(path);
        List<String> List = WordsManager.suggestions("al");
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("suggestions.txt"), StandardCharsets.UTF_8);
            for (String str : List) {
                writer.write(str + "\n");
                writer.flush();
            }
        }
        catch (IOException e) {
            System.out.println("File not found!");
        }
        // try {
        //     path = dbToManager.pathGetter(path);
        //     Scanner scanner = new Scanner(new File(path), StandardCharsets.UTF_8);

        //     OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("Eng_Eng.txt"), StandardCharsets.UTF_8);

        //     while(scanner.hasNextLine()) {
        //         // writer.write(scanner.nextLine() + "\n");
        //         String line = scanner.nextLine();
        //         line = line.replace("@", ", ");
        //         writer.write(line + "\n");
        //         writer.flush();
        //     }

        // }
        // catch (IOException e) {
        //     System.out.println("File not found!");
        // }
    }
}