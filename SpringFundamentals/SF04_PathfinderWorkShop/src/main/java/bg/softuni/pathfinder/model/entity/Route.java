package bg.softuni.pathfinder.model.entity;

import bg.softuni.pathfinder.model.enums.LevelEnumType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "routes")
public class Route extends BaseEntity {

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    private LevelEnumType level;

    @Column
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    private User author;

    @Column(name = "video_url")
    private String videoUrl;

    @OneToMany(targetEntity = Comment.class, mappedBy = "route", cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @ManyToMany
    private Set<Category> categories;

    @OneToMany(mappedBy = "route", fetch = FetchType.EAGER)
    private Set<Picture> pictures;

    public Route() {
        this.comments = new HashSet<>();
        this.categories = new HashSet<>();
        this.pictures = new HashSet<>();
    }
}
