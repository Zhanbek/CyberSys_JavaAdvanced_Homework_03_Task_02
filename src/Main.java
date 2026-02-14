import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "src/myFile.txt";
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fileWriter = new FileWriter(FILE_PATH)) {

            System.out.println();
            System.out.println("Введіть дані (для завершення введіть \"Stop\"):");
            System.out.println();

            String line;
            while(!(line = bufferedReader.readLine()).equalsIgnoreCase("Stop")) {
                fileWriter.write(line + System.lineSeparator());
            }
            System.out.println();
            System.out.println("Всі введені в консоль данние успішно передані в файл: " + FILE_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        System.out.println("А тепер виведемо дані з файлу " + FILE_PATH);
        System.out.println();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
            String line;
            while ((line  = bufferedReader.readLine()) != null) {
                System.out.println(line);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}