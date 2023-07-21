package softuni.exam.constant;

public enum Message {

    ;

    public static final String INVALID_ENTITY = "Invalid %s";

    public static final String SUCCESSFUL_PART_IMPORT = "Successfully imported %s %s - %s";
    public static final String SUCCESSFUL_MECHANIC_IMPORT = "Successfully imported %s %s";
    public static final String SUCCESSFUL_CAR_IMPORT = "Successfully imported %s %s - %s";
    public static final String SUCCESSFUL_TASK_IMPORT = "Successfully imported %s %s";


    public static final String PART = "part";
    public static final String MECHANIC = "mechanic";
    public static final String CAR = "car";
    public static final String TASK = "task";

    public static final String EXPORT =
            "Car %s %s with %dkm\n" +
                    "-Mechanic: %s - task №%d:\n" +
                    " --Engine: %s\n" +
                    "---Price: %s$";
}
