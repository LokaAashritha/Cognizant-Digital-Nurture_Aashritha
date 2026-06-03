import java.util.HashMap;
import java.util.Scanner;

public class Exercise25_HashMapExample {

    public static void main(String[] args) {

        Scanner studentDataReader = new Scanner(System.in);

        HashMap<Integer, String> studentRecordMapValue =
                new HashMap<>();

        System.out.print("How many students do you want to add? ");
        int totalStudentEntriesValue =
                studentDataReader.nextInt();

        studentDataReader.nextLine();

        for (int recordCounterValue = 1;
             recordCounterValue <= totalStudentEntriesValue;
             recordCounterValue++) {

            System.out.print("Enter Student ID: ");
            int studentIdValue =
                    studentDataReader.nextInt();

            studentDataReader.nextLine();

            System.out.print("Enter Student Name: ");
            String studentNameValue =
                    studentDataReader.nextLine();

            studentRecordMapValue.put(
                    studentIdValue,
                    studentNameValue
            );
        }

        System.out.print("\nEnter Student ID to search: ");
        int searchStudentIdValue =
                studentDataReader.nextInt();

        if (studentRecordMapValue.containsKey(searchStudentIdValue)) {

            System.out.println(
                    "Student Name: "
                    + studentRecordMapValue.get(searchStudentIdValue)
            );

        } else {

            System.out.println("Student ID not found.");
        }

        studentDataReader.close();
    }
}