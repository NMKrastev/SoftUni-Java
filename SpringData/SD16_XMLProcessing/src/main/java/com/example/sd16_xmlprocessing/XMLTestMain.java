package com.example.sd16_xmlprocessing;

import com.example.sd16_xmlprocessing.entities.dtos.AddressDTO;
import com.example.sd16_xmlprocessing.entities.dtos.CountryXMLDTO;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class XMLTestMain implements CommandLineRunner {

    private final JAXBContext addressContext;
    private final JAXBContext countryContext;

    @Autowired
    public XMLTestMain(@Qualifier("addressContext") JAXBContext addressContext,
                       @Qualifier("countryContext") JAXBContext countryContext) {
        this.addressContext = addressContext;
        this.countryContext = countryContext;
    }

    @Override
    public void run(String... args) throws Exception {


        final CountryXMLDTO country = new CountryXMLDTO("Bulgaria");
        final AddressDTO xmlDTO = new AddressDTO("Bulgaria", "Sofia");

        //final JAXBContext context = JAXBContext.newInstance(AddressDTO.class);

        final Marshaller addressMarshal = this.addressContext.createMarshaller();
        addressMarshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        addressMarshal.marshal(xmlDTO, System.out);

        final Marshaller countryMarshal = this.countryContext.createMarshaller();
        countryMarshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        countryMarshal.marshal(country, System.out);

        /*System.out.println();
        final Unmarshaller unmarshaller = context.createUnmarshaller();

        AddressDTO unmarshal = (AddressDTO) unmarshaller.unmarshal(System.in);

        System.out.println(unmarshal);*/
    }
}
