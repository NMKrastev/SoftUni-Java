package softuni.exam.constant;

import softuni.exam.models.entity.StarType;

public enum Message {

    ;

    public static final String INVALID_ENTITY = "Invalid %s";
    public static final String CONSTELLATION = "constellation";
    public static final String STAR = "star";
    public static final String ASTRONOMER = "astronomer";
    public static final String CONSTELLATION_IMPORT = "Successfully imported constellation %s - %s";
    public static final String STAR_IMPORT = "Successfully imported star %s - %.2f light years";
    public static final String ASTRONOMER_IMPORT = "Successfully imported astronomer %s - %.2f";

    public static final StarType STAR_TYPE = StarType.RED_GIANT;
    public static final String PRINT_FORMAT = "Star: %s\n" +
            "   *Distance: %.2f light years\n" +
            "   **Description: %s\n" +
            "   ***Constellation: %s";
}
