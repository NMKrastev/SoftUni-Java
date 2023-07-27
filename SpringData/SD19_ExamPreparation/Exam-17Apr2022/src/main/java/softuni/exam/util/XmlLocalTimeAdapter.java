package softuni.exam.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalTime;

public class XmlLocalTimeAdapter extends XmlAdapter<String, LocalTime> {

    @Override
    public LocalTime unmarshal(String time) throws Exception {
        return LocalTime.parse(time);
    }

    @Override
    public String marshal(LocalTime localTime) throws Exception {
        return localTime.toString();
    }
}
