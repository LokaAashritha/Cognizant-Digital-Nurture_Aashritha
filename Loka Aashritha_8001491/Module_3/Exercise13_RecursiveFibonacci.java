import java.util.Scanner;

public class Exercise13_RecursiveFibonacci {

    public static int fibonacci(int positionValue) {

        if (positionValue <= 1) {
            return positionValue;
        }

        return fibonacci(positionValue - 1)
                + fibonacci(positionValue - 2);
    }

    public static void main(String[] args) {

        Scanner fibonacciInputReader = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int enteredPositionValue = fibonacciInputReader.nextInt();

        System.out.println("Fibonacci Number: "
                + fibonacci(enteredPositionValue));

        fibonacciInputReader.close();
    }
}
