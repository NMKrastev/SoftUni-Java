package bg.softuni.dictionaryApp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WordDTO {

    private Long id;

    private String term;

    private String translation;

    private String example;

    private LocalDate inputDate;

    private LanguageDTO language;

    private UserDTO addedBy;
}
