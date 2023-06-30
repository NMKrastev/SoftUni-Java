package com.example.A1_ProductShop.utils;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public enum Utils {

    ;

    public static void writeJsonIntoFile(List<?> objects, Path filePath) throws IOException {

        final FileWriter fileWriter = new FileWriter(filePath.toFile());
        final Gson gson = new Gson();

        gson.toJson(objects, fileWriter);

        fileWriter.flush();
        fileWriter.close();
    }

    public static void writeJsonIntoFile(Object object, Path filePath) throws IOException {

        final FileWriter fileWriter = new FileWriter(filePath.toFile());
        final Gson gson = new Gson();

        gson.toJson(object, fileWriter);

        fileWriter.flush();
        fileWriter.close();
    }
}
