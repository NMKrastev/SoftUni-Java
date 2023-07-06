package com.example.sd18_workshopmvcproject.constants;

import java.nio.file.Path;

public enum Paths {

    ;

    public static final Path COMPANIES_FILE_PATH =
            Path.of("SD18_WorkshopMVCProject","src", "main", "resources", "files", "xmls", "companies.xml");

    public static final Path PROJECTS_FILE_PATH =
            Path.of("SD18_WorkshopMVCProject","src", "main", "resources", "files", "xmls", "projects.xml");

    public static final Path EMPLOYEES_FILE_PATH =
            Path.of("SD18_WorkshopMVCProject","src", "main", "resources", "files", "xmls", "employees.xml");
}
