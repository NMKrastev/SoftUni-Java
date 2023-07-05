package hiberspring.service.impl;

import hiberspring.domain.dtos.EmployeeDataExportDTO;
import hiberspring.domain.dtos.EmployeeImportDTO;
import hiberspring.domain.dtos.wrapper.EmployeeImportWrapperDTO;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Employee;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.repository.EmployeeRepository;
import hiberspring.service.EmployeeService;
import hiberspring.util.FileUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static hiberspring.common.Constants.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final ModelMapper mapper;
    private final FileUtil fileUtil;
    private final StringBuilder sb;
    private final EmployeeRepository employeeRepository;
    private final EmployeeCardRepository cardRepository;
    private final BranchRepository branchRepository;

    public EmployeeServiceImpl(ModelMapper mapper, FileUtil fileUtil, StringBuilder sb,
                               EmployeeRepository employeeRepository, EmployeeCardRepository cardRepository, BranchRepository branchRepository) {
        this.mapper = mapper;
        this.fileUtil = fileUtil;
        this.sb = sb;
        this.employeeRepository = employeeRepository;
        this.cardRepository = cardRepository;
        this.branchRepository = branchRepository;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() != 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return new String(Files.readAllBytes(Paths.get(PATH_TO_FILES + EMPLOYEES_FILE)));
    }

    @Override
    public String importEmployees() throws JAXBException, FileNotFoundException {

        final FileReader reader = new FileReader(PATH_TO_FILES + EMPLOYEES_FILE);

        final JAXBContext context = JAXBContext.newInstance(EmployeeImportWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final EmployeeImportWrapperDTO employeeImportWrapperDTO = (EmployeeImportWrapperDTO) unmarshaller.unmarshal(reader);

        final List<EmployeeImportDTO> employeesDTO = employeeImportWrapperDTO.getEmployees();

        for (EmployeeImportDTO employeeDTO : employeesDTO) {

            try {

                final EmployeeCard card = this.cardRepository.findByNumber(employeeDTO.getCard());

                final Branch branch = this.branchRepository.findByName(employeeDTO.getBranch());

                final Employee employee = this.mapper.map(employeeDTO, Employee.class);

                employee.setCard(card);
                employee.setBranch(branch);

                this.employeeRepository.saveAndFlush(employee);

                this.sb.append(String.format(SUCCESSFUL_IMPORT_MESSAGE, employee.getClass().getSimpleName(), employee.getFullName()))
                        .append(System.lineSeparator());

            } catch (Exception e) {
                this.sb.append(INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
            }
        }

        return this.sb.toString().trim();
    }

    @Override
    public String exportProductiveEmployees() {

        this.sb.delete(0, this.sb.length() - 1);

        final List<Employee> employees =
                this.employeeRepository.findAllEmployeesOnBranchWithAtLeastOneProduct();

        final List<EmployeeDataExportDTO> result = employees
                .stream()
                .map(e -> this.mapper.map(e, EmployeeDataExportDTO.class))
                .collect(Collectors.toList());

        result
                .forEach(e -> this.sb.append(e).append(System.lineSeparator()));

        return this.sb.toString().trim();
    }
}
