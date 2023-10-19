package bg.softuni.temp.model.entity;

import bg.softuni.temp.model.entity.enums.StyleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "styles")
public class Style extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private StyleEnum name;

    @Column
    private String description;

    @OneToMany(mappedBy = "style")
    private List<Song> songs;
}
