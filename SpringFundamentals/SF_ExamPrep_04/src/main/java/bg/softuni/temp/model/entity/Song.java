package bg.softuni.temp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "songs")
public class Song extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 3, max = 20)
    private String performer;

    @Column(nullable = false)
    @Size(min = 2, max = 20)
    private String title;

    @Column(nullable = false)
    @Positive
    private Integer duration;

    @Column(nullable = false)
    @NotNull
    private LocalDate releaseDate;

    @ManyToMany(mappedBy = "playlist")
    private List<User> user;

    @ManyToOne
    private Style style;
}
