package softuni.exam.domain.dtos.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import softuni.exam.domain.dtos.picture.PictureImportDTO;
import softuni.exam.domain.dtos.team.TeamImportDTO;
import softuni.exam.domain.entities.PositionType;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerImportDTO {

    private String firstName;

    private String lastName;

    private int number;

    private BigDecimal salary;

    private PositionType position;

    private PictureImportDTO picture;

    private TeamImportDTO team;

}
