import java.util.Scanner;

public class Exercise04_LeapYearChecker {

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int enteredYearValue = inputReader.nextInt();

        boolean leapYearStatus;

        if ((enteredYearValue % 4 == 0 && enteredYearValue % 100 != 0)
                || (enteredYearValue % 400 == 0)) {
            leapYearStatus = true;
        } else {
            leapYearStatus = false;
        }

        if (leapYearStatus) {
            System.out.println(enteredYearValue + " is a Leap Year");
        } else {
            System.out.println(enteredYearValue + " is not a Leap Year");
        }

        inputReader.close();
    }
}