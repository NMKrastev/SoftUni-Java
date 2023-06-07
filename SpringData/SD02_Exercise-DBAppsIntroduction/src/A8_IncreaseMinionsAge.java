import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class A8_IncreaseMinionsAge {

    private static final String UPDATE_MINION_AGE =
            "UPDATE minions " +
                    "SET age  = age + 1, " +
                    "name = LOWER(name) " +
                    "WHERE id = ?;";
    private static final String SELECT_MINIONS_NAME_AGE =
            "SELECT name, age FROM minions;";
    private static final String PRINT_MINIONS_FORMAT = "%s %d\n";
    private static final String COLUMN_LABEL_NAME = "name";
    private static final String COLUMN_LABEL_AGE = "age";


    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        final Connection connection = Utils.getSQLConnection();

        final PreparedStatement updateMinionAgeStatement = connection.prepareStatement(UPDATE_MINION_AGE);

        final List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        for (int id : numbers) {

            updateMinionAgeStatement.setInt(1, id);
            updateMinionAgeStatement.executeUpdate();
        }

        final PreparedStatement selectMinionsStatement = connection.prepareStatement(SELECT_MINIONS_NAME_AGE);

        final ResultSet rs = selectMinionsStatement.executeQuery();

        while (rs.next()) {

            String name = rs.getString(COLUMN_LABEL_NAME);
            int age = rs.getInt(COLUMN_LABEL_AGE);

            System.out.printf(PRINT_MINIONS_FORMAT, name, age);
        }
    }
}
