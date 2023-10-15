package com.example.planner_app.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2, max = 50)
    private String description;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @ManyToOne
    private Priority priority;

    @ManyToOne
    private User user;
}
