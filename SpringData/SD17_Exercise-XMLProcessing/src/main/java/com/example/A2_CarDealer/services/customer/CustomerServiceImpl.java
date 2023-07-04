package com.example.A2_CarDealer.services.customer;

import com.example.A2_CarDealer.entities.dto.customer.CustomerInfoOrderedDTO;
import com.example.A2_CarDealer.entities.dto.customer.CustomerWithTotalSalesDTO;
import com.example.A2_CarDealer.entities.dto.customer.wrapper.CustomerInfoOrderedWrapperDTO;
import com.example.A2_CarDealer.entities.dto.customer.wrapper.CustomerWithTotalSalesWrapperDTO;
import com.example.A2_CarDealer.repositories.CustomerRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import static com.example.A2_CarDealer.constants.Messages.CUSTOMERS_TOTAL_SALES_SAVED_SUCCESSFULLY;
import static com.example.A2_CarDealer.constants.Messages.ORDERED_CUSTOMERS_SAVED_SUCCESSFULLY;
import static com.example.A2_CarDealer.constants.Paths.CUSTOMERS_TOTAL_SALES_FILE_PATH;
import static com.example.A2_CarDealer.constants.Paths.ORDERED_CUSTOMERS_FILE_PATH;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final ModelMapper mapper;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper mapper) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    @Override
    public String findAllCustomersAndOrderByCriteria() throws JAXBException {

        final List<CustomerInfoOrderedDTO> customers =
                this.customerRepository.findAllByOrderByBirthDateAscIsYoungDriverAsc()
                        .orElseThrow(NoSuchElementException::new)
                        .stream()
                        .map(customer -> this.mapper.map(customer, CustomerInfoOrderedDTO.class))
                        .toList();

        final CustomerInfoOrderedWrapperDTO customerInfoOrderedWrapperDTO =
                new CustomerInfoOrderedWrapperDTO(customers);

        final JAXBContext context = JAXBContext.newInstance(CustomerInfoOrderedWrapperDTO.class);

        final Marshaller addressMarshal = context.createMarshaller();

        addressMarshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        addressMarshal.marshal(customerInfoOrderedWrapperDTO, ORDERED_CUSTOMERS_FILE_PATH.toFile());

        return ORDERED_CUSTOMERS_SAVED_SUCCESSFULLY;
    }

    @Override
    public String findAllCustomersWithTotalSalesAndMoneySpent() throws JAXBException {

        final List<CustomerWithTotalSalesDTO> allCustomersByTotalSalesCountAndMoneySpent =
                this.customerRepository.findAllCustomersByTotalSalesCountAndMoneySpent();

        final CustomerWithTotalSalesWrapperDTO customerWithTotalSalesWrapperDTO =
                new CustomerWithTotalSalesWrapperDTO(allCustomersByTotalSalesCountAndMoneySpent);

        final JAXBContext context = JAXBContext.newInstance(CustomerWithTotalSalesWrapperDTO.class);

        final Marshaller addressMarshal = context.createMarshaller();

        addressMarshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        addressMarshal.marshal(customerWithTotalSalesWrapperDTO, CUSTOMERS_TOTAL_SALES_FILE_PATH.toFile());

        return CUSTOMERS_TOTAL_SALES_SAVED_SUCCESSFULLY;
    }
}
