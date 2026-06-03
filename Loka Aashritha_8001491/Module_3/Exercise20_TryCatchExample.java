import java.util.Scanner;

public class Exercise20_TryCatchExample {

    public static void main(String[] args) {

        Scanner divisionInputReader = new Scanner(System.in);

        try {

            System.out.print("Enter first integer: ");
            int dividendValue = divisionInputReader.nextInt();

            System.out.print("Enter second integer: ");
            int divisorValue = divisionInputReader.nextInt();

            int divisionResultValue = dividendValue / divisorValue;

            System.out.println("Result = " + divisionResultValue);

        } catch (ArithmeticException arithmeticErrorValue) {

            System.out.println("Error: Division by zero is not allowed.");

        } finally {

            divisionInputReader.close();
        }
    }
}