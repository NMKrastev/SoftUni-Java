import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class A9_IncreaseAgeStoredProcedure {

    private static final String CREATE_GET_OLDER_PROCEDURE =
            """
                    DROP PROCEDURE IF EXISTS usp_get_older;
                    CREATE PROCEDURE usp_get_older(minion_id INT)
                    BEGIN
                    UPDATE minions AS m SET m.age = m.age + 1 WHERE id = minion_id;
                    END;
                    """;
    private static final String CALL_OLDER_PROCEDURE = "CALL usp_get_older(?);";
    private static final String SELECT_MINION_NAME_AGE =
            "SELECT name, " +
                    "age " +
                    "FROM minions " +
                    "WHERE id = ?;";
    private static final String PRINT_MINION_FORMAT = "%s %d\n";
    private static final String COLUMN_LABEL_NAME = "name";
    private static final String COLUMN_LABEL_AGE = "age";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        final Connection connection = Utils.getSQLConnection();

        System.out.print("Enter minion ID: ");
        int minionID = Integer.parseInt(scanner.nextLine());

        final PreparedStatement selectMinionStatement = getPreparedStatement(connection, minionID, SELECT_MINION_NAME_AGE);

        ResultSet rs = selectMinionStatement.executeQuery();
        rs.next();

        String name = rs.getString(COLUMN_LABEL_NAME);
        int age = rs.getInt(COLUMN_LABEL_AGE);

        System.out.print("Minion age before: ");
        System.out.printf(PRINT_MINION_FORMAT, name, age);

        final PreparedStatement createGetOlderProcedure = connection.prepareStatement(CREATE_GET_OLDER_PROCEDURE);
        createGetOlderProcedure.execute();

        final PreparedStatement callGetOlderStatement = getPreparedStatement(connection, minionID, CALL_OLDER_PROCEDURE);
        callGetOlderStatement.executeUpdate();

        rs = selectMinionStatement.executeQuery();
        rs.next();

        name = rs.getString(COLUMN_LABEL_NAME);
        age = rs.getInt(COLUMN_LABEL_AGE);

        System.out.print("Minion age after: ");
        System.out.printf(PRINT_MINION_FORMAT, name, age);
    }

    private static PreparedStatement getPreparedStatement(Connection connection, int minionID, String statement) throws SQLException {

        final PreparedStatement stmt = connection.prepareStatement(statement);
        stmt.setInt(1, minionID);

        return stmt;
    }
}
