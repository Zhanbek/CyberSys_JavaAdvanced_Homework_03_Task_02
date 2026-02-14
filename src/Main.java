import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "src/myFile.txt";
    public static void main(String[] args) {

        try (FileWriter fileWriter = new FileWriter(FILE_PATH)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println();
            System.out.println("Введіть у консоль дані, які потрібно передати у файл: " + FILE_PATH);
            System.out.println("Для завершения ввода данных введите строку \"Stop\": ");
            System.out.println();

            String line  = bufferedReader.readLine();
            while(!line.equalsIgnoreCase("Stop")){
                fileWriter.write(line);
                fileWriter.write("\n");
                line  = bufferedReader.readLine();
            }
            System.out.println();
            System.out.println("Всі введені в консоль данние успішно передані в файл: " + FILE_PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        System.out.println("А тепер виведемо дані з файлу " + FILE_PATH);
        System.out.println();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
            String line  = bufferedReader.readLine();
            while (line  != null) {
                System.out.println(line);
                line  = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}