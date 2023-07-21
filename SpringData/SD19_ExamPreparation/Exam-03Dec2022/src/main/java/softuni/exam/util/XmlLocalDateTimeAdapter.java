package softuni.exam.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;

public class XmlLocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    @Override
    public LocalDateTime unmarshal(String dateTimeFromXML) throws Exception {

        final String dateTime = dateTimeFromXML.trim().replaceAll(" ", "T");

        return LocalDateTime.parse(dateTime);
    }

    @Override
    public String marshal(LocalDateTime dateTime) throws Exception {
        return dateTime.toString();
    }
}
