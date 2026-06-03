import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Exercise33_TransactionHandlingJDBC {

    private static final String databaseUrlValue =
            "jdbc:mysql://localhost:3306/corejava_exercises_db";

    private static final String databaseUserNameValue =
            "root";

    private static final String databasePasswordValue =
            "your_password";

    public static void transferAmount(double transferAmountValue,
                                      int senderAccountIdValue,
                                      int receiverAccountIdValue) {

        Connection databaseConnectionValue = null;

        try {

            databaseConnectionValue =
                    DriverManager.getConnection(
                            databaseUrlValue,
                            databaseUserNameValue,
                            databasePasswordValue
                    );

            databaseConnectionValue.setAutoCommit(false);

            String debitQueryValue =
                    "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";

            PreparedStatement debitStatementValue =
                    databaseConnectionValue.prepareStatement(
                            debitQueryValue
                    );

            debitStatementValue.setDouble(
                    1,
                    transferAmountValue
            );

            debitStatementValue.setInt(
                    2,
                    senderAccountIdValue
            );

            debitStatementValue.executeUpdate();

            String creditQueryValue =
                    "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

            PreparedStatement creditStatementValue =
                    databaseConnectionValue.prepareStatement(
                            creditQueryValue
                    );

            creditStatementValue.setDouble(
                    1,
                    transferAmountValue
            );

            creditStatementValue.setInt(
                    2,
                    receiverAccountIdValue
            );

            creditStatementValue.executeUpdate();

            databaseConnectionValue.commit();

            System.out.println(
                    "Transaction completed successfully."
            );

            debitStatementValue.close();
            creditStatementValue.close();

        } catch (Exception databaseExceptionValue) {

            try {

                if (databaseConnectionValue != null) {

                    databaseConnectionValue.rollback();

                    System.out.println(
                            "Transaction rolled back."
                    );
                }

            } catch (Exception rollbackExceptionValue) {

                System.out.println(
                        rollbackExceptionValue.getMessage()
                );
            }

            System.out.println(
                    "Transaction Error: "
                            + databaseExceptionValue.getMessage()
            );

        } finally {

            try {

                if (databaseConnectionValue != null) {

                    databaseConnectionValue.close();
                }

            } catch (Exception closingExceptionValue) {

                System.out.println(
                        closingExceptionValue.getMessage()
                );
            }
        }
    }

    public static void main(String[] args) {

        transferAmount(
                1000.00,
                101,
                102
        );
    }
}