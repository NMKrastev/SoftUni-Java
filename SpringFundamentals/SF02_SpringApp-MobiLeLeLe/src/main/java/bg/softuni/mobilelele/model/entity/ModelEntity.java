package bg.softuni.mobilelele.model.entity;

import bg.softuni.mobilelele.model.enums.CategoryEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @Column(name = "image_url", columnDefinition = "BLOB")
    @Size(min = 8, max = 512)
    private String imageUrl;

    @Column(name = "star_year")
    private int startYear;

    @Column(name = "end_year")
    private Integer endYear;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    @ManyToOne(cascade = CascadeType.ALL)
    private BrandEntity brand;

    @OneToMany(mappedBy = "model")
    private List<OfferEntity> offer;
}
