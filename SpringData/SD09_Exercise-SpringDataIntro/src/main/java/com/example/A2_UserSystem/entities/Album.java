package com.example.A2_UserSystem.entities;

import com.example.A2_UserSystem.entities.enums.BackgroundColorType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "albums")
public class Album extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "background_color", nullable = false)
    private BackgroundColorType colorType;

    @Column(name = "is_public", nullable = false)
    private Boolean isPublic;

    @ManyToMany
    @JoinTable(name = "albums_pictures", joinColumns = @JoinColumn(name = "album_id"), inverseJoinColumns = @JoinColumn(name = "picture_id"))
    private Set<Picture> pictures;

}
