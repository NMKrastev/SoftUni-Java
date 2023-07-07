package com.example.sd18_workshopmvcproject.services.project;

import com.example.sd18_workshopmvcproject.entities.company.Company;
import com.example.sd18_workshopmvcproject.entities.project.Project;
import com.example.sd18_workshopmvcproject.entities.project.dto.ProjectImportWrapperDTO;
import com.example.sd18_workshopmvcproject.repositories.CompanyRepository;
import com.example.sd18_workshopmvcproject.repositories.ProjectRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

import static com.example.sd18_workshopmvcproject.constants.Messages.*;
import static com.example.sd18_workshopmvcproject.constants.Paths.PROJECTS_FILE_PATH;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ModelMapper mapper;
    private final ProjectRepository projectRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public ProjectServiceImpl(ModelMapper mapper, ProjectRepository projectRepository, CompanyRepository companyRepository) {
        this.mapper = mapper;
        this.projectRepository = projectRepository;
        this.companyRepository = companyRepository;
    }


    @Override
    public boolean areImported() {
        return this.projectRepository.count() > 0;
    }

    @Override
    public String getXMLContent() throws IOException {
        return new String(Files.readAllBytes(PROJECTS_FILE_PATH));
    }

    @Override
    public void importProjects() throws IOException, JAXBException {

        final String xmlContent = this.getXMLContent();

        final ByteArrayInputStream stream = new ByteArrayInputStream(xmlContent.getBytes());

        final JAXBContext context = JAXBContext.newInstance(ProjectImportWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final ProjectImportWrapperDTO projectsDTO =
                (ProjectImportWrapperDTO) unmarshaller.unmarshal(stream);

        try {

            final List<Project> projects = projectsDTO.getProjects()
                    .stream()
                    .map(projectDTO -> this.mapper.map(projectDTO, Project.class))
                    .map(this::setCompany)
                    .map(this.projectRepository::saveAndFlush)
                    .toList();

        } catch (Exception e) {

            System.out.println(INVALID_PROJECT);
        }
    }

    @Override
    public String exportFinishedProjects() {

        final boolean isFinished = true;

        final List<Project> finishedProjects = this.projectRepository.findAllByIsFinished(isFinished);

        final StringBuilder sb = new StringBuilder();

        finishedProjects
                .forEach(p ->
                        sb.append(String.format(PROJECT_NAME_FORMAT, p.getName()))
                                .append(System.lineSeparator())
                                .append(String.format(DESCRIPTION_FORMAT, p.getDescription()))
                                .append(System.lineSeparator())
                                .append(String.format(PAYMENT_FORMAT, p.getPayment()))
                                .append(System.lineSeparator()));

        return sb.toString().trim();
    }

    private Project setCompany(Project project) {

        final String companyName = project.getCompany().getName();

        final Optional<Company> optionalCompany = this.companyRepository.findByName(companyName);

        if (optionalCompany.isPresent()) {
            final Company company = optionalCompany.get();
            project.setCompany(company);
        } else {
            project.setCompany(null);
        }

        return project;
    }
}
