import java.util.Scanner;

public class Exercise15_StringReversal {

    public static void main(String[] args) {

        Scanner textInputReader = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String originalTextValue = textInputReader.nextLine();

        StringBuilder reversedTextBuilder = new StringBuilder(originalTextValue);

        System.out.println("Reversed String: "
                + reversedTextBuilder.reverse());

        textInputReader.close();
    }
}