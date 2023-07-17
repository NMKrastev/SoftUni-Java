package exam.constant;

public enum Message {

    ;

    public static final String INVALID_ENTITY = "Invalid %s";
    public static final String SUCCESSFUL_TOWN_IMPORT = "Successfully imported %s %s";
    public static final String SUCCESSFUL_SHOP_IMPORT = "Successfully imported %s %s - %.0f";
    public static final String SUCCESSFUL_CUSTOMER_IMPORT = "Successfully imported %s %s - %s";
    public static final String SUCCESSFUL_LAPTOP_IMPORT = "Successfully imported %s %s - %.2f - %s - %s";
    public static final String PRINT_FORMAT =
            "Laptop - %s\n" +
            "*Cpu speed - %.2f\n" +
            "**Ram - %d\n" +
            "***Storage - %d\n" +
            "****Price - %.2f\n" +
            "#Shop name - %s\n" +
            "##Town - %s";
}
