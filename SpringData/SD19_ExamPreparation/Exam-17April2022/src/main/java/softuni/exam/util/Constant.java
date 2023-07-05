package softuni.exam.util;

import softuni.exam.models.entity.DaysOfWeekEnum;

public enum Constant {

    ;

    public static final String COUNTRIES_JSON_FILE_PATH = "src/main/resources/files/json/countries.json";
    public static final String CITIES_JSON_FILE_PATH = "src/main/resources/files/json/cities.json";
    public static final String FORECASTS_XML_FILE_PATH = "src/main/resources/files/xml/forecasts.xml";
    public static final String INVALID_COUNTRY = "Invalid country";
    public static final String INVALID_CITY = "Invalid city";
    public static final String INVALID_FORECAST = "Invalid forecast";
    public static final String COUNTRY_IMPORTED_FORMAT = "Successfully imported country %s - %s";
    public static final String CITY_IMPORTED_FORMAT = "Successfully imported city %s - %d";
    public static final String FORECAST_IMPORTED_FORMAT = "Successfully import forecast %s - %.2f";
    public static final String EXPORT_FORECAST_PRINT_FORMAT = "City: %s\n-min temperature: %.2f\n--max temperature: %.2f\n---sunrise: %s\n----sunset: %s";

    public static final DaysOfWeekEnum DAY = DaysOfWeekEnum.SUNDAY;
    public static final int POPULATION = 150000;
}
