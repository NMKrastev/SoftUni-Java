package com.example.A2_CarDealer.services.customer;

import com.example.A2_CarDealer.entities.dto.customer.CustomerInfoOrderedDTO;
import com.example.A2_CarDealer.entities.dto.customer.CustomerWithTotalSalesDTO;
import com.example.A2_CarDealer.repositories.CustomerRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static com.example.A2_CarDealer.constants.Messages.CUSTOMERS_TOTAL_SALES_SAVED_SUCCESSFULLY;
import static com.example.A2_CarDealer.constants.Messages.ORDERED_CUSTOMERS_SAVED_SUCCESSFULLY;
import static com.example.A2_CarDealer.constants.Paths.CUSTOMERS_TOTAL_SALES_FILE_PATH;
import static com.example.A2_CarDealer.constants.Paths.ORDERED_CUSTOMERS_FILE_PATH;
import static com.example.A2_CarDealer.utils.Utils.writeJsonIntoFile;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final Gson gson;
    private final ModelMapper mapper;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(Gson gson, CustomerRepository customerRepository, ModelMapper mapper) {
        this.gson = gson;
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    @Override
    public String findAllCustomersAndOrderByCriteria() throws IOException {

        final List<CustomerInfoOrderedDTO> customers =
                this.customerRepository.findAllByOrderByBirthDateAscIsYoungDriverAsc()
                        .orElseThrow(NoSuchElementException::new)
                        .stream()
                        .map(customer -> this.mapper.map(customer, CustomerInfoOrderedDTO.class))
                        .toList();

        writeJsonIntoFile(this.gson, customers, ORDERED_CUSTOMERS_FILE_PATH);

        return ORDERED_CUSTOMERS_SAVED_SUCCESSFULLY;
    }

    @Override
    public String findAllCustomersWithTotalSalesAndMoneySpent() throws IOException {

        final List<CustomerWithTotalSalesDTO> allCustomersByTotalSalesCountAndMoneySpent =
                this.customerRepository.findAllCustomersByTotalSalesCountAndMoneySpent();

        writeJsonIntoFile(this.gson, allCustomersByTotalSalesCountAndMoneySpent, CUSTOMERS_TOTAL_SALES_FILE_PATH);

        return CUSTOMERS_TOTAL_SALES_SAVED_SUCCESSFULLY;
    }
}
