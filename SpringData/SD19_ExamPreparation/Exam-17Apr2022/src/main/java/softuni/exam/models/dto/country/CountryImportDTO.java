package softuni.exam.models.dto.country;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryImportDTO {

    @NotNull
    @Size(min = 2, max = 60)
    private String countryName;

    @NotNull
    @Size(min = 2, max = 60)
    private String currency;
}
