import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class A3_AddMinion {

    private static final String GET_VILLAIN = "SELECT * FROM villains WHERE name = ?;";
    private static final String ADD_VILLAIN =
            "INSERT INTO villains(name, evilness_factor) " +
                    "VALUES (?, 'evil');";
    private static final String GET_TOWN = "SELECT * FROM towns WHERE name = ?;";
    private static final String ADD_TOWN =
            "INSERT INTO towns(name) " +
                    "VALUES (?);";
    private static final String ADD_MINION =
            "INSERT INTO minions(name, age, town_id) " +
                    "VALUES (?, ?, (SELECT id FROM towns AS t WHERE t.name = ?));";
    private static final String GET_MINION = "SELECT * FROM minions WHERE name = ?;";

    private static final String ADD_RELATIONS_MINIONS_VILLAINS =
            "INSERT INTO minions_villains " +
                    "VALUES ((SELECT m.id FROM minions AS m WHERE m.name = ?), " +
                    "        (SELECT v.id FROM villains AS v WHERE v.name = ?));";
    private static final String GET_RELATION_MINIONS_VILLAINS =
            "SELECT minion_id, villain_id " +
                    "FROM minions_villains " +
                    "WHERE minion_id = (SELECT id FROM minions WHERE name = ?) " +
                    "  AND villain_id = (SELECT id FROM villains WHERE name = ?);";

    private static final String VILLAIN_ADDED = "Villain %s was added to the database.\n";
    private static final String TOWN_ADDED = "Town %s was added to the database.\n";
    private static final String MINION_ADDED = "Successfully added %s to be minion of %s\n";
    private static final String VALUE_NOT_ADDED = "%s is not added to database!\n";
    private static final String MINION_NOT_ADDED = "Minion is not added to database!";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        final Connection connection = Utils.getSQLConnection();

        //System.out.println("Enter minion info: ");
        String[] minionInfo = scanner.nextLine().split(":\\s+|\\s+");
        final String minionName = minionInfo[1];
        final int minionAge = Integer.parseInt(minionInfo[2]);
        final String minionTownName = minionInfo[3];

        //System.out.println("Enter villain name: ");
        final String villainName = scanner.nextLine().split(":\\s+")[1];

        addTownIfDoesNotExists(connection, minionTownName);

        addVillainIfDoesNotExists(connection, villainName);

        addMinionIfDoesNotExists(connection, minionName, minionAge, minionTownName, villainName);
    }

    private static void addMinionIfDoesNotExists(Connection connection, String minionName, int minionAge, String minionTownName, String villainName) throws SQLException {

        final PreparedStatement addMinionStatement = connection.prepareStatement(ADD_MINION);
        addMinionStatement.setString(1, minionName);
        addMinionStatement.setInt(2, minionAge);
        addMinionStatement.setString(3, minionTownName);

        addMinionStatement.executeUpdate();

        final PreparedStatement addRelationMinionsVillains = connection.prepareStatement(ADD_RELATIONS_MINIONS_VILLAINS);
        addRelationMinionsVillains.setString(1, minionName);
        addRelationMinionsVillains.setString(2, villainName);

        addRelationMinionsVillains.executeUpdate();

        System.out.printf(MINION_ADDED, minionName, villainName);

        //Additional check if the insert is successful

        final PreparedStatement findMinionStatement = connection.prepareStatement(GET_MINION);
        findMinionStatement.setString(1, minionName);

        final PreparedStatement getRelationStatement = connection.prepareStatement(GET_RELATION_MINIONS_VILLAINS);
        getRelationStatement.setString(1, minionName);
        getRelationStatement.setString(2, villainName);

        final ResultSet getMinionSet = findMinionStatement.executeQuery();

        final ResultSet getRelationsSet = getRelationStatement.executeQuery();

        if (getMinionSet.next() & getRelationsSet.next()) {
            System.out.printf(MINION_ADDED, minionName, villainName);
        } else {
            System.out.println(MINION_NOT_ADDED);
        }
    }

    private static void addTownIfDoesNotExists(Connection connection, String minionTownName) throws SQLException {

        insertValuesInDatabase(connection, minionTownName, GET_TOWN, ADD_TOWN, TOWN_ADDED);
    }

    private static void addVillainIfDoesNotExists(Connection connection, String villainName) throws SQLException {

        insertValuesInDatabase(connection, villainName, GET_VILLAIN, ADD_VILLAIN, VILLAIN_ADDED);
    }

    private static void insertValuesInDatabase(Connection connection, String name, String getStatement, String addStatement, String message) throws SQLException {

        final PreparedStatement getValueStatement = connection.prepareStatement(getStatement);
        getValueStatement.setString(1, name);

        ResultSet getValueSet = getValueStatement.executeQuery();

        if (!getValueSet.next()) {

            final PreparedStatement addValueStatement = connection.prepareStatement(addStatement);
            addValueStatement.setString(1, name);

            addValueStatement.executeUpdate();

            System.out.printf(message, name);

            //Additional check if the insert is successful

            getValueSet = getValueStatement.executeQuery();

            if (getValueSet.next()) {
                System.out.printf(message, name);
            } else {
                System.out.printf(VALUE_NOT_ADDED, name);
            }
        }
    }
}
