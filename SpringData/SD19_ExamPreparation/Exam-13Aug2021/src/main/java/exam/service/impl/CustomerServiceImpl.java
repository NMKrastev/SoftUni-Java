package exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import exam.model.dtos.customer.CustomerImportDTO;
import exam.model.entity.Customer;
import exam.model.entity.Town;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
import exam.util.FileUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import static exam.constant.FilePath.CUSTOMERS_FILE_PATH;
import static exam.constant.Message.INVALID_ENTITY;
import static exam.constant.Message.SUCCESSFUL_CUSTOMER_IMPORT;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final StringBuilder sb;
    private final Gson gson;
    private final ModelMapper mapper;
    private final FileUtil fileUtil;
    private final CustomerRepository customerRepository;
    private final TownRepository townRepository;

    public CustomerServiceImpl(Gson gson, ModelMapper mapper, FileUtil fileUtil,
                               CustomerRepository customerRepository, TownRepository townRepository) {
        this.gson = gson;
        this.mapper = mapper;
        this.fileUtil = fileUtil;
        this.customerRepository = customerRepository;
        this.townRepository = townRepository;
        this.sb = new StringBuilder();
    }

    @Override
    public boolean areImported() {
        return this.customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return this.fileUtil.readFile(CUSTOMERS_FILE_PATH);
    }

    @Override
    public String importCustomers() throws IOException {

        final JsonReader reader = new JsonReader(new FileReader(CUSTOMERS_FILE_PATH.toFile()));

        final Type type = new TypeToken<List<CustomerImportDTO>>(){}.getType();

        final List<CustomerImportDTO> customersImportDTO = this.gson.fromJson(reader, type);

        customersImportDTO
                .forEach(customerDTO -> {

                    final Town town = this.townRepository.findByName(customerDTO.getTown().getName());

                    final Customer customer = this.mapper.map(customerDTO, Customer.class);

                    customer.setTown(town);

                    try {

                        this.customerRepository.saveAndFlush(customer);

                        this.sb.append(String.format(SUCCESSFUL_CUSTOMER_IMPORT,
                                        customer.getClass().getSimpleName(), customer.getFullName(), customer.getEmail()))
                                .append(System.lineSeparator());

                    } catch (Exception e) {

                        this.sb.append(String.format(INVALID_ENTITY, customer.getClass().getSimpleName()))
                                .append(System.lineSeparator());
                    }
                });

        return this.sb.toString().trim();
    }
}
