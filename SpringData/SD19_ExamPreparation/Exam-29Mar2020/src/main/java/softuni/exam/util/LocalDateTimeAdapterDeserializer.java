package softuni.exam.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class LocalDateTimeAdapterDeserializer implements JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        String replaced = jsonElement.toString().replaceAll("\"", "");
        String date = replaced.split("\\s+")[0];
        String time = replaced.split("\\s+")[1];
        String dateTime = date + "T" + time;
        return LocalDateTime.parse(dateTime);
    }
}
