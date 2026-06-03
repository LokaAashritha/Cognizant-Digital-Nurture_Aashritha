import java.util.Scanner;

public class Exercise05_MultiplicationTable {

    public static void main(String[] args) {

        Scanner userInputReader = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int selectedNumberValue = userInputReader.nextInt();

        System.out.println("Multiplication Table of " + selectedNumberValue);

        for (int tableCounterValue = 1; tableCounterValue <= 10; tableCounterValue++) {
            int calculatedProductValue = selectedNumberValue * tableCounterValue;

            System.out.println(selectedNumberValue + " x "
                    + tableCounterValue + " = "
                    + calculatedProductValue);
        }

        userInputReader.close();
    }
}