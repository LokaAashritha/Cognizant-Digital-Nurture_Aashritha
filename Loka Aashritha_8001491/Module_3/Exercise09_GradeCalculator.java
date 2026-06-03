import java.util.Scanner;

public class Exercise09_GradeCalculator {

    public static void main(String[] args) {

        Scanner marksInputReader = new Scanner(System.in);

        System.out.print("Enter marks (0-100): ");
        int studentMarksValue = marksInputReader.nextInt();

        if (studentMarksValue >= 90 && studentMarksValue <= 100) {
            System.out.println("Grade: A");
        } else if (studentMarksValue >= 80) {
            System.out.println("Grade: B");
        } else if (studentMarksValue >= 70) {
            System.out.println("Grade: C");
        } else if (studentMarksValue >= 60) {
            System.out.println("Grade: D");
        } else if (studentMarksValue >= 0) {
            System.out.println("Grade: F");
        } else {
            System.out.println("Invalid Marks");
        }

        marksInputReader.close();
    }
}