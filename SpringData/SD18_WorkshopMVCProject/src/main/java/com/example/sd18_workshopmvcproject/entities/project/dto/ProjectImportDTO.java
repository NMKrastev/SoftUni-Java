package com.example.sd18_workshopmvcproject.entities.project.dto;

import com.example.sd18_workshopmvcproject.entities.company.dto.CompanyImportDTO;
import com.example.sd18_workshopmvcproject.utils.LocalDateAdapter;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectImportDTO {

    @XmlElement
    private String name;

    @XmlElement
    private String description;

    @XmlElement(name = "is-finished")
    private Boolean isFinished;

    @XmlElement
    private BigDecimal payment;

    @XmlElement(name = "start-date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate startDate;

    @XmlElement(name = "company")
    private CompanyImportDTO company;
}
