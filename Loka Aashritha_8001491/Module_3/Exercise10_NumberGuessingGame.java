import java.util.Random;
import java.util.Scanner;

public class Exercise10_NumberGuessingGame {

    public static void main(String[] args) {

        Scanner guessInputReader = new Scanner(System.in);
        Random randomNumberGenerator = new Random();

        int targetNumberValue = randomNumberGenerator.nextInt(100) + 1;
        int userGuessValue = 0;

        System.out.println("Guess a number between 1 and 100");

        while (userGuessValue != targetNumberValue) {

            System.out.print("Enter your guess: ");
            userGuessValue = guessInputReader.nextInt();

            if (userGuessValue < targetNumberValue) {
                System.out.println("Too Low!");
            } else if (userGuessValue > targetNumberValue) {
                System.out.println("Too High!");
            } else {
                System.out.println("Congratulations! You guessed the number.");
            }
        }

        guessInputReader.close();
    }
}