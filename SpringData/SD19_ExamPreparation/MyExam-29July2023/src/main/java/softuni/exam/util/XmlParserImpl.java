package softuni.exam.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XmlParserImpl implements XmlParser {

    public <T> T fromFile(File file, Class<T> object) throws JAXBException, FileNotFoundException {

        final JAXBContext context = JAXBContext.newInstance(object);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final FileReader reader = new FileReader(file);

        return (T) unmarshaller.unmarshal(reader);
    }
}
