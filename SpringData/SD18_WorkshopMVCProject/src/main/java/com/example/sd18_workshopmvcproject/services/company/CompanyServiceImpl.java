package com.example.sd18_workshopmvcproject.services.company;

import com.example.sd18_workshopmvcproject.entities.company.Company;
import com.example.sd18_workshopmvcproject.entities.company.dto.CompanyImportWrapperDTO;
import com.example.sd18_workshopmvcproject.repositories.CompanyRepository;
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

import static com.example.sd18_workshopmvcproject.constants.Paths.COMPANIES_FILE_PATH;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final ModelMapper mapper;
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(ModelMapper mapper, CompanyRepository companyRepository) {
        this.mapper = mapper;
        this.companyRepository = companyRepository;
    }

    @Override
    public boolean areImported() {
        return this.companyRepository.count() > 0;
    }

    @Override
    public String getXMLContent() throws IOException {

        return new String(Files.readAllBytes(COMPANIES_FILE_PATH));
    }

    @Override
    public void importCompanies() throws IOException, JAXBException {

        final String xmlContent = this.getXMLContent();

        final ByteArrayInputStream stream = new ByteArrayInputStream(xmlContent.getBytes());

        final JAXBContext context = JAXBContext.newInstance(CompanyImportWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final CompanyImportWrapperDTO companiesDTO =
                (CompanyImportWrapperDTO) unmarshaller.unmarshal(stream);


        try {

            final List<Company> companies = companiesDTO.getCompanies()
                    .stream()
                    .map(companyDTO -> this.mapper.map(companyDTO, Company.class))
                    .map(this.companyRepository::saveAndFlush)
                    .toList();

        } catch (Exception e) {

            System.out.println("Invalid company!");
        }
    }
}
