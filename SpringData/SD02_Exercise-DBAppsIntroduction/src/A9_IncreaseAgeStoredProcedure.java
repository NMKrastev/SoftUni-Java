import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class A9_IncreaseAgeStoredProcedure {

    private static final String CREATE_GET_OLDER_PROCEDURE =
            "DROP PROCEDURE IF EXISTS usp_get_older; " +
            "DELIMITER $$" +
            "CREATE PROCEDURE usp_get_older(minion_id INT) " +
            "BEGIN " +
            "UPDATE minions " +
            "SET age = age + 1 " +
            "WHERE id = ?; " +
            "END $$";
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

        int minionID = Integer.parseInt(scanner.nextLine());

        final PreparedStatement createGetOlderProcedure = getPreparedStatement(connection, minionID, CREATE_GET_OLDER_PROCEDURE);

        final PreparedStatement callGetOlderStatement = getPreparedStatement(connection, minionID, CALL_OLDER_PROCEDURE);
        callGetOlderStatement.executeUpdate();

        final PreparedStatement selectMinionStatement = getPreparedStatement(connection, minionID, SELECT_MINION_NAME_AGE);

        final ResultSet rs = selectMinionStatement.executeQuery();
        rs.next();

        String name = rs.getString(COLUMN_LABEL_NAME);
        int age = rs.getInt(COLUMN_LABEL_AGE);

        System.out.printf(PRINT_MINION_FORMAT, name, age);
    }

    private static PreparedStatement getPreparedStatement(Connection connection, int minionID, String statement) throws SQLException {

        final PreparedStatement stmt = connection.prepareStatement(statement);
        stmt.setInt(1, minionID);

        return stmt;
    }
}
