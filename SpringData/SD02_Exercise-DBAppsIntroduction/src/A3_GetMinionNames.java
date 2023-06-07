import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class A2_GetMinionNames {

    private static final String GET_MINION_NAMES =
            "SELECT DISTINCT m.name, m.age, v.name AS villain_name " +
                    "FROM minions AS m " +
                    "JOIN minions_villains AS mv ON m.id = mv.minion_id " +
                    "JOIN villains AS v ON v.id = mv.villain_id " +
                    "WHERE mv.villain_id = ?;";

    private static final String COLUMN_LABEL_MINION_NAME = "name";
    private static final String COLUMN_LABEL_AGE = "age";
    private static final String COLUMN_LABEL_VILLAIN_NAME = "villain_name";
    private static final String PRINT_FORMAT_MINION = "%d. %s %d\n";
    private static final String PRINT_FORMAT_VILLAIN = "Villain: %s\n";
    private static final String VILLAIN_DOES_NOT_EXISTS = "No villain with ID %s exists in the database.";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        final Connection connection = Utils.getSQLConnection();

        final PreparedStatement stmt = connection.prepareStatement(GET_MINION_NAMES);

        //Alternatively the task can be solved with two separate queries -
        //one finding the villain and checking if it exists
        //and the other, when we already know that the villain exist,
        //to get the minions that serve the villain with given id
        System.out.print("Enter villain ID: ");
        final int villainID = Integer.parseInt(scanner.nextLine());

        stmt.setInt(1, villainID);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            int i = 1;

            String villainName = rs.getString(COLUMN_LABEL_VILLAIN_NAME);

            System.out.printf(PRINT_FORMAT_VILLAIN, villainName);

            do {

                String minionName = rs.getString(COLUMN_LABEL_MINION_NAME);
                int minionAge = rs.getInt(COLUMN_LABEL_AGE);

                System.out.printf(PRINT_FORMAT_MINION, i, minionName, minionAge);

                i++;
            } while (rs.next());
        } else {
            System.out.printf(VILLAIN_DOES_NOT_EXISTS, villainID);
        }

        connection.close();
    }
}
