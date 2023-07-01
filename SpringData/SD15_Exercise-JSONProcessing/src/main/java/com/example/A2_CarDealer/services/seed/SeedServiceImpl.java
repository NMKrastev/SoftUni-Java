package com.example.A2_CarDealer.services.seed;

import com.example.A2_CarDealer.entities.*;
import com.example.A2_CarDealer.entities.dto.car.CarImportDTO;
import com.example.A2_CarDealer.entities.dto.customer.CustomerImportDTO;
import com.example.A2_CarDealer.entities.dto.part.PartImportDTO;
import com.example.A2_CarDealer.entities.dto.supplier.SupplierImportDTO;
import com.example.A2_CarDealer.repositories.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.*;

import static com.example.A2_CarDealer.constants.Messages.*;
import static com.example.A2_CarDealer.constants.Paths.*;

@Service
public class SeedServiceImpl implements SeedService {

    private final Gson gson;
    private final ModelMapper mapper;
    private final Random random;
    private final SupplierRepository supplierRepository;
    private final PartRepository partRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final SaleRepository saleRepository;

    @Autowired
    public SeedServiceImpl(Gson gson, ModelMapper mapper, Random random, SupplierRepository supplierRepository,
                           PartRepository partRepository, CarRepository carRepository,
                           CustomerRepository customerRepository, SaleRepository saleRepository) {
        this.gson = gson;
        this.mapper = mapper;
        this.random = random;
        this.supplierRepository = supplierRepository;
        this.partRepository = partRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.saleRepository = saleRepository;
    }

    @Override
    public String seedSuppliers() throws FileNotFoundException {

        if (this.supplierRepository.count() != 0) {
            return SUPPLIERS_DATA_ALREADY_SEEDED;
        }

        final Type type = new TypeToken<List<SupplierImportDTO>>(){}.getType();

        final JsonReader reader = new JsonReader(new FileReader(SUPPLIERS_FILE_PATH.toFile()));

        final List<SupplierImportDTO> suppliersImportDTO = this.gson.fromJson(reader, type);

        final List<Supplier> suppliers = suppliersImportDTO
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
    public String seedParts() throws FileNotFoundException {

        if (this.partRepository.count() != 0) {
            return PARTS_DATA_ALREADY_SEEDED;
        }

        final Type type = new TypeToken<List<PartImportDTO>>() {}.getType();

        final JsonReader reader = new JsonReader(new FileReader(PARTS_FILE_PATH.toFile()));

        final List<PartImportDTO> partsImportDTO = this.gson.fromJson(reader, type);

        final List<Part> parts = partsImportDTO
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
    public String seedCars() throws FileNotFoundException {

        if (this.carRepository.count() != 0) {
            return CARS_DATA_ALREADY_SEEDED;
        }

        final Type type = new TypeToken<List<CarImportDTO>>(){}.getType();

        final JsonReader reader = new JsonReader(new FileReader(CARS_FILE_PATH.toFile()));

        final List<CarImportDTO> carsImportDTO = this.gson.fromJson(reader, type);

        final List<Car> cars = carsImportDTO
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
    public String seedCustomers() throws FileNotFoundException {

        if (this.customerRepository.count() != 0) {
            return CUSTOMERS_DATA_ALREADY_SEEDED;
        }

        final Type type = new TypeToken<List<CustomerImportDTO>>(){}.getType();

        final JsonReader reader = new JsonReader(new FileReader(CUSTOMERS_FILE_PATH.toFile()));

        final List<CustomerImportDTO> customersImportDTO = this.gson.fromJson(reader, type);

        final List<Customer> customers = customersImportDTO
                .stream()
                .map(customerDto -> {

                    final String birthDate = customerDto.getBirthDate();
                    final Customer customer = this.mapper.map(customerDto, Customer.class);
                    customer.setBirthDate(LocalDateTime.parse(birthDate));
                    return customer;

                })
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

        final List<SaleDiscountType> discountTypes = Arrays.asList(SaleDiscountType.values());

        if (this.carRepository.count() == 0 || this.customerRepository.count() == 0) {
            return CAR_OR_CUSTOMER_TABLE_EMPTY;
        }

        for (int i = 0; i < SALES_COUNT; i++) {

            final long randomCarId = this.random.nextLong(this.carRepository.count()) + 1L;

            final Car car = this.carRepository.findById(randomCarId)
                    .orElseThrow(NoSuchElementException::new);

            final long randomCustomerId = this.random.nextLong(this.customerRepository.count()) + 1L;

            final Customer customer = this.customerRepository.findById(randomCustomerId)
                    .orElseThrow(NoSuchElementException::new);

            final int randomDiscountId = this.random.nextInt(1, SaleDiscountType.values().length);
            double discountPercentage = discountTypes.get(randomDiscountId).getPercentage();

            final Sale sale = new Sale(discountPercentage, car, customer);
            this.saleRepository.saveAndFlush(sale);
        }

        return SALES_DATA_SEEDED_SUCCESSFULLY;
    }

    private Part setRandomSupplier(Part part) {

        long randomId = this.random.nextLong(1L, this.supplierRepository.count()) + 1L;

        final Supplier supplier = this.supplierRepository.findById(randomId)
                .orElseThrow(NoSuchElementException::new);

        part.setSupplier(supplier);

        return part;
    }

    private Car setRandomParts(Car car) {

        final Set<Part> parts = new HashSet<>();

        while (parts.size() < 3) {

            final long randomId = this.random.nextLong(1L, this.partRepository.count()) + 1L;

            final Part part = this.partRepository.findById(randomId).orElseThrow(NoSuchElementException::new);

            parts.add(part);
        }

        car.setParts(parts);

        return car;
    }
}
