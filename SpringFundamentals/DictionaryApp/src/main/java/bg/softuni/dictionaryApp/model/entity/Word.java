package bg.softuni.dictionaryApp.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "words")
public class Word extends BaseEntity {

    @NotNull
    @Size(min = 2, max = 40)
    private String term;

    @NotNull
    @Size(min = 2, max = 80)
    private String translation;

    @Size(min = 2, max = 200)
    private String example;

    @NotNull
    private LocalDate inputDate;

    @ManyToOne(optional = false)
    private Language language;

    @ManyToOne
    private User addedBy;

}
