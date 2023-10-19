package bg.softuni.temp.model.dto;

import bg.softuni.temp.model.entity.enums.StyleEnum;
import bg.softuni.temp.validation.FutureDate;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddSongDTO {

    @NotBlank
    @Size(min = 3, max = 20)
    private String performer;

    @NotBlank
    @Size(min = 2, max = 20)
    private String title;

    @NotNull
    @Positive
    private Integer duration;

    @FutureDate
    @NotBlank
    private String releaseDate;

    @NotNull
    private StyleEnum style;
}
