import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exercise31_BasicJDBCConnection {

    public static void main(String[] args) {

        String databaseUrlValue =
                "jdbc:mysql://localhost:3306/corejava_exercises_db";

        String databaseUserNameValue = "root";

        String databasePasswordValue = "mysqlPass#99";

        try {

            Connection databaseConnectionValue =
                    DriverManager.getConnection(
                            databaseUrlValue,
                            databaseUserNameValue,
                            databasePasswordValue
                    );

            Statement studentQueryStatementValue =
                    databaseConnectionValue.createStatement();

            ResultSet studentResultSetValue =
                    studentQueryStatementValue.executeQuery(
                            "SELECT * FROM students"
                    );

            System.out.println("Student Records");
            System.out.println("-------------------------");

            while (studentResultSetValue.next()) {

                int studentIdValue =
                        studentResultSetValue.getInt("id");

                String studentNameValue =
                        studentResultSetValue.getString("name");

                int studentAgeValue =
                        studentResultSetValue.getInt("age");

                System.out.println(
                        studentIdValue + " | "
                                + studentNameValue + " | "
                                + studentAgeValue
                );
            }

            studentResultSetValue.close();
            studentQueryStatementValue.close();
            databaseConnectionValue.close();

        } catch (Exception databaseExceptionValue) {

            System.out.println(
                    "Database Error: "
                            + databaseExceptionValue.getMessage()
            );
        }
    }
}
