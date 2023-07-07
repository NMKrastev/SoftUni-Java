package com.example.sd18_workshopmvcproject.services.employee;

import com.example.sd18_workshopmvcproject.entities.employee.Employee;
import com.example.sd18_workshopmvcproject.entities.employee.dto.EmployeeImportWrapperDTO;
import com.example.sd18_workshopmvcproject.entities.project.Project;
import com.example.sd18_workshopmvcproject.repositories.EmployeeRepository;
import com.example.sd18_workshopmvcproject.repositories.ProjectRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

import static com.example.sd18_workshopmvcproject.constants.Messages.*;
import static com.example.sd18_workshopmvcproject.constants.Paths.EMPLOYEES_FILE_PATH;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final ModelMapper mapper;
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    public EmployeeServiceImpl(ModelMapper mapper, EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
        this.mapper = mapper;
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public boolean areImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String getXMLContent() throws IOException {

        return new String(Files.readAllBytes(EMPLOYEES_FILE_PATH));
    }

    @Override
    public void importEmployees() throws JAXBException, IOException {

        final String xmlContent = this.getXMLContent();

        final ByteArrayInputStream stream = new ByteArrayInputStream(xmlContent.getBytes());

        final JAXBContext context = JAXBContext.newInstance(EmployeeImportWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final EmployeeImportWrapperDTO employeesDTO =
                (EmployeeImportWrapperDTO) unmarshaller.unmarshal(stream);

        try {

            final List<Employee> employees = employeesDTO.getEmployees()
                    .stream()
                    .map(employeeDTO -> this.mapper.map(employeeDTO, Employee.class))
                    .map(this::setProject)
                    .map(this.employeeRepository::saveAndFlush)
                    .toList();

        } catch (Exception e) {

            System.out.println(INVALID_EMPLOYEE);
        }
    }

    @Override
    public String exportEmployeesAboveAgeOf25() {

        final int age = 25;

        final List<Employee> employees = this.employeeRepository.findAllByAgeGreaterThan(age);

        final StringBuilder sb = new StringBuilder();

        employees
                .forEach(e ->
                        sb.append(String.format(EMPLOYEE_NAME_FORMAT, e.getFullName()))
                                .append(System.lineSeparator())
                                .append(String.format(EMPLOYEE_AGE_FORMAT, e.getAge()))
                                .append(System.lineSeparator())
                                .append(String.format(PROJECT_NAME_FORMAT2, e.getProject().getName()))
                                .append(System.lineSeparator()));

        return sb.toString().trim();
    }

    private Employee setProject(Employee employee) {

        final String projectName = employee.getProject().getName();

        final Optional<Project> optionalProject = this.projectRepository.findByName(projectName);

        if (optionalProject.isPresent()) {

            final Project project = optionalProject.get();

            employee.setProject(project);

            return employee;
        }

        return employee;
    }
}
