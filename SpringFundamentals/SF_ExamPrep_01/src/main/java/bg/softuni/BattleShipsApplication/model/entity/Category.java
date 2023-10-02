package bg.softuni.BattleShipsApplication.model.entity;

import bg.softuni.BattleShipsApplication.model.entity.enums.CategoryEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;
}
