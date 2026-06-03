import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class StudentDAO {

    private final String databaseUrlValue =
            "jdbc:mysql://localhost:3306/corejava_exercises_db";

    private final String databaseUserNameValue = "root";

    private final String databasePasswordValue = "mysqlPass#99";

    public void insertStudentRecord(int studentIdValue,
                                    String studentNameValue,
                                    int studentAgeValue) {

        String insertQueryValue =
                "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";

        try {

            Connection databaseConnectionValue =
                    DriverManager.getConnection(
                            databaseUrlValue,
                            databaseUserNameValue,
                            databasePasswordValue
                    );

            PreparedStatement insertStatementValue =
                    databaseConnectionValue.prepareStatement(
                            insertQueryValue
                    );

            insertStatementValue.setInt(1, studentIdValue);
            insertStatementValue.setString(2, studentNameValue);
            insertStatementValue.setInt(3, studentAgeValue);

            int insertedRowCountValue =
                    insertStatementValue.executeUpdate();

            System.out.println(
                    insertedRowCountValue
                            + " record inserted successfully."
            );

            insertStatementValue.close();
            databaseConnectionValue.close();

        } catch (Exception databaseExceptionValue) {

            System.out.println(
                    "Insert Error: "
                            + databaseExceptionValue.getMessage()
            );
        }
    }

    public void updateStudentAge(int studentIdValue,
                                 int updatedAgeValue) {

        String updateQueryValue =
                "UPDATE students SET age = ? WHERE id = ?";

        try {

            Connection databaseConnectionValue =
                    DriverManager.getConnection(
                            databaseUrlValue,
                            databaseUserNameValue,
                            databasePasswordValue
                    );

            PreparedStatement updateStatementValue =
                    databaseConnectionValue.prepareStatement(
                            updateQueryValue
                    );

            updateStatementValue.setInt(1, updatedAgeValue);
            updateStatementValue.setInt(2, studentIdValue);

            int updatedRowCountValue =
                    updateStatementValue.executeUpdate();

            System.out.println(
                    updatedRowCountValue
                            + " record updated successfully."
            );

            updateStatementValue.close();
            databaseConnectionValue.close();

        } catch (Exception databaseExceptionValue) {

            System.out.println(
                    "Update Error: "
                            + databaseExceptionValue.getMessage()
            );
        }
    }
}

public class Exercise32_InsertAndUpdateJDBC {

    public static void main(String[] args) {

        StudentDAO studentDaoObject = new StudentDAO();

        studentDaoObject.insertStudentRecord(
                4,
                "Arjun",
                24
        );

        studentDaoObject.updateStudentAge(
                4,
                25
        );
    }
}