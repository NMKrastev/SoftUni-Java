package com.example.A2_CarDealer.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public enum Utils {

    ;

    public static void writeJsonIntoFile(Gson gson, List<?> objects, Path filePath) throws IOException {

        final FileWriter fileWriter = new FileWriter(filePath.toFile());

        gson.toJson(objects, fileWriter);

        fileWriter.flush();
        fileWriter.close();
    }

    public static void writeJsonIntoFile(Gson gson, Object object, Path filePath) throws IOException {

        final FileWriter fileWriter = new FileWriter(filePath.toFile());

        gson.toJson(object, fileWriter);

        fileWriter.flush();
        fileWriter.close();
    }
}
