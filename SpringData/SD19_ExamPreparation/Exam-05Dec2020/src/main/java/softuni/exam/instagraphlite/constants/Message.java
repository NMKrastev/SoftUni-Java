package softuni.exam.instagraphlite.constants;

public enum Message {

    ;

    public static final String INVALID_ENTITY = "Invalid %s";
    public static final String SUCCESSFULLY_IMPORTED_PICTURE = "Successfully imported %s, with size %.2f";
    public static final String SUCCESSFULLY_IMPORTED_USER = "Successfully imported %s: %s";
    public static final String SUCCESSFULLY_IMPORTED_POST = "Successfully imported %s, made by %s";
    public static final String USER_POST_COUNT_FORMAT = "User: %s\nPost count: %d";
    public static final String USER_INFO_FORMAT = "==Post Details:\n" +
            "----Caption: %s\n" +
            "----Picture Size: %.2f";
    public static final String PICTURE_FORMAT = "%.2f – %s";

    public static final Double PICTURE_SIZE = 30000.00;
}
