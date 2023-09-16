package bg.softuni.pathfinder.model.entity;

import bg.softuni.pathfinder.model.enums.CategoryEnumType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CategoryEnumType name;

    @Column(columnDefinition = "TEXT")
    private String description;
}
