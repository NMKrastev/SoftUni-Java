import java.sql.*;

public class A1_GetVillainsNames {

    private static final String GET_VILLAINS_NAMES_AND_MINIONS_COUNT =
            "SELECT v.name, COUNT(DISTINCT mv.minion_id) AS count " +
                    "FROM villains AS v " +
                    "JOIN minions_villains AS mv ON v.id = mv.villain_id " +
                    "GROUP BY v.id " +
                    "HAVING count > ? " +
                    "ORDER BY count DESC;";

    private static final String COLUMN_LABEL_NAME = "name";
    private static final String COLUMN_LABEL_COUNT = "count";
    private static final String PRINT_FORMAT = "%s %d\n";

    public static void main(String[] args) throws SQLException {

        final Connection connection = Utils.getSQLConnection();

        final PreparedStatement stmt = connection.prepareStatement(GET_VILLAINS_NAMES_AND_MINIONS_COUNT);

        stmt.setInt(1, 15);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            final String villainName = rs.getString(COLUMN_LABEL_NAME);
            final int minionsCount = rs.getInt(COLUMN_LABEL_COUNT);

            System.out.printf(PRINT_FORMAT, villainName, minionsCount);
        }

        connection.close();
    }
}
