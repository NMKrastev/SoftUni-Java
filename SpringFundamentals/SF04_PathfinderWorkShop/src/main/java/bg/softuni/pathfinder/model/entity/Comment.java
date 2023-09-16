package bg.softuni.pathfinder.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    @Column
    private boolean approved;

    @Column
    private LocalDateTime created;

    @Column(name = "text_content", nullable = false)
    @Lob
    private String textContent;

    @ManyToOne
    private User author;

    @ManyToOne
    private Route route;


}
