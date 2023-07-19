package com.example.football.models.dto.player;

import com.example.football.models.dto.stat.StatIdDTO;
import com.example.football.models.dto.team.TeamNameDTO;
import com.example.football.models.dto.town.TownNameDTO;
import com.example.football.models.entity.PositionType;
import com.example.football.util.LocalDateAdapter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerImportDTO {

    @XmlElement(name = "first-name")
    private String firstName;

    @XmlElement(name = "last-name")
    private String lastName;

    @XmlElement
    private String email;

    @XmlElement(name = "birth-date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate birthDate;

    @XmlElement
    private PositionType position;

    @XmlElement
    private TownNameDTO town;

    @XmlElement
    private TeamNameDTO team;

    @XmlElement
    private StatIdDTO stat;
}
