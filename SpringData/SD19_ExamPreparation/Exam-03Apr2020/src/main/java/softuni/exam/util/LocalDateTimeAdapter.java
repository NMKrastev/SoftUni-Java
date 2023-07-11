package softuni.exam.util;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDateTime;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    @Override
    public LocalDateTime unmarshal(String dateTimeFromXML) throws Exception {

        final String dateTime = dateTimeFromXML.trim().replaceAll("\\s+", "T");

        return LocalDateTime.parse(dateTime);
    }

    @Override
    public String marshal(LocalDateTime dateTime) throws Exception {

        return dateTime.toString();
    }
}
