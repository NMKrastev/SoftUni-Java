package com.example.sf07_thymeleafandvalidation.service;

import com.example.sf07_thymeleafandvalidation.model.dto.CompanyDTO;
import com.example.sf07_thymeleafandvalidation.model.entity.Company;
import com.example.sf07_thymeleafandvalidation.model.mapper.CompanyMapper;
import com.example.sf07_thymeleafandvalidation.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public CompanyService(CompanyRepository companyRepository, CompanyMapper companyMapper) {

        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    public List<CompanyDTO> getAllCompanies() {

        return this.companyRepository
                .findAll()
                .stream()
                .map(this.companyMapper::companyToCompanyDTO)
                .toList();
    }

    public boolean registerCompany(CompanyDTO companyDTO) {

        if (this.companyRepository.findByName(companyDTO.getName()).isPresent()) {
            return false;
        }

        final Company company = this.companyMapper.companyDtoToCompany(companyDTO);

        this.companyRepository.save(company);

        return true;
    }

    public CompanyDTO findCompanyByName(String name) {

        return this.companyRepository
                .findByName(name)
                .map(this.companyMapper::companyToCompanyDTO)
                .get();
    }

    public boolean deleteCompany(String name) {

        final Company company = this.companyRepository.findByName(name).get();

        this.companyRepository.delete(company);

        return this.companyRepository.findByName(name).isEmpty();
    }

    public Company findByName(String name) {
        return this.companyRepository
                .findByName(name)
                .get();
    }
}
