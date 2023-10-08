package bg.softuni.resellerapp.model.entity;

import bg.softuni.resellerapp.model.enums.ConditionTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private ConditionTypeEnum name;

    @Column(nullable = false)
    private String description;
}
