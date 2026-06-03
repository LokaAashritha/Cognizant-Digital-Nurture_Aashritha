import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise23_FileReading {

    public static void main(String[] args) {

        try {

            File inputFileObject = new File("output.txt");

            Scanner fileContentReader = new Scanner(inputFileObject);

            System.out.println("File Contents:");

            while (fileContentReader.hasNextLine()) {

                String currentLineValue =
                        fileContentReader.nextLine();

                System.out.println(currentLineValue);
            }

            fileContentReader.close();

        } catch (FileNotFoundException fileNotFoundErrorValue) {

            System.out.println("output.txt file not found.");
        }
    }
}