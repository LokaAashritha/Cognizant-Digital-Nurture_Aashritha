import java.util.Scanner;

public class Exercise16_PalindromeChecker {

    public static void main(String[] args) {

        Scanner palindromeInputReader = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String enteredTextValue = palindromeInputReader.nextLine();

        String cleanedTextValue =
                enteredTextValue.replaceAll("[^a-zA-Z0-9]", "")
                                .toLowerCase();

        String reversedTextValue =
                new StringBuilder(cleanedTextValue)
                        .reverse()
                        .toString();

        if (cleanedTextValue.equals(reversedTextValue)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        palindromeInputReader.close();
    }
}