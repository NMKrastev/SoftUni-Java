package com.example.A2_CarDealer.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class LocalDateTimeAdapterDeserializer implements JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {

        return LocalDateTime.parse(json.getAsString());
    }
}
