package com.example.A1_BookshopSystem.constants;

import java.time.LocalDate;

public enum Constant {

    ;

    public static final LocalDate BOOK_AFTER_YEAR = LocalDate.of(2000, 12, 31);
    public static final LocalDate BOOK_BEFORE_YEAR = LocalDate.of(1990, 1, 1);
    public static final String FULL_NAME = "George Powell";

    public static final String ENTER_TASK_NUMBER = "Please, enter task number: ";

    public static final String TASK_ONE_DESCRIPTION = "1. Get all books after the year 2000. Print only their titles.";
    public static final String TASK_TWO_DESCRIPTION = "2. Get all authors with at least one book with a release date before 1990. Print their first name and last name.";
    public static final String TASK_THREE_DESCRIPTION = "3. Get all authors, ordered by the number of their books (descending). Print their first name, last name and book count.";
    public static final String TASK_FOUR_DESCRIPTION = "4. Get all books from author George Powell, ordered by their release date (descending), \n" +
            "then by book title (ascending). Print the book's title, release date and copies.";

    public static final String SEPARATOR = "----------------------------------------------------------------------------------------------------------------------";
}
