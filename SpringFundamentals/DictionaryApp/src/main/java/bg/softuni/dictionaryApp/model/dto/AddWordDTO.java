package bg.softuni.dictionaryApp.model.dto;

import bg.softuni.dictionaryApp.model.entity.enums.LanguageEnum;
import bg.softuni.dictionaryApp.validation.FutureDate;
import bg.softuni.dictionaryApp.validation.WordExist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddWordDTO {

    @NotBlank(message = "Term must not be empty!")
    @Size(min = 2, max = 40, message = "Term must be between 2 and 40 characters!")
    @WordExist
    private String term;

    @NotBlank(message = "Translation must not be empty!")
    @Size(min = 2, max = 80, message = "Translation must be between 2 and 80 characters!")
    private String translation;

    @NotBlank(message = "Example must not be empty!")
    @Size(min = 2, max = 200, message = "Example must be between 2 and 200 characters!")
    private String example;

    @FutureDate
    private String inputDate;

    @NotNull(message = "Language must be selected!")
    private LanguageEnum language;
}
