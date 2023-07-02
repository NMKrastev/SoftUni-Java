package com.example.A2_CarDealer.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public enum Utils {

    ;

    public static void writeJsonIntoFile(List<?> objects, Path filePath) throws IOException {

        final FileWriter fileWriter = new FileWriter(filePath.toFile());
        final Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .setPrettyPrinting()
                .create();

        gson.toJson(objects, fileWriter);

        fileWriter.flush();
        fileWriter.close();
    }

    public static void writeJsonIntoFile(Object object, Path filePath) throws IOException {

        final FileWriter fileWriter = new FileWriter(filePath.toFile());
        final Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .setPrettyPrinting()
                .create();

        gson.toJson(object, fileWriter);

        fileWriter.flush();
        fileWriter.close();
    }
}
