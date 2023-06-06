import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A4_ChangeTownNamesCasing {

    private static final String FIND_COUNTRY = "SELECT * FROM towns WHERE country = ?;";
    private static final String UPDATE_TOWN =
            "UPDATE towns AS t " +
                    "SET t.name = UPPER(t.name) " +
                    "WHERE t.country = ?;";
    private static final String GET_AFFECTED_TOWNS =
            "SELECT name " +
                    "FROM towns " +
                    "WHERE country = ?;";

    private static final String AFFECTED_TOWNS = "%s town names were affected.\n";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        final Connection connection = Utils.getSQLConnection();

        //System.out.print("Enter country: ");
        String country = scanner.nextLine();

        final PreparedStatement getCountryStatement = connection.prepareStatement(FIND_COUNTRY);
        getCountryStatement.setString(1, country);

        ResultSet getCountrySet = getCountryStatement.executeQuery();

        if (getCountrySet.next()) {

            updateTown(connection, country);

            final PreparedStatement getAffectedTownsStatement = getAffectedTowns(connection, country);

            ResultSet affectedTownsResultSet = getAffectedTownsStatement.executeQuery();

            List<String> townsList = new ArrayList<>();

            addTownsToList(affectedTownsResultSet, townsList);

            System.out.printf(AFFECTED_TOWNS, townsList.size());
            System.out.println(townsList);

        } else {

            System.out.println("No town names were affected.");
        }
    }

    private static void addTownsToList(ResultSet affectedTownsResultSet, List<String> townsList) throws SQLException {

        while (affectedTownsResultSet.next()) {

            String townName = affectedTownsResultSet.getString("name");

            townsList.add(townName);
        }
    }

    private static PreparedStatement getAffectedTowns(Connection connection, String country) throws SQLException {

        final PreparedStatement getAffectedTownsStatement = connection.prepareStatement(GET_AFFECTED_TOWNS);
        getAffectedTownsStatement.setString(1, country);

        return getAffectedTownsStatement;
    }

    private static void updateTown(Connection connection, String country) throws SQLException {

        final PreparedStatement updateTownStatement = connection.prepareStatement(UPDATE_TOWN);
        updateTownStatement.setString(1, country);

        updateTownStatement.executeUpdate();
    }
}
