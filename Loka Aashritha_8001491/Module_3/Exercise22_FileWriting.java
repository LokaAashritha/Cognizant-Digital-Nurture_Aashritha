import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise22_FileWriting {

    public static void main(String[] args) {

        Scanner fileInputReader = new Scanner(System.in);

        System.out.print("Enter text to write into file: ");
        String userTextValue = fileInputReader.nextLine();

        try {

            FileWriter outputFileWriter =
                    new FileWriter("output.txt");

            outputFileWriter.write(userTextValue);

            outputFileWriter.close();

            System.out.println(
                    "Data successfully written to output.txt"
            );

        } catch (IOException fileErrorValue) {

            System.out.println(
                    "Error while writing to file."
            );
        }

        fileInputReader.close();
    }
}