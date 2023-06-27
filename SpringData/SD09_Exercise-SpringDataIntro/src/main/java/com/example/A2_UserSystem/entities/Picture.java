package com.example.A2_UserSystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    @Size(max = 1000)
    private String caption;

    @Column(columnDefinition = "TEXT")
    @Size(max = 1000)
    private String path;

}
