import java.util.ArrayList;
import java.util.Scanner;

public class Exercise24_ArrayListExample {

    public static void main(String[] args) {

        Scanner studentInputReader = new Scanner(System.in);

        ArrayList<String> studentNameListValue =
                new ArrayList<>();

        System.out.print("How many student names do you want to add? ");
        int totalStudentCountValue =
                studentInputReader.nextInt();

        studentInputReader.nextLine();

        for (int studentCounterValue = 1;
             studentCounterValue <= totalStudentCountValue;
             studentCounterValue++) {

            System.out.print("Enter student name "
                    + studentCounterValue + ": ");

            String enteredStudentNameValue =
                    studentInputReader.nextLine();

            studentNameListValue.add(
                    enteredStudentNameValue
            );
        }

        System.out.println("\nStudent Names:");

        for (String studentNameValue : studentNameListValue) {

            System.out.println(studentNameValue);
        }

        studentInputReader.close();
    }
}