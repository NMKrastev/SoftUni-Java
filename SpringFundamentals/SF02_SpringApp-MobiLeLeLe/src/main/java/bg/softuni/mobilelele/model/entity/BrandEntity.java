package bg.softuni.mobilelele.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ModelEntity> models;

}
