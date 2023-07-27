package softuni.exam.models.dto.city;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityImportDTO {

    @NotNull
    @Size(min = 2, max = 60)
    private String cityName;

    @Size(min = 2)
    private String description;

    @NotNull
    @Min(500)
    private int population;

    @NotNull
    @Positive
    private Long country;
}
