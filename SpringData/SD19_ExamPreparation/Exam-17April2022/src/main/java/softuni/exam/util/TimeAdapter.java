package softuni.exam.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalTime;

public class TimeAdapter extends XmlAdapter<String, LocalTime> {

    @Override
    public LocalTime unmarshal(String time) throws Exception {
        return LocalTime.parse(time);
    }

    @Override
    public String marshal(LocalTime time) throws Exception {
        return time.toString();
    }
}
