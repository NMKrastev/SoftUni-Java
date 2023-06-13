import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class A1_WritingYourOwnDataRetrievalApplication {

    private static final String GET_USER_GAMES_COUNT_BY_USERNAME = "SELECT u.`first_name`, u.`last_name`, " +
            "(SELECT COUNT(`user_id`) FROM `users_games` WHERE `user_id` = u.`id`) AS `games_count` " +
            "FROM `users` AS u " +
            "WHERE u.`user_name` = ?";

    public static void main(String[] args) throws SQLException {

        Connection connection = getConnection();

        String username = getUsername();

        PreparedStatement stmt = getPreparedStatement(connection, username);

        ResultSet rs = stmt.executeQuery();

        printResults(username, rs);
    }

    private static void printResults(String username, ResultSet rs) throws SQLException {
        if (rs.next()) {

            String dbFirstName = rs.getString("first_name");
            String dbLastName = rs.getString("last_name");
            int count = rs.getInt("games_count");

            System.out.printf("User: %s\n", username);
            System.out.printf("%s %s has played %d games\n", dbFirstName, dbLastName, count);
        } else {
            System.out.println("No such user exists");
        }
    }

    private static PreparedStatement getPreparedStatement(Connection connection, String username) throws SQLException {
        PreparedStatement stmt =
                connection.prepareStatement(GET_USER_GAMES_COUNT_BY_USERNAME);

        stmt.setString(1, username);
        return stmt;
    }

    private static String getUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter username: ");
        String username = scanner.nextLine();
        return username;
    }

    private static Connection getConnection() throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root_12345");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/diablo", properties);
        return connection;
    }
}
