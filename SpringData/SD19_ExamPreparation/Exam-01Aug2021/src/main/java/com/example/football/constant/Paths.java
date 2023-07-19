package com.example.football.constant;

import java.nio.file.Path;

public enum Paths {

    ;

    public static final Path TOWNS_FILE_PATH =
            Path.of("src", "main", "resources", "files", "json", "towns.json");
    public static final Path TEAMS_FILE_PATH =
            Path.of("src", "main", "resources", "files", "json", "teams.json");
    public static final Path STATS_FILE_PATH =
            Path.of("src", "main", "resources", "files", "xml", "stats.xml");
    public static final Path PLAYERS_FILE_PATH =
            Path.of("src", "main", "resources", "files", "xml", "players.xml");
}
