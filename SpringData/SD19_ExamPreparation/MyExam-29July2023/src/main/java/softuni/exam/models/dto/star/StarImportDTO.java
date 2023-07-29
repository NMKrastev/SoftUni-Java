package softuni.exam.models.dto.star;

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
public class StarImportDTO {

    @NotNull
    @Size(min = 6)
    private String description;

    @NotNull
    @Positive
    private double lightYears;

    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @NotNull
    private String starType;

    @NotNull
    private Long constellation;
}
