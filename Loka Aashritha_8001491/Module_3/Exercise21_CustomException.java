import java.util.Scanner;

class InvalidAgeException extends Exception {

    public InvalidAgeException(String errorMessageValue) {
        super(errorMessageValue);
    }
}

public class Exercise21_CustomException {

    public static void validateAge(int enteredAgeValue)
            throws InvalidAgeException {

        if (enteredAgeValue < 18) {
            throw new InvalidAgeException(
                    "Age must be 18 or above."
            );
        }

        System.out.println("Age is valid.");
    }

    public static void main(String[] args) {

        Scanner ageInputReader = new Scanner(System.in);

        try {

            System.out.print("Enter your age: ");
            int userAgeValue = ageInputReader.nextInt();

            validateAge(userAgeValue);

        } catch (InvalidAgeException invalidAgeErrorValue) {

            System.out.println(
                    "Exception: " + invalidAgeErrorValue.getMessage()
            );

        } finally {

            ageInputReader.close();
        }
    }
}