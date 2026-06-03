import java.util.Scanner;

public class Exercise11_FactorialCalculator {

    public static void main(String[] args) {

        Scanner factorialInputReader = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int enteredNumberValue = factorialInputReader.nextInt();

        long factorialResultValue = 1;

        for (int multiplicationCounterValue = 1;
             multiplicationCounterValue <= enteredNumberValue;
             multiplicationCounterValue++) {

            factorialResultValue *= multiplicationCounterValue;
        }

        System.out.println("Factorial = " + factorialResultValue);

        factorialInputReader.close();
    }
}