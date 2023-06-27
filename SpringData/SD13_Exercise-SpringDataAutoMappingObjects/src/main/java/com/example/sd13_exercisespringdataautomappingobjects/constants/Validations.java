package com.example.sd13_exercisespringdataautomappingobjects.constants;

public enum Validations {

    ;

    public static final String EMAIL_PATTERN = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
    public static final String EMAIL_NOT_VALID_MESSAGE = "Incorrect email!";
    //(?=.*[@#$%^&+=]) - special symbol
    public static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,30}$";
    public static final String USERNAME_OR_PASSWORD_NOT_VALID_MESSAGE = "Incorrect username / password!";
    public static final String PASSWORDS_MISMATCH_MESSAGE = "Passwords are not matching!";
    public static final String COMMAND_NOT_FOUND_MESSAGE = "Command not found!";
    public static final String EMAIL_ALREADY_EXISTS = "Email already exists!";
    public static final String INVALID_GAME_TITLE_MESSAGE = "Not a valid game title!";
    public static final String INVALID_GAME_PRICE_MESSAGE = "Price should be positive number!";
    public static final String INVALID_GAME_SIZE_MESSAGE = "Size should be positive number!";
    public static final String INVALID_GAME_TRAILER_SIZE_MESSAGE = "Trailer size should be 11 characters long!";
    public static final String INVALID_THUMBNAIL_URL_MESSAGE = "Thumbnail url is not valid!";
    public static final String INVALID_DESCRIPTION_LENGTH_MESSAGE = "Description should be at least 20 characters long!";
    public static final String USER_MUST_BE_LOGGED_OR_ADMIN_TO_ADD_OR_EDIT_GAME = "User must be logged in or be an admin to Add, Edit or Delete a game!";
    public static final String GAME_ALREADY_EXISTS = "Game already exists!";
    public static final String GAME_TITLE_DOES_NOT_EXISTS = "Game with title \"%s\" does not exist";
    public static final String GAME_DOES_NOT_EXISTS = "Game with id: %d does not exist!";
    public static final String USER_MUST_BE_LOGGED_IN = "User must be logged in.";
    public static final String USER_ALREADY_BOUGHT_TITLE = "User already bought title \"%s\"";
    public static final String GAME_ALREADY_IN_CART = "Game \"%s\" is already in your cart!";
    public static final String SHOPPING_CART_EMPTY = "Your shopping cart is empty!";
    public static final String USER_DOES_NOT_OWN_GAMES = "%s does not own any games yet!";

}
