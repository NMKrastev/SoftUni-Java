package bg.softuni.dictionaryApp.model.entity;

import bg.softuni.dictionaryApp.model.entity.enums.LanguageEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "languages")
public class Language extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private LanguageEnum name;

    @Column(nullable = false)
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "language")
    private Set<Word> words;

    public Language() {
        this.words = new HashSet<>();
    }
}
