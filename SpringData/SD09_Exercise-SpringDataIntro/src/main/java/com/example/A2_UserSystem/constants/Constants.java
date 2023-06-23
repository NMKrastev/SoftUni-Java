package com.example.A2_UserSystem.constants;

public enum Constants {

    ;

    public static final String TASK_ONE_TITLE = "1. Get Users by Email Provider";
    public static final String TASK_TWO_TITLE = "2. Remove Inactive Users";
    public static final String PRINT_USER_EMAIL_FORMAT = "Username: %s, Email: %s\n";
    public static final String ENTER_EMAIL_PROVIDER = "Enter a provider(exp: gmail.com): ";
    public static final String USERS_SET_AS_DELETED = "Users set as deleted: %s\n";
    public static final String USERS_DELETED = "Users deleted!";
    public static final String ENTER_DATE_IN_FORMAT = "Please enter date in format (d-m-yyyy/1-1-1900): ";
    public static final String INVALID_EMAIL = "Invalid email format!";
    public static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|" +
            "\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")" +
            "@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|" +
            "\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])\\.){3}" +
            "(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:" +
            "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    public static final String EMAIL_NAME_LENGTH_TOO_SHORT = "Email name length is too short!";
    public static final String EMAIL_NAME_LENGTH_TOO_LONG = "Email name length is too long!";
    public static final String EMAIL_HOST_LENGTH_TOO_LONG = "Email host length is too long";
    public static final String PASSWORD_TOO_SHOR = "Password too short! Must be between 6 and 30 symbols!";
    public static final String PASSWORD_TOO_LONG = "Password too long! Must be between 6 and 30 symbols!";
    public static final String PASSWORD_MUST_CONTAIN_DIGIT = "Password must contains at least one digit!";
    public static final String PASSWORD_MUST_CONTAIN_LOWER_CASE = "Password must contains at least one lower case!";
    public static final String PASSWORD_MUST_CONTAIN_UPPER_CASE = "Password must contains at least one upper case!";
    public static final String PASSWORD_MUST_CONTAIN_SPECIAL_SYMBOL = "Password must contains at least one special symbol!";
    public static final String SEPARATOR = "-----------------------------------------------------------------------------------------";
}
