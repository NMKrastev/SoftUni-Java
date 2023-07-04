package com.example.A2_CarDealer.services.seed;

import com.example.A2_CarDealer.entities.*;
import com.example.A2_CarDealer.entities.dto.car.wrapper.CarImportWrapperDTO;
import com.example.A2_CarDealer.entities.dto.customer.wrapper.CustomerImportWrapperDTO;
import com.example.A2_CarDealer.entities.dto.part.wrapper.PartImportWrapperDTO;
import com.example.A2_CarDealer.entities.dto.supplier.wrapper.SupplierImportWrapperDTO;
import com.example.A2_CarDealer.repositories.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import static com.example.A2_CarDealer.constants.Messages.*;
import static com.example.A2_CarDealer.constants.Paths.*;

@Service
public class SeedServiceImpl implements SeedService {

    private final ModelMapper mapper;
    private final Random random;
    private final SupplierRepository supplierRepository;
    private final PartRepository partRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final SaleRepository saleRepository;

    @Autowired
    public SeedServiceImpl(ModelMapper mapper, Random random, SupplierRepository supplierRepository,
                           PartRepository partRepository, CarRepository carRepository,
                           CustomerRepository customerRepository, SaleRepository saleRepository) {
        this.mapper = mapper;
        this.random = random;
        this.supplierRepository = supplierRepository;
        this.partRepository = partRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.saleRepository = saleRepository;
    }

    @Override
    public String seedSuppliers() throws FileNotFoundException, JAXBException {

        if (this.supplierRepository.count() != 0) {
            return SUPPLIERS_DATA_ALREADY_SEEDED;
        }

        final FileReader reader = new FileReader(SUPPLIERS_FILE_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(SupplierImportWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final SupplierImportWrapperDTO supplierImportWrapperDTO = (SupplierImportWrapperDTO) unmarshaller.unmarshal(reader);

        final List<Supplier> suppliers = supplierImportWrapperDTO
                .getSuppliers()
                .stream()
                .map(supplier -> this.mapper.map(supplier, Supplier.class))
                .toList();

        try {
            this.supplierRepository.saveAllAndFlush(suppliers);
        } catch (Exception e) {
            return e.getMessage();
        }

        return SUPPLIERS_DATA_SEEDED_SUCCESSFULLY;
    }

    @Override
    public String seedParts() throws FileNotFoundException, JAXBException {

        if (this.partRepository.count() != 0) {
            return PARTS_DATA_ALREADY_SEEDED;
        }

        final FileReader reader = new FileReader(PARTS_FILE_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(PartImportWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final PartImportWrapperDTO partImportWrapperDTO = (PartImportWrapperDTO) unmarshaller.unmarshal(reader);

        final List<Part> parts = partImportWrapperDTO
                .getParts()
                .stream()
                .map(part -> this.mapper.map(part, Part.class))
                .map(this::setRandomSupplier)
                .toList();

        try {
            this.partRepository.saveAllAndFlush(parts);
        } catch (Exception e) {
            return e.getMessage();
        }

        return PARTS_DATA_SEEDED_SUCCESSFULLY;
    }

    @Override
    public String seedCars() throws FileNotFoundException, JAXBException {

        if (this.carRepository.count() != 0) {
            return CARS_DATA_ALREADY_SEEDED;
        }

        final FileReader reader = new FileReader(CARS_FILE_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(CarImportWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final CarImportWrapperDTO carImportWrapperDTO = (CarImportWrapperDTO) unmarshaller.unmarshal(reader);

        final List<Car> cars = carImportWrapperDTO
                .getCars()
                .stream()
                .map(car -> this.mapper.map(car, Car.class))
                .toList();

        try {
            this.carRepository.saveAllAndFlush(cars);
        } catch (Exception e) {
            return e.getMessage();
        }

        cars.forEach(this::setRandomParts);

        try {
            this.carRepository.saveAllAndFlush(cars);
        } catch (Exception e) {
            return e.getMessage();
        }

        return CARS_DATA_SEEDED_SUCCESSFULLY;
    }

    @Override
    public String seedCustomers() throws FileNotFoundException, JAXBException {

        if (this.customerRepository.count() != 0) {
            return CUSTOMERS_DATA_ALREADY_SEEDED;
        }

        final FileReader reader = new FileReader(CUSTOMERS_FILE_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(CustomerImportWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final CustomerImportWrapperDTO customerImportWrapperDTO = (CustomerImportWrapperDTO) unmarshaller.unmarshal(reader);

        final List<Customer> customers = customerImportWrapperDTO
                .getCustomers()
                .stream()
                .map(customerDto -> this.mapper.map(customerDto, Customer.class))
                .toList();

        try {
            this.customerRepository.saveAllAndFlush(customers);
        } catch (Exception e) {
            return e.getMessage();
        }
        return CUSTOMERS_DATA_SEEDED_SUCCESSFULLY;
    }

    @Override
    public String populateSales() {

        if (this.carRepository.count() == 0 || this.customerRepository.count() == 0) {
            return CAR_OR_CUSTOMER_TABLE_EMPTY;
        }

        if (this.saleRepository.count() != 0) {
            return SALES_DATA_ALREADY_SEEDED;
        }

        final List<SaleDiscountType> discountTypes = Arrays.asList(SaleDiscountType.values());

        final Set<Sale> sales = new HashSet<>();

        for (int i = 0; i < SALES_COUNT; i++) {

            final long randomCarId = this.random.nextLong(this.carRepository.count()) + 1L;

            final Car car = this.carRepository.findById(randomCarId)
                    .orElseThrow(NoSuchElementException::new);

            final long randomCustomerId = this.random.nextLong(this.customerRepository.count()) + 1L;

            final Customer customer = this.customerRepository.findById(randomCustomerId)
                    .orElseThrow(NoSuchElementException::new);

            final int randomDiscountId = this.random.nextInt(1, SaleDiscountType.values().length);
            double discountPercentage = discountTypes.get(randomDiscountId).getPercentage();

            sales.add(new Sale(discountPercentage, car, customer));
        }

        try {
            this.saleRepository.saveAllAndFlush(sales);
        } catch (Exception e) {
            return e.getMessage();
        }

        return SALES_DATA_SEEDED_SUCCESSFULLY;
    }

    private Part setRandomSupplier(Part part) {

        long randomId = this.random.nextLong(this.supplierRepository.count()) + 1L;

        final Supplier supplier = this.supplierRepository.findById(randomId)
                .orElseThrow(NoSuchElementException::new);

        part.setSupplier(supplier);

        return part;
    }

    private Car setRandomParts(Car car) {

        final Set<Part> parts = new HashSet<>();

        while (parts.size() < 3) {

            final long randomId = this.random.nextLong(this.partRepository.count()) + 1L;

            final Part part = this.partRepository.findById(randomId).orElseThrow(NoSuchElementException::new);

            parts.add(part);
        }

        car.setParts(parts);

        return car;
    }
}
