package softuni.exam.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;

public class XmlDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {


    @Override
    public LocalDateTime unmarshal(String dateTime) throws Exception {

        final String date = dateTime.split("\\s+")[0];
        final String time = dateTime.split("\\s+")[1];

        return LocalDateTime.parse(date + "T" + time);
    }

    @Override
    public String marshal(LocalDateTime dateTime) throws Exception {

        return dateTime.toString();
    }
}
