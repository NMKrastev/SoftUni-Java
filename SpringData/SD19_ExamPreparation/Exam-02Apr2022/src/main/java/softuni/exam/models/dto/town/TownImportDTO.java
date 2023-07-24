package softuni.exam.models.dto.town;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TownImportDTO {

    @NotNull
    @Size(min = 2)
    private String townName;

    @NotNull
    @Positive
    private int population;

}
