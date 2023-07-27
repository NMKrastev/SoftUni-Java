package softuni.exam.constant;

import softuni.exam.models.entity.DayOfWeekType;

public enum Message {

    ;

    public static final String INVALID_ENTITY = "Invalid %s";
    public static final String SUCCESSFUL_IMPORT = "Successfully imported %s %s - %s";
    public static final String COUNTRY = "country";
    public static final String CITY = "city";
    public static final String FORECAST = "forecast";

    public static final DayOfWeekType DAY_OF_WEEK = DayOfWeekType.SUNDAY;
    public static final int POPULATION = 150000;
    public static final String PRINT_FORMAT =
            "City: %s:\n" +
                    "\t-min temperature: %.2f\n" +
                    "\t--max temperature: %.2f\n" +
                    "\t---sunrise: %s\n" +
                    "\t----sunset: %s";
}
