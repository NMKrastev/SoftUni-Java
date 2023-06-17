import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class A6_RemoveVillain {

    private static final String GET_VILLAIN = "SELECT * FROM villains WHERE id = ?;";
    private static final String GET_RELEASED_MINIONS =
            "SELECT COUNT(minion_id) AS `count` " +
                    "FROM minions_villains " +
                    "WHERE villain_id = ?;";
    private static final String DELETE_RELATION_MINIONS_VILLAIN =
            "DELETE " +
                    "FROM minions_villains " +
                    "WHERE villain_id = ?;";
    private static final String DELETE_VILLAIN =
            "DELETE " +
                    "FROM villains " +
                    "WHERE id = ?;";

    private static final String VILLAIN_WAS_DELETED = "%s was deleted\n";
    private static final String RELEASED_MINIONS_COUNT = "%d minions released\n";
    private static final String NO_SUCH_VILLAIN = "No such villain was found";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        final Connection connection = Utils.getSQLConnection();

        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        final PreparedStatement findVillainStatement = prepareStatement(connection, id, GET_VILLAIN);

        final ResultSet findVillainResultSet = getExecutedQuery(findVillainStatement);

        if (findVillainResultSet.next()) {

            final PreparedStatement getReleasedMinionsStatement = prepareStatement(connection, id, GET_RELEASED_MINIONS);

            final ResultSet getReleasedMinionsResultSet = getExecutedQuery(getReleasedMinionsStatement);

            getReleasedMinionsResultSet.next();

            int releasedMinionsCount = getReleasedMinionsResultSet.getInt("count");

            String villainName = findVillainResultSet.getString("name");

            deleteStatement(connection, id, DELETE_RELATION_MINIONS_VILLAIN);

            deleteStatement(connection, id, DELETE_VILLAIN);

            System.out.printf(VILLAIN_WAS_DELETED, villainName);
            System.out.printf(RELEASED_MINIONS_COUNT, releasedMinionsCount);

        } else {

            System.out.println(NO_SUCH_VILLAIN);
        }
    }

    private static void deleteStatement(Connection connection, int id, String deleteStatement) throws SQLException {

        final PreparedStatement statement = connection.prepareStatement(deleteStatement);
        statement.setInt(1, id);

        statement.executeUpdate();
    }

    private static ResultSet getExecutedQuery(PreparedStatement statement) throws SQLException {

        return statement.executeQuery();
    }

    private static PreparedStatement prepareStatement(Connection connection, int id, String selectStatement) throws SQLException {

        final PreparedStatement statement = connection.prepareStatement(selectStatement);
        statement.setInt(1, id);

        return statement;
    }
}
