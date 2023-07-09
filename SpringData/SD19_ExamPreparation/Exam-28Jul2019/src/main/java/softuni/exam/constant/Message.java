package softuni.exam.constant;

import java.math.BigDecimal;

public enum Message {

    ;

    public static final String SUCCESSFULLY_ADDED_PICTURE = "Successfully imported picture - %s";
    public static final String INVALID_PICTURE = "Invalid picture";
    public static final String SUCCESSFULLY_ADDED_TEAM = "Successfully imported - %s";
    public static final String INVALID_TEAM = "Invalid team";
    public static final String SUCCESSFULLY_ADDED_PLAYER = "Successfully imported player: %s %s";
    public static final String INVALID_PLAYER = "Invalid player";

    public static final String TEAM_NAME = "North Hub";
    public static final BigDecimal SALARY = BigDecimal.valueOf(100000);

    public static final String TEAM_NAME_FORMAT = "Team: %s";
    public static final String PLAYER_FROM_TEAM_FORMAT = "\tPlayer name: %s %s - %s\n\tNumber: %d";
    public static final String PLAYER_INFO_FORMAT = "Player name: %s\n" +
            "\tNumber: %d\n" +
            "\tSalary: %.2f\n" +
            "\tTeam: %s";
}
