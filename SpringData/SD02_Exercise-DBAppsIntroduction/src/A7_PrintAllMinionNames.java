import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class A7_PrintAllMinionNames {

    private static final String GET_ALL_MINIONS_NAMES = "SELECT `name` FROM minions;";
    private static final String COLUMN_LABEL_NAME = "name";

    public static void main(String[] args) throws SQLException {

        final Connection connection = Utils.getSQLConnection();

        final PreparedStatement statement = connection.prepareStatement(GET_ALL_MINIONS_NAMES);

        final ResultSet resultSet = statement.executeQuery();

        List<String> minionsNames = new ArrayList<>();

        while (resultSet.next()) {

            String name = resultSet.getString(COLUMN_LABEL_NAME);
            minionsNames.add(name);
        }

        int minionsCount = minionsNames.size() - 1;

        for (int i = 0; i < minionsNames.size() / 2; i++) {

            System.out.println(minionsNames.get(i));
            System.out.println(minionsNames.get(minionsCount - i));
        }
    }
}
